package Module1.Multithreading.Runnable.MyPrograms;

class SharedCounter {
    volatile int count=0;

    void increment() {
        count++;
    }
}

public class VolatileExample {
    public static void main(String[] args)throws InterruptedException {
        SharedCounter counter = new SharedCounter();

        Thread t1 = new Thread(() -> {for(int i=0;i<1000;i++) counter.increment(); });
        Thread t2 = new Thread(() -> {for(int i=0;i<1000;i++) counter.increment(); });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final count: " + counter.count);// may still be <2000 (not atomic)
    }
}


