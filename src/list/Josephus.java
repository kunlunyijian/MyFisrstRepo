package list;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * �ô�������list��ģ��Josephus����
 * @author Administrator
 *
 */
public class Josephus {
/**
 * Continue around the circle eliminating every nth soldier until all of the soldiers have been eliminated.
 */
	public static void main(String[] args) {
		int numpeople,gap,newgap;
		int counter;//������¼Ҫɾ��Ԫ�ص�����
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		
		//get the initial number of soldiers 
		
		System.out.println("Enter the number of soldiers:");
		numpeople = scanner.nextInt();
		scanner.nextLine();
		
		//get the gap between soldiers
		
		System.out.println("Enter the gap between soldiers:");
		gap = scanner.nextInt();
		
		//load the initial list of soldiers
		
		for(int count = 1; count <= numpeople; count++){
			list.add(new Integer(count));
		}
		
		counter = gap - 1;
		 
		newgap = gap;
		
		//Treating the list as circular, remove every nth element until the list is empty
		
		System.out.println("The order is: ");
		
		while(!list.isEmpty()){
			System.out.println(list.remove(counter));
			numpeople = numpeople - 1;
			if(numpeople > 0){
				counter = (counter + gap -1) % numpeople;//����ǹؼ�
			}
		}
		
		
	}
}
