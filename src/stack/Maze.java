package stack;

import java.util.Stack;



/**
 * 
 * @author Arnold
 * 表示字符迷宫。目标是从左上角穿行到右下角(沿着标记为1的路径)
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
	 * 向堆栈加入当前位置上的有效移动
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
	 * 判定指定位置是否有效
	 * @param x
	 * @param y
	 * @return
	 */
	
	private boolean valid(int row, int column) {
		boolean result  = false;
		//检测指定的单元是否在矩阵的边界内
		if(row >= 0 && row < grid.length && column >= 0 && column < grid[row].length ){
			//检测指定的单元是否封死以及是否已经尝试过
			if(grid[row][column] == 1){
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * 尝试以迭代方案穿过迷宫。该方法插入表示已经尝试过的位置的特殊字符，同时该位置最终成为解决方案的一部分。
	 * 
	 * 该方法使用堆栈来跟踪可以进行的的可能移动
	 * traverse 方法循环进行如下操作：将堆栈顶部位置退出，将其标记为已尝试，然后检测是否已经完成。如果没有完成，那么该位置上的所有有效移动
	 * 都被压入堆栈然后继续循环
	 * @return
	 */
	public boolean traverse(){
		boolean done = false;
		Position position = new Position();
		Stack<Position> stack = new Stack<Position>();//用来存储位置position
		stack.push(position);
		while(!done){
			
			position = stack.pop();//出栈，表明此处已尝试
			grid[position.getX()][position.getY()] = TRIED;//标记
			if(position.getX() == grid.length -1 && position.getY() == grid[0].length - 1){//检查是否已经到出口
				
				done = true;
				
			}else{
				
				stack = push_new_pos(position.getX(),position.getY() - 1,stack);//上
				stack = push_new_pos(position.getX(),position.getY() + 1,stack);//下
				stack = push_new_pos(position.getX() - 1,position.getY(),stack);//左
				stack = push_new_pos(position.getX() + 1,position.getY(),stack);//右
			}
		}
		return done;
	}
	
	/**
	 * 返回迷宫的字符串表示
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
