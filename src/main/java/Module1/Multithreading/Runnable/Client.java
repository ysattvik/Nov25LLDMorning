package Module1.Multithreading.Runnable;

public class Client {
    public static void main(String[] args) {
        // Create a task object
        Runnable task = new HelloWorldPrinter();

        // Pass the task to a new Thread
        Thread thread = new Thread(task);

        // Start the thread (runs task.run() in a new thread)
        thread.start();

        // This runs in the main thread
        System.out.println("Main thread: " + Thread.currentThread().getName());
    }
}

// Start method creates a new thread and calls the run method in that new thread
// Thread class can accept a Runnable object to define the task for the thread
// Each thread has its own call stack and executes independently



