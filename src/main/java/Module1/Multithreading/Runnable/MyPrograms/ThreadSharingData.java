package Module1.Multithreading.Runnable.MyPrograms;

class Counter {
    int count = 0;
    synchronized void increment() {
        count++;
    }
}

class MyThread extends Thread {
    Counter counter;
    public MyThread (Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i=1;i<=1000;i++) {
            counter.increment();
        }
    }
}


public class ThreadSharingData {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        Thread t1 = new MyThread(counter);
        Thread t2 = new MyThread(counter);
        t1.start();t2.start();
        t1.join();t2.join();

        System.out.println(counter.count);
    }
}
