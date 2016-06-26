package charpter09.caculator;

import java.util.List;
import java.util.Stack;


/**
 * provides an evaluator for postfix expressions presented
 * @author Administrator
 *
 */
public class ListPostfixEvaluator {
	
  public ListPostfixEvaluator() {
	  
  }
  
  public int evaluate(List<String> tokenList){
	  Stack<Integer> inStack = new Stack<Integer>();//用来存放操作数
//	  int index = 0;
	  int oprand1 = 0;
	  int oprand2 = 0;
	  int toPush = 0;
	  
	  String tempToken;
	  char tempChar;
	  for(String str: tokenList){
		  tempToken = str;
		  if(tempToken.length() > 1){
			  inStack.push(Integer.parseInt(tempToken));
		  }else if(tempToken.length() == 1){
			  tempChar = tempToken.charAt(0);
			//if operand
			  if(tempChar >= '0' && tempChar <= '9'){
					inStack.push(Integer.parseInt(tempToken));
				}else if(tempToken.equals("*")||tempToken.equals("/")||
						tempToken.equals("+")||tempToken.equals("-")){
					//get operator/operands for calculation
					oprand1 = inStack.pop();
					oprand2 = inStack.pop();
					tempChar = tempToken.charAt(0);
					//calculate
					switch(tempChar){
						case '*': toPush = oprand1 * oprand2;
						break;
						case '/': toPush = oprand1 / oprand2;
						break;
						case '+': toPush = oprand1 + oprand2;
						break;
						case '-': toPush = oprand1 - oprand2;
						break;
					}
					inStack.push(toPush);
				}
		  }
//		index++;  
	  }
	  return (inStack.pop());
  }
}
