package Module1.Multithreading.Runnable.MyPrograms;

import java.util.concurrent.Semaphore;

class SharedPrinter {
    private final Semaphore semaphore = new Semaphore(1);// only 1 thread at a time

    public void print(String msg) throws InterruptedException {
        semaphore.acquire();
        System.out.println(msg);
        Thread.sleep(1000);
        semaphore.release();
    }
}

public class SemaphoreExample {
    public static void main(String[] args) {
        SharedPrinter sharedPrinter = new SharedPrinter();
        Runnable task = () -> {
            try {
                sharedPrinter.print(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i=0;i<3;i++) {
            new Thread(task).start();
        }

    }
}
