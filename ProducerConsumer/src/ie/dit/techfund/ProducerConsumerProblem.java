package ie.dit.techfund;

public class ProducerConsumerProblem {
	public static void main(String argsv[]) 
		throws Exception 
	{
		Queue queue = new Queue(100);
		
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		
		Thread pThread = new Thread(producer);
		Thread cThread = new Thread(consumer);
		
		pThread.start();
		cThread.start();
		
		pThread.join();
		cThread.join();
	}

}
