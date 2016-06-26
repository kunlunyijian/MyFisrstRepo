package chapter11.sortingandseaching;

import org.junit.Test;

public class SortingandSearching<T extends Comparable<T>> {
	
	/**
	 * Searches the specified array of objects using a linear search algorithm
	 * @param data
	 * @param min
	 * @param max
	 * @param target
	 * @return
	 */
	public boolean linearSeach(T[] data , int min, int max, T target){
		int index = min;	
		boolean found = false;
		while(!found && index <= max){
			
			if( data[index].compareTo(target)  == 0){
				
				found = true;
				
			}
			index++;
			
		}
		return found;
	}
	
	/**
	 * ����д�ģ���ȷ��������
	 *  Searches the specified array of objects using binary search algorithm.
	 * @param data
	 * @param min
	 * @param max
	 * @param target
	 * @return
	 */
	
	public  boolean binarySerach2(T[] data, int min, int max, T target){
		boolean found = false;
		int index = 0;
		int mid = 0;
		while(min <= max){
			
			mid = (min + max) / 2;
			if(data[mid].compareTo(target) == 0){
				
				found = true;
				break;
				
			}else if(data[mid].compareTo(target) > 0){//target С�ڵ�ǰ�м��������ȥ�ұߵ�һ�루ǰ����data����С���������
				
				max = mid;
				
			}else {
				
				min = mid;
				
			}
			
		}
		return found;
	}
	/**
	 * �ݹ�ʽʵ��
	 *  Searches the specified array of objects using binary search algorithm.
	 * @param data
	 * @param min
	 * @param max
	 * @param target
	 * @return
	 */
	
	public  boolean binarySerach(T[] data, int min, int max, T target){
		boolean found = false;
		int mid = (min + max) / 2;//ȷ���е�,  �ù��̵��κ�ʱ�̣����ǿ��ܻ���ż����������ֵ����˾����������м䡱ֵ��
		//���ݸ��㷨�������õ��е�������������м�ֵ���κ�һ�����ڸö��ֲ���ʵ���У�ȷ���е������ļ��㶪�����κη������֣������ѡ��
		//���������м�ֵ�ĵ�һ��
		//�����ҵ��ų�ֻ�����һ��Ԫ��ʱ������Ԫ�ز��ȣ����Ҳ�����ʱ��
		
		if(data[mid].compareTo(target) == 0){
			found = true;
		}else if(data[mid].compareTo(target) > 0){
			if(min <= mid - 1){
				found = binarySerach(data, min, mid - 1, target);
			}
		}else if(mid + 1 <= max){
			found = binarySerach(data, mid + 1, max, target);//���ߵ�����˵���м�Ŀ϶�����ȣ����д��м��ұߵ�һ����ʼ��
		}
		
		return found;
	}
	
	//���������������㷨
	
	
	/**
	 * ѡ������O(n2)
	 */
	
	public void selectionSort(){
		int[] data = {0,9,5,312,12,1,10,20,23};
		int min = 0;
		int temp;
		while(min < data.length){
			for(int  index = min + 1; index < data.length; index++ ){
				if(data[min] > data[index]){//�˴��ǿ����Ż��ģ�û�б�Ҫÿ�ζ��������ȼ�¼����Сֵ��λ�ã����ڲ�ѭ������ʱ��������һ��λ�ü��ɡ������溯��
					temp = data[index];
					data[index] = data[min];
					data[min] = temp;
				}
			}
			min++;	
		}
		
		for(int index = 0; index < data.length; index++){
			System.out.println(data[index]);
		}

	}
	/**
	 * ѡ������
	 * @param data
	 */
	public void selectionSort2(int[] data){		
		int min ;//�������ã���¼��ǰ��֪����Сֵ����  ��¼λ��
		int temp;
		for(int index = 0; index < data.length - 1; index++){
			min = index;
			for(int scan = index + 1; scan < data.length; scan++){
				//�ҳ�����ѭ��������С��ֵ���ڵ�λ�ü���
				if(data[min] > data[scan]){//ÿһ�αȽϣ������ҳ������н�С��һ����Ȼ���ٽ��ý�С�ĺͺ���δ�Ƚϵ�Ԫ�رȽ�
					min = scan;
				}
			}
			//����ֵ
			temp = data[min];
			data[min] = data[index];
			data[index] = temp;
		}
	
		
		for(int index = 0; index < data.length; index++){
			System.out.println(data[index]);
		}
		
	}
	
	/**
	 * ��������  
	 * @author Arnold
	 */
	public void insertionSort(int[] data){
		int temp;
		//����data
		for(int scan = 1; scan < data.length ; scan++ ){
			
			for(int index = 0; index < scan; index++){
				
				
				
				//��data[scan]���뵽data[0]��data[scan-1]�е���ȷλ��
				if(data[scan] <= data[index] ){
					//���˵�һ��λ��
					//�Ƚ���λ�ú������Ԫ�غ���
					temp = data[scan];
					for(int i = 0; i< (scan - index);i++){
						data[scan - i] = data[scan -i -1];
					}
					data[index] = temp;
				}
				
			}
		
			
		}
	}
	/**
	 * ��������  
	 * @author �鱾
	 */
	public void insertionSort2(int[] data){
		for(int index = 1; index < data.length; index++){//���ѭ��������һ������ֵ�������е�����
			int key = data[index];//�˴���ֵ�Ѿ���¼����key����λ����Ҳû��
			
			int position = index ;//������ʾ0-position-1 ��������õ������Ӽ�
			//Shift larger values to the right
			while(position > 0 && key < data[position - 1]){//�����ǰ����ֵС�ڸ�λ�ô���ֵ���򽫸�ֵ��λ����λ���ұߡ�
				//������λֱ���ҵ����ܸò���ֵ����ȷλ��
				data[position] = data[position - 1];//��λ
				position--;
			}
			data[position] = key;//��ֵ������ȷ��λ��
			
		}

	}
	/**
	 * ð������
	 * @author Arnold
	 * @param data
	 */
	public void bubbleSort(int[] data){
		int temp;
		for(int i = 0; i < data.length - 1; i++){//n-1��ð��
			
			for(int scan = 0; scan < data.length - i -1; scan++){
				if(data[scan] > data[scan + 1]){
					//����ֵ
					temp = data[scan + 1];
					data[scan + 1] = data[scan];
					data[scan] = temp;
				}
			}
			
		}
	}
	/**
	 * ð������
	 * @author �鱾
	 * @param data
	 */
	public void bubbleSort2(int[] data){
		int position;
		int scan;
		int temp;
		for(position = data.length - 1; position >= 0; position--){
			
			 for(scan = 0; scan < position; scan++){
				 if(data[scan] > data[scan + 1]){
						//����ֵ
						temp = data[scan + 1];
						data[scan + 1] = data[scan];
						data[scan] = temp;
					}
			 }
			
		}
	}
	
	/**
	 * 
	 * Sorts the specified array of objects using the quick sort algorithm.
	 * ��������
	 * @param data
	 * @param min
	 * @param max
	 */
	
	public void quickSort(int[] data, int min, int max){
		
		int indexofpartition;
		
		if(max - min > 0){
			//Create partitions
			indexofpartition  = findPartition(data, min, max);
			//sort the left side
			quickSort(data, min, indexofpartition - 1);
			// sort the right side
			quickSort(data, indexofpartition + 1, max);
			
		}
		
	}
	/**
	 * private find Partition method used by the quick sort algorithm.
	 * @param data
	 * @param min
	 * @param max
	 * @return
	 */
	
	private int findPartition(int[] data, int min, int max){
		int left;
		int right;
		int partitionElement;
		int temp;
		//use the first element as the partition element
		partitionElement = data[min];
		left = min;
		right = max;
		while(left < right){
			//search for an element that is > the partition element
			while(data[left] <= partitionElement && left < right){//�����ɨ�赽�ұ�
				left++;
			}
			//search for an element that is < the partition element
			while(data[right] > partitionElement ){//���ұ�ɨ�赽��� 
				right--;
			}
			
			if(left < right){
				temp  = data[left];
				data[left] = data[right];
				data[right] = temp;
			}
		}
		
		//move partition element to partition index
		temp = data[min];
		data[min] = data[right];
		data[right] = temp;
		
		return right;
	}
	
	
	
	
	private int findPartition2(int[] data,int min,int max){
		
		return 0;
	}
	
	/**
	 * ����ǰ��ķ���
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		int[] data = {0,9,5,312,12,1,10,20,23,100,201,3,2};
		SortingandSearching<Student> sortingandSearching = new SortingandSearching<Student>();
//		sortingandSearching.insertionSort(data);//��������
//		sortingandSearching.bubbleSort2(data);//ð������
		sortingandSearching.quickSort(data,0 , data.length-1);//ð������
		for(int index = 0; index < data.length; index++){
			System.out.println(data[index]);
		}
//		sortingandSearching.selectionSort();s
//		Student target = new Student(1);
//		Student[] data = new Student[10];
//		
//		for(int i = 0; i < data.length; i++){
//			
//			data[i]  = new Student(i);
//			
//		}
//		if(sortingandSearching.binarySerach(data,0,data.length,target)){
//			System.out.println("has successfully found the result!!");
//		}else{
//			System.out.println("no result has been found!!");
//		}
	}

}
