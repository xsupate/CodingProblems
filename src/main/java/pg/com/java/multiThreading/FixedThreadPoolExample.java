package pg.com.java.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        // Creating a fixed-size thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submitting 5 tasks
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println("Task " + taskId + " executed by thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulating some task execution time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Shutdown the executor service
        executorService.shutdown();
    }
}

