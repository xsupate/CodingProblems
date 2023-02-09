package pg.com.java.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutdownVsShutdownNow {

	public static void main(String[] args) throws InterruptedException {
	    ExecutorService executor = Executors.newFixedThreadPool(1);
	    executor.submit(new Runnable() {

	        @Override
	        public void run() {
	            while (true) {
	                if (Thread.currentThread().isInterrupted()) {
	                    System.out.println("interrupted");
	                    break;
	                }
	            }
	        }
	    });
	    
	    executor.shutdown();
	    //executor.shutdownNow();
	    if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
	        System.out.println("Still waiting after 100ms: calling System.exit(0)...");
	        System.exit(0);
	    }
	    System.out.println("Exiting normally...");
	}

}
