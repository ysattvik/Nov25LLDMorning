package Module1.Multithreading.Runnable.MyPrograms;

public class ParrelExecutionDemo {
    public static void main(String[] args) throws InterruptedException {
        int arr[] = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        class SumThread extends Thread{
            int start, end;
            long sum=0;

            SumThread(int start, int end) {
                this.start = start;
                this.end = end;
            }
            @Override
            public void run() {
                for  (int i = start; i <end; i++) {
                    sum += arr[i];
                }
            }
        }
        int mid = arr.length/2;
        SumThread t1 = new SumThread(0, mid);
        SumThread t2 = new SumThread(mid, arr.length);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Total Sum : "+(t1.sum + t2.sum));

    }
}
