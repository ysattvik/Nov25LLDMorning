package Module1.AccessModifier.MyPrograms;

class Parent{
    private void method(){
        System.out.println("Parent method");
    }
}

public class PrivateMethodOverride extends Parent{
    void method(){
        System.out.println("Child method");
    }
    public static void main(String[] args) {
        PrivateMethodOverride  privateMethodOverride = new PrivateMethodOverride();
        privateMethodOverride.method();
    }
}
