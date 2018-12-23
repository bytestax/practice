package coding.pubsub;

import java.util.Queue;

public class Subscriber implements Runnable{
	
	Queue<Integer> sharedQueue;
	int queueSize;
	String name;
	
	public Subscriber(Queue<Integer> sharedQueue, int queueSize, String name) {
		this.sharedQueue = sharedQueue;
		this.queueSize = queueSize;
		this.name = name;
			
	}

	@Override
	public void run() {
		while (true){
			try {
				Thread.currentThread().sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized(sharedQueue) {
				while (sharedQueue.size() == 0) {
					System.out.printf("\n[%s] queue empty, waiting..",name);
					try {
						sharedQueue.wait();
					}
					catch(InterruptedException e) {
						System.out.printf("\n interrupted exception [%s]",e.getMessage());
					}
				}
				int i = sharedQueue.remove();
				System.out.printf("\n Retrieved [%d] from the queue", i);
				sharedQueue.notifyAll();
			}
		}
		
	}
	

}
