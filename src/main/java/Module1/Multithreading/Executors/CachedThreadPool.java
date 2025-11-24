package Module1.Multithreading.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    static class LightTask implements Runnable {
        private final int taskId;

        LightTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Executing light task " + taskId + " on thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(500); // Simulate light work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService cachedExecutor = Executors.newCachedThreadPool();

        // Submit first batch of light tasks
        for (int i = 1; i <= 5; i++) {
            cachedExecutor.submit(new LightTask(i));
        }

        try {
            // Wait to allow threads to finish and become idle
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n--- Submitting second batch of light tasks (observe thread reuse) ---\n");

        // Submit second batch of light tasks
        for (int i = 6; i <= 10; i++) {
            cachedExecutor.submit(new LightTask(i));
        }

        // Shutdown executor after task submission
        cachedExecutor.shutdown();
    }

}
