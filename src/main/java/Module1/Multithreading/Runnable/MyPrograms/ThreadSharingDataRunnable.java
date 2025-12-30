package Module1.Multithreading.Runnable.MyPrograms;

class Counter1 {
    int count = 0;
    synchronized void increment() {
        count++;
    }
}

class MyThread1 implements Runnable {
    Counter1 counter;
    public MyThread1 (Counter1 counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i=1;i<=1000;i++) {
            counter.increment();
        }
    }
}


public class ThreadSharingDataRunnable {
    public static void main(String[] args) throws Exception {
        Counter1 counter = new Counter1();
        Runnable r1 = new MyThread1(counter);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();t2.start();
        t1.join();t2.join();

        System.out.println(counter.count);
    }
}

