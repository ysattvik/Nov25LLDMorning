package Module1.Polymorphism.MyPrograms;

class Parent{
    int x= 10;
    public void show(){
        System.out.println("Parent show()");
    }
}
public class MethodOverriddingDemo extends Parent {
    int x = 20;
    @Override
    public void show(){
        System.out.println("Child show()");
    }

    public static void main(String[] args) {
        Parent parent=new MethodOverriddingDemo();
        parent.show();// this will print child show() method
        System.out.println("field Values: "+parent.x); // this will print parent class field
    }
}
