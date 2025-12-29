package Module1.AccessModifier.MyPrograms;

//private class TopLevelClass {
//protected class TopLevelClass {
// Top level class can not be private and protected . It can only either default or public
public class TopLevelClass {
    // Inner class can be public, private, default or protected
    private static class InnerClass {
        public void method() {
            System.out.print("InnerClass can be private");
        }

    }
    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
        ic.method();
    }
}
