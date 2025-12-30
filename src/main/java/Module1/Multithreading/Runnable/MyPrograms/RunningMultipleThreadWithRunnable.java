package Module1.Multithreading.Runnable.MyPrograms;

class MyThreads implements Runnable {
    private String taskName;

    public MyThreads(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i=1;i<=10;i++) {
            System.out.println(taskName + " running - iteration "+i+" | Thread: "+Thread.currentThread().getName());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class RunningMultipleThreadWithRunnable {
    public static void main(String[] args) {
        Runnable myRunnable = new MyThreads("MyRunnable");

        Thread t1 = new Thread(myRunnable, " Thread - 1");
        Thread t2 = new Thread(myRunnable, " Thread - 2");
        Thread t3 = new Thread(myRunnable, " Thread - 3");

        t1.start();
        t2.start();
        t3.start();


    }
}
