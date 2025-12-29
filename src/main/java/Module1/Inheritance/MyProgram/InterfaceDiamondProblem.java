package Module1.Inheritance.MyProgram;

interface A {
    default void show() {
        System.out.println("Interface A");
    }
}
interface B {
    default void show() {
        System.out.println("Interface B");
    }
}
public class InterfaceDiamondProblem implements A, B{
    public static void main(String[] args) {
        InterfaceDiamondProblem  interfaceDiamondProblem = new InterfaceDiamondProblem();
        interfaceDiamondProblem.show();
    }

    @Override
    public void show() {
        A.super.show();
        B.super.show();
    }
}
