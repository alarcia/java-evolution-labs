package lab07_virtual_threads.legacy;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class BlockingApp {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // LEGACY APPROACH: Platform Threads (OS Threads)
        // Limited by the number of OS threads.
        try (var executor = Executors.newFixedThreadPool(100)) {

            System.out.println("Starting 10,000 tasks with Platform Threads...");

            for (int i = 0; i < 10_000; i++) {
                executor.submit(() -> {
                    try {
                        // Simulate IO operation (DB query, API call) that takes 500ms
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } // Executor auto-closes and waits for tasks to finish here

        long end = System.currentTimeMillis();
        System.out.println("Legacy Total Time: " + (end - start) + " ms");
    }
}