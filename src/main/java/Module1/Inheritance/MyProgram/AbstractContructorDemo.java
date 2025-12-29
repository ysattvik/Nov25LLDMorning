package Module1.Inheritance.MyProgram;

abstract class Parent{
    private String name;
    public Parent(String name) {
        this.name = name;
        System.out.println("Parent Constructor");
    }
    public void show(){
        System.out.println("name:"+name);
    }
    public abstract void method();

}
public class AbstractContructorDemo extends Parent{
    private String name;
    public AbstractContructorDemo(String name){
        super(name);
        System.out.println("AbstractContructorDemo Constructor");
    }
    @Override
    public void method() {
        System.out.println("Overridden method");
    }
    public static void main(String[] args) {
        Parent parent=new AbstractContructorDemo("John");
        parent.show();
        parent.method();
    }
}
