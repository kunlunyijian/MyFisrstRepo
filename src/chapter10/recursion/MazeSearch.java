package chapter10.recursion;

public class MazeSearch {
	 public static void main(String[] args) {
		Maze maze = new Maze();
		System.out.println(maze);
		if(maze.traverse2(0, 0)){
			System.out.println("The maze was successfully traversed!");
		}else{
			System.out.println("There is no possible path.");
		}
		
		System.out.println(maze);
	}
 
}
