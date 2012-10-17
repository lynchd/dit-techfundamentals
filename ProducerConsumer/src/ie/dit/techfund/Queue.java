package ie.dit.techfund;

public class Queue {
	private static int EMPTY_VALUE = -1;
	
	private UnitOfWork[] 	buffer;
	private int 			headPointer;
	
	public Queue(int size) {
		buffer 		= new UnitOfWork[size];
		headPointer = EMPTY_VALUE;
	}
	
	/** This is a blocking enqueue. We will not continue 
	 *  until the queue has space and we have been granted
	 *  leave to continue through the monitor. 
	 */
	public synchronized void enqueue(UnitOfWork unit) 
	{
		if (IsFull()) {
			/** Wait for the an execution of dequeue */
			System.out.println("Waiting on the queue to empty.");
			waitForNotify();
		}
		headPointer = headPointer + 1;
		buffer[headPointer]=unit;
		/** Notify possibly waiting invokers of dequeue 
		 *  or other consumers of equeue **/
		invokeNotify();
	}
	
	/** 
	 * This is a blocking dequeue. If there is nothing to 
	 * dequeue, we will wait indefinately. 
	 */
	public synchronized UnitOfWork dequeue() {
		if(IsEmpty()) {
			/** Wait for an execution of enqueue **/
			System.out.println("Waiting on the queue to fill.");
			waitForNotify();
		}
		UnitOfWork head = buffer[headPointer];
		headPointer = headPointer -1;
		/** Notify possibly waiting invokers of enqueue or 
		 *  other consumers of dequeue **/
		invokeNotify();
		return head;
	}
	
	public boolean IsEmpty() {
		return headPointer==EMPTY_VALUE;
	}
	
	public boolean IsFull() {
		return headPointer == buffer.length-1;
	}
	
	private void waitForNotify() {
		try {
			wait();
		}
		catch(Exception ex) {
			// Dont care
		}
	}
	
	private void invokeNotify() {
		try {
			notify();
		}
		catch(Exception ex) {
			// Dont care
		}
	}
}
