package queue.radixsort;
/**
 * 
 * 使用队列来进行基数排序
 * @author Arnold
 * Demonstrates the use of queues in the execution of a radix sort.
 */
public class RadixSort {
	
	public static void main(String[] args) {
		int[] list = {7843,4568,8765,6543,7865,4532,9987,3241,6589,6622,1211};
		String temp;//用字符串工具来处理提取数字的个十百千位
		Integer numObj;
		int digit,num;
		ArrayQueue<Integer>[] digitQueues = (ArrayQueue<Integer>[])(new ArrayQueue[10]);//十个队列，0-9
		for(int digitVal = 0; digitVal <= 9; digitVal++){
			digitQueues[digitVal] = new ArrayQueue<Integer>();
		}
		
		//sort the list
		for(int position=0; position <=3 ; position++){//个十百千 位
			
			for(int scan=0; scan<list.length;scan++){//扫描要排序的数字数组,将其放入相应的队列
				temp = String.valueOf(list[scan]);
				
				digit = Character.digit(temp.charAt(3-position),10);//digit()根据基数返回当前字符的值的十进制
				digitQueues[digit].enqueue(new Integer(list[scan]));
			}
			num = 0;
			//gather numbers back into list 
			//将position轮的排序重新一次从基数队列取出放回到list数组中（次序已打乱）
			for(int digitVal = 0; digitVal<=9; digitVal++){
				while(!digitQueues[digitVal].isEmpty()){//队列中元素个数不明了的时候，用while更方便
					try {
						numObj = digitQueues[digitVal].dequeue();//出队
						
						int intValue = numObj.intValue();
						list[num] = intValue;
						num++;
					} catch (EmptyColletionException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
		//output the sorted list
		for(int scan = 0; scan <list.length; scan++){
			System.out.println(list[scan]);
		}
		
	}
	
}
