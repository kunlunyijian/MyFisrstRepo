package charpter09.caculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 将中缀表达式转换成后缀表达式
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
	//本人修改后的快捷键  ctrl + alt + n 复制一行                  ctrl + alt + m 复制多行
	public ArrayList<String> convert(String infix){
		ArrayList<String> tokenList = new ArrayList<String>();
		
		Stack<String> postStack = new Stack<String>();
		String tempToken;
		boolean precedence = true;
		char tempChar;
		String input;
		input = infix;
		//扫描input
		Scanner scanner = new Scanner(input);
		for(int scan = 0; scan < input.length(); scan++){
			
			while(scanner.hasNext()){
				tempToken = scanner.next();
				tempToken = tempToken.toString();//有意思吗？
				//the only valid token of length greater than 1 is a multiple digit number, thus if the token is of 
				//length greater than 1 add it to the result  
				//长度大于1的一定是操作数，而且是多位数
				if(tempToken.length() > 1){
					tokenList.add(tempToken);//到时候应该要逆向输出
				}else if(tempToken.length() == 1){
					//if the token is of length 1 and is a digit, add it to the result
					tempChar = tempToken.charAt(0);
					if(tempChar >= '0' && tempChar <= '9'){
						tokenList.add(tempToken);//到时候应该要逆向输出  
					}else if(tempToken.equals("(")){//if the token is a left parenthesis, push it on the stack
						
						postStack.push(tempToken);
						
					}else if(tempToken.equals(")")){//if the token is a right parenthesis,empty the stack down to
						
						//the matching left parenthesis adding those tokens to the result 
						//4.遇到右括号：执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出
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
						//5.遇到其他运算符：加减乘除：弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
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
								//将左括号以上的所有优先级大于等于当前扫描到的的运算符添加到tokenList中
								String top2 = postStack.peek();
								if((tempToken.equals("+") || tempToken.equals("-")) 
										&& (top2.equals("*") || top2.equals("/"))){
									precedence = true;
								}else if(top2.equals("(")){
									
									precedence = true;
								}else{
									precedence = false;
								}
							//上面是为了更新precedence	，因为postStack.pop()之后，再回到前面peek()到的元素是不一样的，不过我觉得下面这一行
							//语句是可以与上面那一块交换顺序的
								
								tokenList.add(postStack.pop());
							}
							
							//Push the current operator on the stack
							postStack.push(tempToken);
						 }
					}else{//错误处理
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
			//逆序
			int counter = tokenList.size();
			ArrayList<String> reverseOrder = new ArrayList<String>();
			for(int i = 0; i < counter; i++){
				reverseOrder.add(tokenList.get(counter - 1 - i));
			}
		}
		
		
		return null;
		
	}
}
