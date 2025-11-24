package Module1.Multithreading.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithExecutor {

    static class SquareCalculator implements Callable<Integer> {
        private int number;

        public SquareCalculator(int number) {
            this.number = number;
        }

        @Override
        public Integer call() {
            return number * number;
        }
    }

    public static void main(String[] args) throws Exception {
        // Create an ExecutorService with a single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Create a Callable task
        SquareCalculator task = new SquareCalculator(10);

        // Submit the task to the executor
        Future<Integer> future = executor.submit(task);

        // Retrieve and print the result
        Integer result = future.get();

        System.out.println("Square of 10 is: " + result);

        // Shutdown the executor
        executor.shutdown();

    }
}

// Callable interface is similar to Runnable but can return a result and throw checked exceptions.
// It has a single method call() that returns a value.

// Future represents the result of an asynchronous computation.
// You can use Future to check if the computation is complete, wait for its completion, and retrieve the result.
// It provides methods to manage termination and methods that can produce a Future for tracking progress of one or more asynchronous tasks.

// If shutdown is called just after submit, the submitted task will still be executed before the executor is terminated.
// It simply means that no new tasks will be accepted. Finish whatever is already submitted.