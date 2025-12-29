package Module1.IntroToOOP.MyPrograms;

public final class StringUtils {

    private StringUtils() {
        throw new AssertionError("Cannot instantiate utility class");
    }

    public static boolean isEmpty(String str) {
        return str ==null || str.isEmpty();
    }

    public static String reverse(String str) {
        if (str ==null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isEmpty(""));       // true
        System.out.println(StringUtils.reverse("Java"));   // avaJ
    }
}
