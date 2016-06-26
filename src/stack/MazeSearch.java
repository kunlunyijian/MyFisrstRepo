package stack;
/**
 * ÑÝÊ¾ÓÃ¶ÑÕ»Ä£ÄâµÝ¹é 
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
