package queue.radixsort;
/**
 * 
 * ʹ�ö��������л�������
 * @author Arnold
 * Demonstrates the use of queues in the execution of a radix sort.
 */
public class RadixSort {
	
	public static void main(String[] args) {
		int[] list = {7843,4568,8765,6543,7865,4532,9987,3241,6589,6622,1211};
		String temp;//���ַ���������������ȡ���ֵĸ�ʮ��ǧλ
		Integer numObj;
		int digit,num;
		ArrayQueue<Integer>[] digitQueues = (ArrayQueue<Integer>[])(new ArrayQueue[10]);//ʮ�����У�0-9
		for(int digitVal = 0; digitVal <= 9; digitVal++){
			digitQueues[digitVal] = new ArrayQueue<Integer>();
		}
		
		//sort the list
		for(int position=0; position <=3 ; position++){//��ʮ��ǧ λ
			
			for(int scan=0; scan<list.length;scan++){//ɨ��Ҫ�������������,���������Ӧ�Ķ���
				temp = String.valueOf(list[scan]);
				
				digit = Character.digit(temp.charAt(3-position),10);//digit()���ݻ������ص�ǰ�ַ���ֵ��ʮ����
				digitQueues[digit].enqueue(new Integer(list[scan]));
			}
			num = 0;
			//gather numbers back into list 
			//��position�ֵ���������һ�δӻ�������ȡ���Żص�list�����У������Ѵ��ң�
			for(int digitVal = 0; digitVal<=9; digitVal++){
				while(!digitQueues[digitVal].isEmpty()){//������Ԫ�ظ��������˵�ʱ����while������
					try {
						numObj = digitQueues[digitVal].dequeue();//����
						
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
