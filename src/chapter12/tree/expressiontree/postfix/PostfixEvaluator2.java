package chapter12.tree.expressiontree.postfix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import chapter12.tree.expressiontree.ExpressionTree;
import chapter12.tree.expressiontree.ExpressionTreeObj;

/**
 *利用一对栈来将有效的后缀表达式 构建成一个表达式树，然后利用表达式树的递归计算方法计算表达式树
 * @author Arnold
 *
 */
public class PostfixEvaluator2 {
	public void solve() throws IOException{
		char operator;
		ExpressionTree operand1;
		ExpressionTree operand2;
		String tempToken;
		Stack<ExpressionTree> tree_stack = new Stack<ExpressionTree>();//注意此处存放的对象类型是树，而不是树节点   详情见P295
		System.out.println("Enter a valid post-fix expression one token at a time pressing the enter key after each token");
		System.out.println("Enter an integer, an operator(+,-.*,/) or ! to quit ");
		tempToken = get_next_token();
		operator = tempToken.charAt(0);
		while(!(operator == '!')){
			if((operator == '+') || (operator == '-') || (operator == '*') || (operator == '/') ){
				//如果输入的项是一个操作符，则弹出该栈顶上的两个ExpressionTrees,使用给定的操作符值创建一个新的ExpressionTreeObj
				//使用该操作符作为根且使用从该栈顶弹出的那两个ExpressionTrees作为左边和右边子树来创建一个新的ExpressionTree
				operand1 = get_operand(tree_stack);
				operand2 = get_operand(tree_stack);
				tree_stack.push(new ExpressionTree(new ExpressionTreeObj(1, operator, 0), operand1, operand2));
			}else{
				//如果输入的是操作数，则使用该指定值创建一个新的ExpressionTreeObj,然后构造一个ExpressionTree
				//构造是使用该元素作为根并且没有孩子，然后将新的ExpressionTree压入某个栈
				tree_stack.push(new ExpressionTree(new ExpressionTreeObj(2, ' ', Integer.parseInt(tempToken)), null, null));
			}
			tempToken = get_next_token();
			operator = tempToken.charAt(0);
		}
		
		System.out.print("结果为： ");
		System.out.println(tree_stack.peek());
		System.out.println(tree_stack.peek().evaluate_tree());
	}
	
	private ExpressionTree get_operand(Stack<ExpressionTree> tree_stack) {
		ExpressionTree temp;
		temp = tree_stack.pop();
		return temp;
	}

	/**
	 * retrieves the next token, either an operator or operand from the user and returns it
	 * @return
	 * @throws IOException
	 */
	private String get_next_token() throws IOException {
		String tempToken = "0";
		String inString;
		StringTokenizer stringTokenizer;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		inString = in.readLine();
	    stringTokenizer = new StringTokenizer(inString);
	    tempToken = stringTokenizer.nextToken();
		return tempToken;
	}
}
