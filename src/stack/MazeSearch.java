package stack;
/**
 * ��ʾ�ö�ջģ��ݹ� 
 * @author Arnold
 *
 */
public class MazeSearch {

	public static void main(String[] args) {
		Maze maze = new Maze();
		System.out.println(maze);
		if(maze.traverse()){
			System.out.println("The maze was successfully traversed!");
		
		}else{
			System.out.println("There is no possible path.");
		}
		System.out.println(maze);
	}

}
