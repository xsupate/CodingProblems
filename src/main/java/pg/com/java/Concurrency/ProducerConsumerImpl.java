package pg.com.java.Concurrency;

public class ProducerConsumerImpl {

	public static void main(String[] args) throws InterruptedException {
		final BlockingQueue<Integer> q = new BlockingQueue<Integer>(5);

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					q.enqueue(new Integer(i));
					System.out.println("enqueued " + i);
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 0; i < 25; i++) {
					System.out.println("Thread 2 dequeued: " + q.dequeue());
				}
			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 25; i++) {
					System.out.println("Thread 3 dequeued: " + q.dequeue());
				}
			}
		});

		t1.start();
		Thread.sleep(4000);
		t2.start();
		t2.join();
		t3.start();
		t1.join();
		t3.join();
	}
}
