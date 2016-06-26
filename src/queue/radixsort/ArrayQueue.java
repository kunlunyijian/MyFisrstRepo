package queue.radixsort;
/**
 * 数组式侧虐
 * @author Administrator
 *
 * @param <T>
 */

public class ArrayQueue<T> {
	
	private final static int INITIAL_CAPACITY = 10;//无参构造默认初始大小
	T[] queue;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		rear = 0;
		queue = (T[])new Object[INITIAL_CAPACITY];
	}

	int rear;//代表队列长度和下一个入队位置
	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity){//初始化容量大小为initialCapacity
		rear = 0;
		queue = (T[])new Object[initialCapacity];
	}
	
	/**
	 * 入队
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
		//将值搬到新家
		for(int index = 0; index < queue.length; index++){
			larger[index] = queue[index];
		}
		
		queue = larger;
	}

	/**
	 * 从队头出队
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
		
		queue[rear] = null;//考虑到完整性，会将那个指向队列末元素的引用副本改写成null
		return result;
	}

	public int size() {
		
		return queue.length;
		
	}
	public boolean isEmpty() {
		
		return (rear == 0);//注意不是queue.length == 0;
		
	}

	

}
