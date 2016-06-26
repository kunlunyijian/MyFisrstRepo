package queue;
/**
 * 
 * Represents a waiting customer
 * @author Arnold
 *
 */
public class Customer {
	private int arrivalTime;
	private int departureTime;
	/**
	 * Creates a new customer with the specified arrival time.
	 * @param arrives
	 */
	public  Customer(int arrives){
		this.arrivalTime = arrives;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public int getDepartureTime() {
		return departureTime;
	}
	
	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}
	
	/**
	 * Computes and returns the total time spent by this customer.
	 * @return
	 */
	
	public int totalTime(){
		return departureTime - arrivalTime;
	}
}
