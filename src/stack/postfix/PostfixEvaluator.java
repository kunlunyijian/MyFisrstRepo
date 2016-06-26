package stack.postfix;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * 表示后缀表达式的求值程序。假设操作数都是常数
 * @author Administrator
 *
 */
public class PostfixEvaluator {
	
	Stack<Integer> operandStack;
	
	
	public PostfixEvaluator() {
		
		operandStack = new Stack<Integer>();
		
	}

	public int evaluate(String expr){
		
		int result = 0;
		String token;
		StringTokenizer tokenizer = new StringTokenizer(expr);//用来解析expr，以空格为分界符号
		if(expr != null){
			for(int index = 0; index < expr.length(); index++){
				char valueStr = expr.charAt(index);
				if(isOperator(valueStr)){//如果是操作符
					Integer operandRight = operandStack.pop();
					int op2 = operandRight.intValue();
					Integer operandLeft = operandStack.pop();
					int op1 = operandLeft.intValue();
					//计算指定的运算符和操作数组组成的简单表达式
					result = evalSingleOp(valueStr,op1,op2);
					//将计算结果压入堆栈
					operandStack.push(new Integer(result));
					
				}else{//如果是操作数则入栈
					int parseInt = Integer.parseInt(String.valueOf(valueStr));
					Integer integer = new Integer(parseInt);
					operandStack.push(integer);
				}
				
			}
			
		}
		
		return result;
	}
	
	/**
	 * 
	 * 计算指定的运算符和操作数组组成的简单表达式
	 * @param valueStr
	 * @param op1
	 * @param op2
	 * @return
	 */
	private int evalSingleOp(char valueStr, int op1, int op2) {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean isOperator(char valueStr) {
		// TODO Auto-generated method stub
		return false;
	}
}
