package queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Demonstrates the use of a queue for simulating a waiting line.
 * @author Arnold
 *
 */
public class TicketCounter {
	
	final static int PROCESS  = 120;
	final static int MAX_CASHIERS = 10;
	final static int NUM_CUSTOMERS  = 100;
	
	public static void main(String[] args){
		Customer customer;
		LinkedBlockingQueue<Customer> customerQueue = new LinkedBlockingQueue<Customer>();
		int[] cashierTime = new int[MAX_CASHIERS];
		int totalTime = 0,averageTime,departs;
		//process the simulation for various number of cashiers
		for(int cashiers = 1; cashiers < MAX_CASHIERS; cashiers++){
			System.out.println("hahah ");
			
			//set each cashier's time to zero initially
			for(int count = 0; count < cashiers; count++){
				cashierTime[count] = 0;
			}
			//load customer queue
			for(int count2 = 1; count2 < NUM_CUSTOMERS; count2++){
				try {
					customerQueue.put(new Customer(count2*15));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
				
				totalTime = 0;
				//process all customers in the queue
				while(!(customerQueue.isEmpty())){
					
					for(int count3 = 0; count3 < cashiers; count3++){
						
						if(!(customerQueue.isEmpty())){
							customer = customerQueue.poll();
							if(customer.getArrivalTime() > cashierTime[count3]){//如果客户来时候有空窗口，直接处理？？
								departs = customer.getArrivalTime() + PROCESS;
							}else{
								departs = cashierTime[count3] + PROCESS;
							}
							customer.setDepartureTime(departs);
							cashierTime[count3] = departs;
							totalTime += customer.totalTime();
						}
						
					}
				}
			
			//output results for this simulation 
			averageTime =  totalTime / NUM_CUSTOMERS;
			System.out.println("Number of cashiers: "+(cashiers+1));
			System.out.println("Average time: "+averageTime+"\n");
		}
	}
}
