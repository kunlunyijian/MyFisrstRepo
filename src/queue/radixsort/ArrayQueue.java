package queue.radixsort;
/**
 * ����ʽ��Ű
 * @author Administrator
 *
 * @param <T>
 */

public class ArrayQueue<T> {
	
	private final static int INITIAL_CAPACITY = 10;//�޲ι���Ĭ�ϳ�ʼ��С
	T[] queue;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		rear = 0;
		queue = (T[])new Object[INITIAL_CAPACITY];
	}

	int rear;//������г��Ⱥ���һ�����λ��
	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity){//��ʼ��������СΪinitialCapacity
		rear = 0;
		queue = (T[])new Object[initialCapacity];
	}
	
	/**
	 * ���
	 * @param element
	 */
	
	public void enqueue(T element) {
		if(size() == queue.length){
			expandCapacity();
		}
		queue[rear] = element;
		rear++;
	}
	
	private void expandCapacity() {
		@SuppressWarnings("unchecked")
		T[] larger = (T[])new Object[queue.length*2];
		//��ֵ�ᵽ�¼�
		for(int index = 0; index < queue.length; index++){
			larger[index] = queue[index];
		}
		
		queue = larger;
	}

	/**
	 * �Ӷ�ͷ����
	 * @return
	 */
	
	public T dequeue() throws EmptyColletionException{
		if(isEmpty()){
			throw new EmptyColletionException("queue Exception!!");
		}
		T result = queue[0];
		rear--;
		for(int scan = 0; scan <rear; scan++){//shift the elements
			queue[scan]  = queue[scan+1];
		}
		
		queue[rear] = null;//���ǵ������ԣ��Ὣ�Ǹ�ָ�����ĩԪ�ص����ø�����д��null
		return result;
	}

	public int size() {
		
		return queue.length;
		
	}
	public boolean isEmpty() {
		
		return (rear == 0);//ע�ⲻ��queue.length == 0;
		
	}

	

}
