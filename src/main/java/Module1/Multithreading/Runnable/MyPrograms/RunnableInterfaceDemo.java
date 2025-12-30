package Module1.Multithreading.Runnable.MyPrograms;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread : "+Thread.currentThread().getName()+" is running");
    }
}
public class RunnableInterfaceDemo {
    public static void main(String[] args) {
        Runnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);

        myThread.start();
    }
}
