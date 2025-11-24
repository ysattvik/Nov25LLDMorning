package Module1.Multithreading.Runnable;

public class HelloWorldPrinter implements Runnable {

    public void print(){
        System.out.println("Hello from thread: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        print();
    }
}

// Runnable is a functional interface with a single abstract method run()
// It allows defining tasks to be executed by threads
