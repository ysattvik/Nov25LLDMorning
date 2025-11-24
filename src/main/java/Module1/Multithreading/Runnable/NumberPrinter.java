package Module1.Multithreading.Runnable;

public class NumberPrinter implements Runnable{
    private final int number;

    public NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        // Print number along with the thread's name
        System.out.println("Number: " + number + " printed by " + Thread.currentThread().getName());
    }
}

// A task that prints a number, assigned via constructor

// The output order will vary because thread scheduling is non-deterministic. Threads execute
// based on the JVM and OS thread scheduler.

// Setting priority of a thread does not guarantee that it will execute before or after other threads.
// It is merely a hint to the thread scheduler about the relative importance of the thread.

// Limitations of using Runnable:
// 1. Cannot directly return a result from the run() method.
// 2. Cannot throw checked exceptions from the run() method.
// To overcome these limitations, we can use Callable interface which allows returning results and throwing exceptions.