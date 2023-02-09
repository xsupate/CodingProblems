package pg.com.java.multiThreading;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceExm1 {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Future future = executorService.submit(new Thread1());
		try {
			future.cancel(true);
			if(future.isCancelled()) {
				System.out.println("Task is cancelled");
			}
			Object obj = future.get(2000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println("Inside catch block");
			e.printStackTrace();
		}catch (CancellationException exp){
			System.out.println("Inside catch block of CancellationException");
		}
		
		executorService.shutdown();
	}

}


class Thread1 implements Runnable{
	
	@Override
	public void run() {
			try {
				System.out.println("Executing run method ");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}