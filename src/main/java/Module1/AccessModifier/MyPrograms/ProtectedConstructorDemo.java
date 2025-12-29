package Module1.AccessModifier.MyPrograms;


class BaseClass {
    protected BaseClass() {
        System.out.println("Protected Constructor");
    }
    public void method() {
        System.out.println("BaseClass method");
    }
}
public class ProtectedConstructorDemo extends BaseClass {
    public ProtectedConstructorDemo() {
        super();
    }
    public void derievedMethod() {

        System.out.println("Derived Method");
    }
    public static void main(String[] args) {
        BaseClass baseClass = new BaseClass();
        baseClass.method();
        ProtectedConstructorDemo protectedConstructorDemo = new ProtectedConstructorDemo();
        protectedConstructorDemo.derievedMethod();
    }
}
