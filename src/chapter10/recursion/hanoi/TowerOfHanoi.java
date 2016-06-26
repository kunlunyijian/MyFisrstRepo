package chapter10.recursion.hanoi;
/**
 * Represents the classic Towers of Hanoi puzzle.
 * @author Arnold
 *
 */
public class TowerOfHanoi {
	
	private int totalDisks;
	
	public TowerOfHanoi(int disks) {
		this.totalDisks =  disks;
	}
	
	public void solve(){
		
		moveTower(totalDisks, 1, 3, 2);
		
	}
	
	
	
	/**
	 * Moves the specified number of disks from one tower to another by
	 * moving a subtower of n-1 disks out of the way, moving one disk,
	 * then moving the subtower back. Base case of 1 disk  
	 * 
	 * @param numDisks
	 * @param start
	 * @param end
	 * @param temp
	 */
	private void moveTower(int numDisks, int start,int end, int temp){
		if(numDisks == 1){
			moveOneDisk(start,end);
		}else{
			moveTower(numDisks - 1, start, temp, end);
			moveOneDisk(start, end);
			moveTower(numDisks - 1 , temp, end , start);	
		}

	}
	
//没有else 将会出现栈溢出
//	private void moveTower(int numDisks, int start,int end, int temp){
//		if(numDisks == 1){
//			moveOneDisk(start,end);
//		}
//		moveTower(numDisks - 1, start, temp, end);
//		moveOneDisk(start, end);
//		moveTower(numDisks - 1 , temp, end , start);
//	}
	
	/**
	 * Prints instructions to move one disk from the specified start 
	 * tower to the specified end tower.
	 * @param start
	 * @param end
	 */
	private void moveOneDisk(int start, int end) {
		
		System.out.println("Move one disk from "+start+"  to   " +end);
		
	}
}
