package coding.pubsub;

import java.util.LinkedList;
import java.util.Queue;

public class PubSubTester {
	
	static int QUEUE_SIZE = 1000;

	public static void main(String[] args) throws InterruptedException {
		Queue<Integer> sharedQueue = new LinkedList<Integer>();
		Thread pub = new Thread(new Publisher(sharedQueue, QUEUE_SIZE, "Publisher"));
		Thread sub = new Thread(new Subscriber(sharedQueue, QUEUE_SIZE, "Subsrcriber"));
		pub.start();
		sub.start();
		Thread.currentThread().join();
	}

}
