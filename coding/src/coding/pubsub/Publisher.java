package coding.pubsub;

import java.util.LinkedList;
import java.util.Queue;

public class Publisher implements Runnable{
	Queue<Integer> sharedQueue ;
	int queueSize;
	String name;
	
	public Publisher(Queue<Integer> sharedQueue, int queueSize, String name){
		this.sharedQueue = sharedQueue;
		this.queueSize = queueSize;
		this.name = name;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(name);
		while (true) {	
			try {
				Thread.currentThread().sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized(sharedQueue) {
				
				while (sharedQueue.size() == queueSize) {
					System.out.printf("\n[%s] queue full waiting..", name);
					try {
						sharedQueue.wait();
					}
					catch(InterruptedException e) {
						System.out.printf("\nInterrupted exception [%s]", e.getMessage());
					}
					
				}
				int r = (int) (Math.random() *100);
				sharedQueue.add(r);
				System.out.printf("\nPublished [%d] to the queue",r);
				sharedQueue.notifyAll();
			}
		}
	}
	

}
