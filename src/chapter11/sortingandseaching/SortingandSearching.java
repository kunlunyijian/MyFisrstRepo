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
	 * 屈岳写的，正确与否待测试
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
				
			}else if(data[mid].compareTo(target) > 0){//target 小于当前中间的数，舍去右边的一半（前提是data按从小到大的排序）
				
				max = mid;
				
			}else {
				
				min = mid;
				
			}
			
		}
		return found;
	}
	/**
	 * 递归式实现
	 *  Searches the specified array of objects using binary search algorithm.
	 * @param data
	 * @param min
	 * @param max
	 * @param target
	 * @return
	 */
	
	public  boolean binarySerach(T[] data, int min, int max, T target){
		boolean found = false;
		int mid = (min + max) / 2;//确定中点,  该过程的任何时刻，我们可能会有偶数个待查找值，因此就有两个“中间”值。
		//根据该算法，所采用的中点可以是这两个中间值的任何一个。在该二分查找实现中，确定中点索引的计算丢弃了任何分数部分，因此它选择
		//的是两个中间值的第一个
		//当查找到排除只有最后一个元素时，而且元素不等，及找不到的时候
		
		if(data[mid].compareTo(target) == 0){
			found = true;
		}else if(data[mid].compareTo(target) > 0){
			if(min <= mid - 1){
				found = binarySerach(data, min, mid - 1, target);
			}
		}else if(mid + 1 <= max){
			found = binarySerach(data, mid + 1, max, target);//能走到这里说明中间的肯定不相等，所有从中间右边第一个开始找
		}
		
		return found;
	}
	
	//接下来的是排序算法
	
	
	/**
	 * 选择排序O(n2)
	 */
	
	public void selectionSort(){
		int[] data = {0,9,5,312,12,1,10,20,23};
		int min = 0;
		int temp;
		while(min < data.length){
			for(int  index = min + 1; index < data.length; index++ ){
				if(data[min] > data[index]){//此处是可以优化的，没有必要每次都交换，先记录下最小值的位置，在内层循环结束时，仅交换一次位置即可。见下面函数
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
	 * 选择排序
	 * @param data
	 */
	public void selectionSort2(int[] data){		
		int min ;//两个作用，记录当前已知的最小值，二  记录位置
		int temp;
		for(int index = 0; index < data.length - 1; index++){
			min = index;
			for(int scan = index + 1; scan < data.length; scan++){
				//找出本轮循环里面最小的值所在的位置即可
				if(data[min] > data[scan]){//每一次比较，都会找出两者中较小的一个，然后再将该较小的和后面未比较的元素比较
					min = scan;
				}
			}
			//交换值
			temp = data[min];
			data[min] = data[index];
			data[index] = temp;
		}
	
		
		for(int index = 0; index < data.length; index++){
			System.out.println(data[index]);
		}
		
	}
	
	/**
	 * 插入排序法  
	 * @author Arnold
	 */
	public void insertionSort(int[] data){
		int temp;
		//遍历data
		for(int scan = 1; scan < data.length ; scan++ ){
			
			for(int index = 0; index < scan; index++){
				
				
				
				//将data[scan]插入到data[0]和data[scan-1]中的正确位置
				if(data[scan] <= data[index] ){
					//找了第一个位置
					//先将此位置后的所有元素后移
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
	 * 插入排序法  
	 * @author 书本
	 */
	public void insertionSort2(int[] data){
		for(int index = 1; index < data.length; index++){//外层循环控制下一个插入值在数组中的索引
			int key = data[index];//此处的值已经记录到了key，移位操作也没事
			
			int position = index ;//用来表示0-position-1 的已排序好的排序子集
			//Shift larger values to the right
			while(position > 0 && key < data[position - 1]){//如果当前插入值小于该位置处的值，则将该值移位到移位到右边。
				//继续移位直至找到接受该插入值的正确位置
				data[position] = data[position - 1];//移位
				position--;
			}
			data[position] = key;//将值插入正确的位置
			
		}

	}
	/**
	 * 冒泡排序
	 * @author Arnold
	 * @param data
	 */
	public void bubbleSort(int[] data){
		int temp;
		for(int i = 0; i < data.length - 1; i++){//n-1轮冒泡
			
			for(int scan = 0; scan < data.length - i -1; scan++){
				if(data[scan] > data[scan + 1]){
					//交换值
					temp = data[scan + 1];
					data[scan + 1] = data[scan];
					data[scan] = temp;
				}
			}
			
		}
	}
	/**
	 * 冒泡排序
	 * @author 书本
	 * @param data
	 */
	public void bubbleSort2(int[] data){
		int position;
		int scan;
		int temp;
		for(position = data.length - 1; position >= 0; position--){
			
			 for(scan = 0; scan < position; scan++){
				 if(data[scan] > data[scan + 1]){
						//交换值
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
	 * 快速排序
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
			while(data[left] <= partitionElement && left < right){//从左边扫描到右边
				left++;
			}
			//search for an element that is < the partition element
			while(data[right] > partitionElement ){//从右边扫描到左边 
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
	 * 测试前面的方法
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		int[] data = {0,9,5,312,12,1,10,20,23,100,201,3,2};
		SortingandSearching<Student> sortingandSearching = new SortingandSearching<Student>();
//		sortingandSearching.insertionSort(data);//插入排序
//		sortingandSearching.bubbleSort2(data);//冒泡排序
		sortingandSearching.quickSort(data,0 , data.length-1);//冒泡排序
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
