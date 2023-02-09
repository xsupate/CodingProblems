package pg.com.java.multiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerImpl {

	public static void main(String[] args) {
		Queue sharedQueue = new LinkedList<Integer>();
		Producer producer = new Producer(sharedQueue);
		Consumer consumer = new Consumer(sharedQueue);
		producer.start();
		consumer.start();
	}

}

class Producer extends Thread{
	private Queue<Integer> sharedQueue;
	
	public Producer(Queue sharedQueue) {
		super("Producer");
		this.sharedQueue = sharedQueue;
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 15; i++) {
			synchronized (sharedQueue) {
				while (sharedQueue.size() >= 1) {
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				sharedQueue.add(i);
				System.out.println("Produced : " + sharedQueue.peek());
				sharedQueue.notify();
			}
		}
	}
}

class Consumer extends Thread{
	private Queue<Integer> sharedQueue;
	
	public Consumer(Queue sharedQueue) {
		super("Consumer");
		this.sharedQueue = sharedQueue;
	} 
	
	@Override
	public void run() {
		while(true) {
			synchronized(sharedQueue){
				while(sharedQueue.size() == 0) {
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int item = sharedQueue.poll();
				System.out.println("Consumed : " + item);
				sharedQueue.notify();
				if(item == 14) {
					break;
				}
			}
		}
	}
}