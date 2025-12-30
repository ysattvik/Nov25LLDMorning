package Module1.Multithreading.Runnable.MyPrograms;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SharedData {
    volatile boolean finished = false;
}

public class MultiThreadedExample {
    public static void main(String[] args) throws Exception {
        SharedData sharedData = new SharedData();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            sharedData.finished = true;
            return "Task - 1 done";
        };

        Callable<String> task2 = () -> {
            while (!sharedData.finished) {
                Thread.sleep(1000);
            }
            return "Task - 2 done";
        };

        Future<String> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);

        System.out.println("Future 1: " + future1.get());
        System.out.println("Future 2: " + future2.get());

        executor.shutdown();



    }
}
