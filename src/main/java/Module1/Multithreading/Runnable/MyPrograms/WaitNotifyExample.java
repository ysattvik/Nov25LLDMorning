package Module1.Multithreading.Runnable.MyPrograms;

class SharedResource {
    synchronized void doWait() {
        try {
            System.out.println(Thread.currentThread().getName() +" waiting");
            wait();// release lock and wait until notified
            System.out.println(Thread.currentThread().getName() +" resumed");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void doNotify() {
        notify();// wake up waiting thread
    }
}

public class WaitNotifyExample {
    public static void main(String[] args)throws InterruptedException {
        SharedResource resource=new SharedResource();

        Thread t1=new Thread(() -> resource.doWait(),"Thread-1");
        System.out.println("Thread State : "+t1.getState());
        t1.start();
        System.out.println("Thread State : "+t1.getState());
        Thread.sleep(2000);// ensure t1 is waiting
        System.out.println("Thread State : "+t1.getState());
        resource.doNotify();
        System.out.println("Thread State : "+t1.getState());
    }
}

