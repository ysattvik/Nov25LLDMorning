package Module1.Multithreading.Runnable.MyPrograms;

import java.util.concurrent.atomic.AtomicInteger;

class SafeCounter {
    AtomicInteger count = new AtomicInteger(0);

    void increment() {
        count.incrementAndGet();
    }
    void decrement() {
        count.decrementAndGet();
    }
    int getCount() {
        return count.get();
    }
}

public class SafeAdderSubtractorUsingAtomicInteger {
    public static void main(String[] args) throws InterruptedException {
        SafeCounter counter = new SafeCounter();

        Runnable adder = () -> {
            for (int i=0;i<1000;i++) counter.increment();
        };
        Runnable subtractor = () -> {
            for (int i=0;i<1000;i++) counter.decrement();
        };

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final count value: "+counter.getCount());

    }
}
