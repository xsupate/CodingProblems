package pg.com.java.multiThreading;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		MT thread = new MT();
		thread.mainThread = Thread.currentThread();
		thread.start();
		//thread.join();// Child will complete first then main thread
		for(int i = 0; i <= 5; i++) {
			System.out.println("Main");
		}
	}

}


class MT extends Thread{
	Thread mainThread;
	@Override
	public void run() {
		try {
			mainThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0; i <= 5; i++) {
			System.out.println("Child");
			Thread.yield();
		}
	}
}