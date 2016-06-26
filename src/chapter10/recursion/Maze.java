package chapter10.recursion;
/**
 * Represents a maze of characters. The goal is to get from the top
 * left corner to the bottom right, following a path of Is
 * @author Arnold
 * 一般来说栈与递归是可以相互转化的，使用递归的地方都可以改成栈的方式，反过来也一样。但在求解迷宫问题时，栈与递归代表了两种不同的指导思想，
 * 如果说栈式的搜索方法象征着英雄忒修斯的话，那么使用递归法则更像一位手握大权的领导。当他站在迷宫入口处时，他才懒得亲自去走，这时这位领导
 * 会吩咐他的手下，让他们分别向着迷宫的各个方向去探索；当遇到岔路口时留一个人守在这里，再分出几股人，朝着每个方向继续探索；最后总会有一个人
 * 发现出口。发现出口的这个人将出口的位置报告给离他最近的路口处留守的人，再由这个人报告给上一个路口的人，依次层层上报，最后消息传到了领导那里，
 * 于是这位领导就顺着这条画好的通路大摇大摆地通过了迷宫
 *
 */
public class Maze {
	private final int TRIED = 3;
	private final int PATH = 7;
//	private int [][] grid = {{1,1}};
//	
	private int [][] grid = {{1,1,1,1,1,1,1,1,1,1},
			{1,0,1,1,1,0,1,1,1,1},
			{1,1,0,1,0,1,1,1,1,1},
			{1,0,1,0,0,0,0,0,1,1},
			{0,0,1,1,1,0,1,1,1,1},
			{1,1,1,0,1,1,0,0,0,1},
			{1,0,1,1,0,0,1,1,0,1},
			{1,1,1,1,1,1,1,1,1,1}};
//	
	public boolean travese(int row, int column){
		boolean done = false;
		if(valid(row,column)){
			grid[row][column] = TRIED;//this cell  has been tried
			if(row == grid.length-1 && column == grid[0].length-1){
				done = true;
			}else{
				done = travese(row + 1, column);//down
				if(!done){
					done = travese(row , column + 1);//right
				}
				if(!done){
					done = travese(row - 1 , column );//up
				}
				if(!done){
					done = travese(row , column - 1);//left
				}
			}
			if(done){
				grid[row][column] = PATH;//此行代码是用来逐级填充路径的
			}
		}
		return done;
	}
	
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
	
	/**
	 * 递归迷宫解法
	 */
	public boolean traverse2(int row, int column){
		boolean done = false;
		if(valid(row, column)){//检查是否有效
			grid[row][column] = TRIED;
			if(row == grid.length - 1 && column == grid[0].length -1 ){//判断是否已到达出口
				done = true;
			}else{
				done = traverse2(row, column + 1);//right
				if(!done){
					
					done = traverse2(row, column - 1);//left
				}
				if(!done){
					
					done = traverse2(row + 1, column );//down
				}
				if(!done){
					
					done = traverse2(row - 1, column );//up
				}
				
			}
			if(done){
				grid[row][column] = PATH;
			}
		}
		return done;
	}
}
