package chapter12.tree.expressiontree.postfix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import chapter12.tree.expressiontree.ExpressionTree;
import chapter12.tree.expressiontree.ExpressionTreeObj;

/**
 *����һ��ջ������Ч�ĺ�׺���ʽ ������һ�����ʽ����Ȼ�����ñ��ʽ���ĵݹ���㷽��������ʽ��
 * @author Arnold
 *
 */
public class PostfixEvaluator2 {
	public void solve() throws IOException{
		char operator;
		ExpressionTree operand1;
		ExpressionTree operand2;
		String tempToken;
		Stack<ExpressionTree> tree_stack = new Stack<ExpressionTree>();//ע��˴���ŵĶ����������������������ڵ�   �����P295
		System.out.println("Enter a valid post-fix expression one token at a time pressing the enter key after each token");
		System.out.println("Enter an integer, an operator(+,-.*,/) or ! to quit ");
		tempToken = get_next_token();
		operator = tempToken.charAt(0);
		while(!(operator == '!')){
			if((operator == '+') || (operator == '-') || (operator == '*') || (operator == '/') ){
				//������������һ�����������򵯳���ջ���ϵ�����ExpressionTrees,ʹ�ø����Ĳ�����ֵ����һ���µ�ExpressionTreeObj
				//ʹ�øò�������Ϊ����ʹ�ôӸ�ջ��������������ExpressionTrees��Ϊ��ߺ��ұ�����������һ���µ�ExpressionTree
				operand1 = get_operand(tree_stack);
				operand2 = get_operand(tree_stack);
				tree_stack.push(new ExpressionTree(new ExpressionTreeObj(1, operator, 0), operand1, operand2));
			}else{
				//���������ǲ���������ʹ�ø�ָ��ֵ����һ���µ�ExpressionTreeObj,Ȼ����һ��ExpressionTree
				//������ʹ�ø�Ԫ����Ϊ������û�к��ӣ�Ȼ���µ�ExpressionTreeѹ��ĳ��ջ
				tree_stack.push(new ExpressionTree(new ExpressionTreeObj(2, ' ', Integer.parseInt(tempToken)), null, null));
			}
			tempToken = get_next_token();
			operator = tempToken.charAt(0);
		}
		
		System.out.print("���Ϊ�� ");
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
