package ie.dit.techfund;

public class Producer implements Runnable {
	private Queue queue;
	
	public Producer(Queue queue) {
		this.queue = queue;
	}
	
	@Override 
	public void run() {
		for(int i = 0; i<1000; i++) {
			UnitOfWork work  = new UnitOfWork();
			queue.enqueue(work);
			System.out.println("Pushed some work.");
		}
	}
}
