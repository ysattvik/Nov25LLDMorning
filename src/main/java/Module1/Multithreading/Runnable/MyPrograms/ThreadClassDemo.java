package Module1.Multithreading.Runnable.MyPrograms;

class Mythread extends Thread {
    @Override
    public void run() {
        System.out.println("Mythread "+Thread.currentThread().getName()+" is running");
    }
}
public class ThreadClassDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new Mythread());
        t.start();
        System.out.println("Mythread is running");

    }
}
