package Module1.Multithreading.Runnable.MyPrograms;

class Mythreads extends Thread {
    private String threadName;

    public Mythreads(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run () {
       for (int i=1;i<=10;i++) {
           System.out.println(threadName + " running - iteration "+i+" | Thread: "+Thread.currentThread().getName());
       }
       try {
           Thread.sleep(500);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

    }
}
public class MultipleThreadsWithThreadClass {
    public static void main(String[] args) {
        Mythreads t1 = new Mythreads("Tasks - 1");
        Mythreads t2 = new Mythreads("Tasks - 2");
        Mythreads t3 = new Mythreads("Tasks - 3");
        Mythreads t4 = new Mythreads("Tasks - 4");
        Mythreads t5 = new Mythreads("Tasks - 5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
