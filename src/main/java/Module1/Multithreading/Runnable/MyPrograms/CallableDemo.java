package Module1.Multithreading.Runnable.MyPrograms;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<Integer> callable = () -> {
            int count =0;
            for (int i = 1; i <= 10; i++) {
                count+= 5;
            }
            Thread.sleep(1000);
            return count;
        };

        // Submit Callable
        Future<Integer> future = executor.submit(callable);
        try {
            System.out.println("Result from callable: "+future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
