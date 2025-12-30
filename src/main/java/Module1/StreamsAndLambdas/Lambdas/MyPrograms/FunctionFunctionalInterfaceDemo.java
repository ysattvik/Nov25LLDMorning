package Module1.StreamsAndLambdas.Lambdas.MyPrograms;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.*;

class BillingService {
    private Function<Double, Double> discount;

    BillingService(Function<Double, Double> discount) {
        this.discount = discount;
    }

    double calculate(double amount) {
        return discount.apply(amount);
    }
}

public class FunctionFunctionalInterfaceDemo {
    public static void main(String[] args) {
        List<String> list = List.of("Hello","World");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        Function<Integer, Integer> f = x -> x * 2;
        System.out.println("Multiple by 2: "+f.apply(5));

        Function<String, Integer> f1 = String::length;
        System.out.println("String Length: "+f1.apply("Hello"));
        UnaryOperator<Integer> f2 = x -> x * x;
        System.out.println("Square of a Number: "+f2.apply(5));
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
        System.out.println("Sum of two numbers: "+sum.apply(15, 5));

        //How does andThen() differ from compose()?
        // compose → inner first = (5 + 3) * 2 = 16
        // andThen → outer first = (5 * 2) + 3 = 13
        Function<Integer, Integer> multiply = x -> x * 2;
        Function<Integer, Integer> add = x -> x + 3;
        System.out.println("Multiply then add (5 * 2) + 3 = 13: "+multiply.andThen(add).apply(5));
        System.out.println("Add then multiply (5 + 3) * 2 = 16: "+multiply.compose(add).apply(5));

        // Handle exception in Function<T, R>
        Function<Integer, Optional<Integer>> safeDivide = x -> x == 0 ? Optional.empty() : Optional.of(x);
        System.out.println("Safe divide: "+safeDivide.apply(0));

        // Function is preferred over if-else

        // Example usage of the discounts map
        String customerType = "SILVER";
        double price = 100.0;

        Map<String, Function<Double, Double>> discounts = Map.of(
                "GOLD", p -> p *0.9,
                "SILVER", p -> p *0.95,
                "COPPER" , p -> p *0.8
        );
        double finalPrice = discounts.getOrDefault(customerType, p -> p).apply(price);
        System.out.println("Final price for " + customerType + " customer: " + finalPrice);

        // Why are primitive specializations needed (IntFunction, ToIntFunction)?
        IntFunction<Integer> ff = x -> x *2;
        System.out.println("Multiply: "+ff.apply(15));
        ToIntFunction<String> len = s -> s.length();
        System.out.println("String length: "+len.applyAsInt("Hello"));

        // Can we chain multiple Functions dynamically?
        Function<Integer, Integer> pipeline = ((Function<Integer, Integer>)x -> x + 1)
                .andThen(x -> x * 2)
                .andThen(x -> x - 3);
        
        // Test the pipeline
        System.out.println("Pipeline result: " + pipeline.apply(5));  // Should print: ((5+1)*2)-3 = 9

        // Replacing Strategy Pattern with Function (Java 8+)
        Function<Double, Double> festivalDiscount =
                amount -> amount * 0.8;

        Function<Double, Double> premiumDiscount =
                amount -> amount * 0.7;

        BillingService service =
                new BillingService(festivalDiscount);

        System.out.println(service.calculate(1000)); // 800

        //Can a Lambda Return Another Lambda?
        Function<Integer, Function<Integer, Integer>> adder =
                x -> (y -> x * y);

        System.out.println(adder.apply(5).apply(10));// 15

        // Sorting
        List<String> names = List.of("John","Alice","Bob");
        names.sort((a, b) -> a.compareTo(b));
        System.out.println(names);

        // Stream Mapping
        List<Integer> nums = List.of(1,2,3);
        nums.stream().map(x -> x * x).forEach(System.out::println);

        // filtering
        nums.stream().filter(x -> x %2 ==0).forEach(System.out::println);


    }
}
