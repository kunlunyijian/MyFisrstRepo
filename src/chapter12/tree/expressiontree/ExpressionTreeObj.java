package chapter12.tree.expressiontree;
/**
 * Represents an element in an expression tree.
 * @author Arnold
 *
 */
public class ExpressionTreeObj {
	private int termtype;// 1  代表是操作符
	private char operator;
	private int value;
	/**
	 * 用指定的数据构造出一个表达式树节点对象
	 */
	public ExpressionTreeObj(int type, char op, int val) {
		termtype = type;
		operator = op;
		value  = val;
	}
	
	public boolean isOperator(){
		return termtype == 1;
	}

	public char getOperator() {
		return operator;
	}

	public int getValue() {
		return value;
	}
	
}
