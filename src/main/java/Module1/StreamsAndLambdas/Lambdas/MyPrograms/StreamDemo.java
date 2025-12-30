package Module1.StreamsAndLambdas.Lambdas.MyPrograms;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> result = Stream.of("a","aa","aaa")
                .filter(x -> x.length() >1)
                .map(String::toUpperCase)
                .collect(Collectors.toList());// triggers execution
        System.out.println(result);// [AA, AAA]

        //Difference Between map and flatMap
        List<List<String>> list = List.of(List.of("a","b"), List.of("c","d"));
        list.stream().map(l -> l.stream()).forEach(System.out::println);// Stream<Stream<String>>
        list.stream().flatMap(l -> l.stream()).forEach(System.out::println);// Stream<String>

        // What is the difference between findFirst() and findAny()?
        List<Integer> numbers = List.of(1,2,3,4,5);
        numbers.stream().findFirst().ifPresent(System.out::println);// 1
        numbers.parallelStream().findAny().ifPresent(System.out::println);// any number

        //Parallel  Streams
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9);
        int sum= nums.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);// 45

        // groupingBy
        List<String> names = List.of("Alice","Bob","Charlie");
        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(grouped);// {3=[Bob], 5=[Alice], 7=[Charlie]}

        // Filter-Map-Reduce
        int sum1= IntStream.range(1,10)
                .filter(x -> x %2 ==0)
                .map(x -> x * x)
                .sum();// 4+16+36=56
        System.out.println("sum: "+sum1);

        // Grouping/Partitioning
        Map<Boolean, List<String>> partitioned = List.of("Alice","Bob","Charlie")
                .stream()
                .collect(Collectors.partitioningBy(s -> s.length() >3));

        // Function Composition
        Function<String, String> greet = s ->"Hello " + s;
        Function<String, String> excited = s -> s +"!";
        System.out.println(greet.andThen(excited).apply("Alice"));// Hello Alice!
    }
}
