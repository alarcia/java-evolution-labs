package lab07_virtual_threads.modern;

import java.util.concurrent.Executors;

public class VirtualFuture {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        // MODERN APPROACH: Virtual Threads (Project Loom)
        // Replaced "newFixedThreadPool" with "newVirtualThreadPerTaskExecutor".
        // This creates a fresh, lightweight thread for EVERY task.
        // No pooling needed.

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

            System.out.println("Starting 10,000 tasks with Virtual Threads...");

            for (int i = 0; i < 10_000; i++) {
                executor.submit(() -> {
                    try {
                        // THE MAGIC:
                        // When a Virtual Thread sleeps (or waits for DB), it "unmounts"
                        // from the CPU. The OS thread is free to run other tasks.
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } // Waits for all 10,000 tasks to finish

        long end = System.currentTimeMillis();
        System.out.println("Modern Total Time: " + (end - start) + " ms");
    }
}