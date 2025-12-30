package Module1.Multithreading.Runnable.MyPrograms;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Concurrent but not necessarily parallel
        numbers.stream().forEach(System.out::println);

        // Parallel (multi-core)
        numbers.parallelStream().forEach(System.out::println);
    }
}
