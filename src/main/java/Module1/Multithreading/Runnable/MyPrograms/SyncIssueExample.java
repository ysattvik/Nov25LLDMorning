package Module1.Multithreading.Runnable.MyPrograms;

class SharedData1 {
  private int count = 0;
  //Lock only a critical section, not entire method → better performance.
  private final Object lock = new Object();

   // race condition, data is not synchronized
     // void increment() { count++; }
    // void decrement() { count--; }

   //synchronized void increment() { count++; }
   //synchronized void decrement() { count--; }

    void increment() {
        synchronized (lock){ // mutex lock, mutual exclusion - lock only the critical section
            count++;
        }
    }
    void decrement() {
        synchronized (lock){
            count--;
        }
    }
    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
}

public class SyncIssueExample {
    public static void main(String[] args) throws Exception{
        SharedData1 sharedData = new SharedData1();
        Runnable adder = () -> {
            for (int i=0;i<1000;i++) sharedData.increment();
        };
        Runnable subtractor = () -> {
            for (int i=0;i<1000;i++) sharedData.decrement();
        };

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);
        t1.start(); t2.start();

        t1.join();
        t2.join();

        System.out.println("Shared Data: "+sharedData.getCount());

    }
}
