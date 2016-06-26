package stack;

import java.util.Stack;



/**
 * 
 * @author Arnold
 * ��ʾ�ַ��Թ���Ŀ���Ǵ����ϽǴ��е����½�(���ű��Ϊ1��·��)
 * 
 */
public class Maze {
	private final int TRIED = 3;
	private final int PATH = 7;
	private int [][] grid = {{1,1,1,1,1,1,1,1,1,1},
				             {1,0,1,1,1,0,1,1,1,1},
				             {1,1,0,1,0,1,1,1,1,1},
				             {1,0,1,0,0,0,0,0,1,1},
				             {1,0,1,1,1,0,1,1,1,1},
				             {1,1,0,0,1,1,0,0,0,1},
				             {1,0,1,1,0,0,1,1,0,1},
				             {1,1,1,1,1,1,1,1,1,1}};
	/**
	 * 
	 * ���ջ���뵱ǰλ���ϵ���Ч�ƶ�
	 * @param x
	 * @param y
	 * @param stack
	 * @return
	 */
	private Stack<Position> push_new_pos(int x, int y, Stack<Position> stack){
		Position position = new Position();
		position.setX(x);
		position.setY(y);
		if(valid(x,y)){
			stack.push(position);
		}
		return stack;
	}
	
	/**
	 * �ж�ָ��λ���Ƿ���Ч
	 * @param x
	 * @param y
	 * @return
	 */
	
	private boolean valid(int row, int column) {
		boolean result  = false;
		//���ָ���ĵ�Ԫ�Ƿ��ھ���ı߽���
		if(row >= 0 && row < grid.length && column >= 0 && column < grid[row].length ){
			//���ָ���ĵ�Ԫ�Ƿ�����Լ��Ƿ��Ѿ����Թ�
			if(grid[row][column] == 1){
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * �����Ե������������Թ����÷��������ʾ�Ѿ����Թ���λ�õ������ַ���ͬʱ��λ�����ճ�Ϊ���������һ���֡�
	 * 
	 * �÷���ʹ�ö�ջ�����ٿ��Խ��еĵĿ����ƶ�
	 * traverse ����ѭ���������²���������ջ����λ���˳���������Ϊ�ѳ��ԣ�Ȼ�����Ƿ��Ѿ���ɡ����û����ɣ���ô��λ���ϵ�������Ч�ƶ�
	 * ����ѹ���ջȻ�����ѭ��
	 * @return
	 */
	public boolean traverse(){
		boolean done = false;
		Position position = new Position();
		Stack<Position> stack = new Stack<Position>();//�����洢λ��position
		stack.push(position);
		while(!done){
			
			position = stack.pop();//��ջ�������˴��ѳ���
			grid[position.getX()][position.getY()] = TRIED;//���
			if(position.getX() == grid.length -1 && position.getY() == grid[0].length - 1){//����Ƿ��Ѿ�������
				
				done = true;
				
			}else{
				
				stack = push_new_pos(position.getX(),position.getY() - 1,stack);//��
				stack = push_new_pos(position.getX(),position.getY() + 1,stack);//��
				stack = push_new_pos(position.getX() - 1,position.getY(),stack);//��
				stack = push_new_pos(position.getX() + 1,position.getY(),stack);//��
			}
		}
		return done;
	}
	
	/**
	 * �����Թ����ַ�����ʾ
	 * 
	 */
	public String toString(){
		String result = "\n";
		StringBuilder sb =  new StringBuilder();
		sb.append(result);
		for(int row = 0; row < grid.length; row++){
			for(int column = 0; column < grid[row].length; column++){
				sb.append(grid[row][column]+" ");
			}
			sb.append("\n");
		}
		result = sb.toString();
		return result;
	}
}
