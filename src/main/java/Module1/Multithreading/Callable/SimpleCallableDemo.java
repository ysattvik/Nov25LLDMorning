package Module1.Multithreading.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class SimpleCallableDemo {

    // Create a class the implements Callable
    static class SquareCalculator implements Callable<Integer> {
        private final int number;

        SquareCalculator(int number) {
            this.number = number;
        }

        @Override
        public Integer call() {
            // Simulate a long computation
            //Thread.sleep(1000);
            return number * number;
        }
    }

    // Main method to run the program
    public static void main(String[] args) throws Exception{
        // Create an instance of Callable
        SquareCalculator task = new SquareCalculator(5);

        // Directly calling call() like a normal method
        Integer result = task.call();

        // Print the returned result
        System.out.println("Returned from call(): " + result);
    }
}
