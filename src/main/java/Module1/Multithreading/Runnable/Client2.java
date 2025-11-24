package Module1.Multithreading.Runnable;

public class Client2 {
    public static void main(String[] args) {
        Runnable task = new HelloWorldPrinter();

        Thread thread = new Thread(task);
        thread.start(); // Executes run() in a separate thread

        task.run(); // Executes run() in the current (main) thread

        System.out.println("Main thread ends: " + Thread.currentThread().getName());
    }
}
