package ie.dit.techfund;

public class Consumer implements Runnable
{
	private Queue queue;
	private int   processedCount;
	
	public Consumer(Queue queue) {
		this.queue = queue;
		processedCount = 0;
	}
	
	@Override 
	public void run() {
		while (processedCount < 1000) {
			UnitOfWork work = queue.dequeue();
			work.doWork(processedCount);
			processedCount++;
		}
	}
}
