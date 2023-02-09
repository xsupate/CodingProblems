package pg.com.java.multiThreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceEg1 {

	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		
		executorService.schedule(()->{System.out.println("Runnable is executing...");}, 1,TimeUnit.SECONDS);
		
		executorService.scheduleAtFixedRate(()->{System.out.println("Runnable is executing...");}, 100, 1500,TimeUnit.MILLISECONDS);
		
	}

}
