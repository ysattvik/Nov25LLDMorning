package Module1.Multithreading.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    static class BankTask implements Runnable {
        private String taskName;

        BankTask(String name) {
            this.taskName = name;
        }

        @Override
        public void run() {
            System.out.println("Executing task: " + taskName + " by " + Thread.currentThread().getName());
            try {
                // Simulate some work with sleep
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Completed task: " + taskName + " by " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        // Executor with a fixed thread pool of 5 threads
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(5);

        // Submit 20 tasks to the executor
        for (int i = 1; i <= 20; i++) {
            fixedExecutor.submit(new BankTask("Task-" + i));
        }

        // Shutdown the executor after task submission
        fixedExecutor.shutdown();
    }
}

// ExecutorService is created with a fixed thread pool of 5 threads.
// ExecutorService manages the execution of submitted tasks.

// Submit method is used to submit tasks for execution in the thread pool.
// Shutdown method is called to clean up resources after all tasks are completed.

// In a fixed thread pool, if all threads are busy, new tasks wait in a queue until a thread becomes available.
// This is useful in scenarios where the number of concurrent tasks needs to be limited to avoid resource exhaustion.
// Each task simulates work by sleeping for 2 seconds, demonstrating concurrent execution within the thread pool.



// Key Highlights:
// Only 5 threads work concurrently — others wait in queue.
// Simulates a limited-resource scenario (like physical counters).
// Tasks are queued and picked up by idle threads after processing.
// Always call shutdown() to clean up resources.
// Thread pools increase performance and avoid system overloading caused by excessive thread creation.
// Ideal for scenarios with limited concurrent processing capacity.
// Helps manage resource utilization effectively.
// Prevents system overload by limiting active threads.
// Improves performance by reusing threads for multiple tasks.
