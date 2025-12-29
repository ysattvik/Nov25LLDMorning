package Module1.IntroToOOP.MyPrograms;

public final class MathUtilityClassDemo {
    public static void main(String[] args) {
        // Demonstrating the utility methods
        int a = 10, b = 20;
        
        System.out.println("Max of " + a + " and " + b + " is: " + max(a, b));
        System.out.println("Min of " + a + " and " + b + " is: " + min(a, b));
        
        int num = 5;
        System.out.println("Factorial of " + num + " is: " + factorial(num));
    }
    // Private constructor prevents instantiation
    private MathUtilityClassDemo() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    // Static method to find max of two numbers
    public static int max(int a,int b) {
        return (a > b) ? a : b;
    }

    // Static method to find min of two numbers
    public static int min(int a,int b) {
        return (a < b) ? a : b;
    }

    // Static method to calculate factorial
    public static long factorial(int n) {
        if (n <0)throw new IllegalArgumentException("Negative number not allowed");
        long result=1;
        for (int i=2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}
