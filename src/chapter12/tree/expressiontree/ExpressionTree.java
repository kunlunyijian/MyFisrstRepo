package chapter12.tree.expressiontree;

import chapter12.tree.BinaryTreeNode;
import chapter12.tree.LinkedBinaryTree;
/**
 * 表示操作符和操作数的表达式树
 * @author Arnold
 *
 */

public class ExpressionTree extends LinkedBinaryTree<ExpressionTreeObj> {

	public ExpressionTree() {
		super();
	}

	public ExpressionTree(ExpressionTreeObj element,
			LinkedBinaryTree<ExpressionTreeObj> leftSubtree,
			LinkedBinaryTree<ExpressionTreeObj> rigthTree) {
		super(element, leftSubtree, rigthTree);
	}
	
	/**
	 * 调用递归计算方法evaluate_node() 来计算整个表达式树的值
	 * @return
	 */
	public int evaluate_tree(){
		return evaluate_node(root);
	}
	
	/**
	 * 递归计算指定树的每一个结点  值得细细体会（结合一个具体表达式的树）
	 * @param root
	 * @return
	 */
	
	public int evaluate_node(BinaryTreeNode<ExpressionTreeObj> root){
		int result = 0;
		int operand1;
		int operand2;
		if(root == null){
			result = 0;
		}else{
			ExpressionTreeObj temp = root.getElement();
			if( temp.isOperator() ){
				operand1 = evaluate_node(root.getLeft());
				operand2 = evaluate_node(root.getRight());
				result  = compute_term(temp.getOperator(),operand1,operand2);
			}
			result = temp.getValue();
		}
		
		return result;
	}

	private static int compute_term(char operator, int operand1, int operand2) {
		int result = 0;
		if(operator == '+'){
			result = operand1 + operand2;
		}else if(operator == '-'){
			result = operand1 - operand2;
		}else if(operator == '*'){
			result = operand1 * operand2;
		}else{
			result = operand1 / operand2;
		}
		return result;
	}

	@Override
	public String toString() {
		return "ExpressionTree [count=" + count + ", root=" + root + "]";
	}
		
		
}
