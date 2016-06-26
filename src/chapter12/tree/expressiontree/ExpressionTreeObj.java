package chapter12.tree.expressiontree;
/**
 * Represents an element in an expression tree.
 * @author Arnold
 *
 */
public class ExpressionTreeObj {
	private int termtype;// 1  �����ǲ�����
	private char operator;
	private int value;
	/**
	 * ��ָ�������ݹ����һ�����ʽ���ڵ����
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
