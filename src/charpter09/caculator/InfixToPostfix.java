package charpter09.caculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * ����׺���ʽת���ɺ�׺���ʽ
 * @author Arnold
 * Provides an implementation of an infix to postfix converter for expressions
 *
 */

/**
 *  Infix to Postfix Conversion:
 *  
 *  Scan the input String using Scanner
 *  
 *  While there are more tokens
 *  	If the next token is of length greater than 1, it is a multiple digit number and is added to the result
 *  
 *  	Else if the next token is 1 digit number, it is added to the result 
 *  	
 *  	Else if the next token is right parenthesis,
 *  	 	Pop elements off a the stack, adding them to the result until the top element of the stack is a
 *  		matching left parenthesis
 *  		Pop the left parenthesis off a the stack
 *  
 *  	Else if the next token is an operator (+,-,*,/)
 *  	Then compare the token to the top of the stack to determine precedence 
 *  	While the operator on the stack has precedence
 *  	Pop the top element off of the stack and add it to the result 
 *  	Push the current operator on the stack
 *  
 *  While there are elements remaining on the stack
 *  	Pop the top element off of a the stack and add it to the result
 *  
 *  the result is a postfix expression in reverse order so reverse it and return it 
 * 
 *
 */
public class InfixToPostfix {
	
	public InfixToPostfix(){
		
	}
	
	/**
	 * Returns a postfix expression of this infix string as a list.
	 * 
	 */
	//�����޸ĺ�Ŀ�ݼ�  ctrl + alt + n ����һ��                  ctrl + alt + m ���ƶ���
	public ArrayList<String> convert(String infix){
		ArrayList<String> tokenList = new ArrayList<String>();
		
		Stack<String> postStack = new Stack<String>();
		String tempToken;
		boolean precedence = true;
		char tempChar;
		String input;
		input = infix;
		//ɨ��input
		Scanner scanner = new Scanner(input);
		for(int scan = 0; scan < input.length(); scan++){
			
			while(scanner.hasNext()){
				tempToken = scanner.next();
				tempToken = tempToken.toString();//����˼��
				//the only valid token of length greater than 1 is a multiple digit number, thus if the token is of 
				//length greater than 1 add it to the result  
				//���ȴ���1��һ���ǲ������������Ƕ�λ��
				if(tempToken.length() > 1){
					tokenList.add(tempToken);//��ʱ��Ӧ��Ҫ�������
				}else if(tempToken.length() == 1){
					//if the token is of length 1 and is a digit, add it to the result
					tempChar = tempToken.charAt(0);
					if(tempChar >= '0' && tempChar <= '9'){
						tokenList.add(tempToken);//��ʱ��Ӧ��Ҫ�������  
					}else if(tempToken.equals("(")){//if the token is a left parenthesis, push it on the stack
						
						postStack.push(tempToken);
						
					}else if(tempToken.equals(")")){//if the token is a right parenthesis,empty the stack down to
						
						//the matching left parenthesis adding those tokens to the result 
						//4.���������ţ�ִ�г�ջ������������ջ��Ԫ�������ֱ������ջ���������ţ������Ų����
						while(!postStack.isEmpty() && postStack.peek() != "("){
							tokenList.add(postStack.pop());
						}
						//take the matching left parenthesis off of the stack
						if(!postStack.isEmpty()){
							
							postStack.pop();
						}
					}else if(tempToken.equals("*")||tempToken.equals("/")||
							tempToken.equals("+")||tempToken.equals("-")){//if the token is an operator
							//if the stack is not empty, meaning that we are dealing with altered precedure
							//due to parens, determine the precedence between the elements on the stack and 
							//the next token(operator)
						//5.����������������Ӽ��˳��������������ȼ����ڻ��ߵ��ڸ��������ջ��Ԫ�أ�Ȼ�󽫸��������ջ
						 if(!postStack.isEmpty()){
							String top = postStack.peek() + "";
							if(( top.equals("+")||top.equals("-") )&&
									( tempToken.equals("*")||tempToken.equals("/") )){
								precedence = false;
							}else if(top.equals("(")){
								
								precedence = false;
								
							}else{
								
								precedence = true;
							}
							while(!postStack.isEmpty() && postStack.peek() != "(" && precedence){
								//�����������ϵ��������ȼ����ڵ��ڵ�ǰɨ�赽�ĵ��������ӵ�tokenList��
								String top2 = postStack.peek();
								if((tempToken.equals("+") || tempToken.equals("-")) 
										&& (top2.equals("*") || top2.equals("/"))){
									precedence = true;
								}else if(top2.equals("(")){
									
									precedence = true;
								}else{
									precedence = false;
								}
							//������Ϊ�˸���precedence	����ΪpostStack.pop()֮���ٻص�ǰ��peek()����Ԫ���ǲ�һ���ģ������Ҿ���������һ��
							//����ǿ�����������һ�齻��˳���
								
								tokenList.add(postStack.pop());
							}
							
							//Push the current operator on the stack
							postStack.push(tempToken);
						 }
					}else{//������
						System.out.println(tempToken + "is illegal!!");
						System.exit(1);
					}
					
				}
			}//end while
			//place whatever tokens remain on the stack on  the result list
			while(!postStack.isEmpty()){
				tokenList.add(postStack.pop());
			}
			scanner.close();
			//����
			int counter = tokenList.size();
			ArrayList<String> reverseOrder = new ArrayList<String>();
			for(int i = 0; i < counter; i++){
				reverseOrder.add(tokenList.get(counter - 1 - i));
			}
		}
		
		
		return null;
		
	}
}
