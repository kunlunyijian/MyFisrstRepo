package stack.postfix;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * ��ʾ��׺���ʽ����ֵ���򡣼�����������ǳ���
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
		StringTokenizer tokenizer = new StringTokenizer(expr);//��������expr���Կո�Ϊ�ֽ����
		if(expr != null){
			for(int index = 0; index < expr.length(); index++){
				char valueStr = expr.charAt(index);
				if(isOperator(valueStr)){//����ǲ�����
					Integer operandRight = operandStack.pop();
					int op2 = operandRight.intValue();
					Integer operandLeft = operandStack.pop();
					int op1 = operandLeft.intValue();
					//����ָ����������Ͳ���������ɵļ򵥱��ʽ
					result = evalSingleOp(valueStr,op1,op2);
					//��������ѹ���ջ
					operandStack.push(new Integer(result));
					
				}else{//����ǲ���������ջ
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
	 * ����ָ����������Ͳ���������ɵļ򵥱��ʽ
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
