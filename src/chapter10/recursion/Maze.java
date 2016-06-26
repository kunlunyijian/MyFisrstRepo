package chapter10.recursion;
/**
 * Represents a maze of characters. The goal is to get from the top
 * left corner to the bottom right, following a path of Is
 * @author Arnold
 * һ����˵ջ��ݹ��ǿ����໥ת���ģ�ʹ�õݹ�ĵط������Ըĳ�ջ�ķ�ʽ��������Ҳһ������������Թ�����ʱ��ջ��ݹ���������ֲ�ͬ��ָ��˼�룬
 * ���˵ջʽ����������������Ӣ��߯��˹�Ļ�����ôʹ�õݹ鷨�����һλ���մ�Ȩ���쵼������վ���Թ���ڴ�ʱ��������������ȥ�ߣ���ʱ��λ�쵼
 * ��Ը��������£������Ƿֱ������Թ��ĸ�������ȥ̽������������·��ʱ��һ������������ٷֳ������ˣ�����ÿ���������̽��������ܻ���һ����
 * ���ֳ��ڡ����ֳ��ڵ�����˽����ڵ�λ�ñ�������������·�ڴ����ص��ˣ���������˱������һ��·�ڵ��ˣ����β���ϱ��������Ϣ�������쵼���
 * ������λ�쵼��˳���������õ�ͨ·��ҡ��ڵ�ͨ�����Թ�
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
				grid[row][column] = PATH;//���д��������������·����
			}
		}
		return done;
	}
	
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
	
	/**
	 * �ݹ��Թ��ⷨ
	 */
	public boolean traverse2(int row, int column){
		boolean done = false;
		if(valid(row, column)){//����Ƿ���Ч
			grid[row][column] = TRIED;
			if(row == grid.length - 1 && column == grid[0].length -1 ){//�ж��Ƿ��ѵ������
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
