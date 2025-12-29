package Module1.IntroToOOP.MyPrograms;

class Person1 implements Cloneable {
    String name;

    Person1(String name) {
        this.name = name;
    }

    public Object clone()throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestClone {
    public static void main(String[] args)throws CloneNotSupportedException {
        Person1 original=new Person1("Yoga");
        Person1 copy= (Person1) original.clone();
        System.out.println("Original: " + original.name);
        System.out.println("Copy: " + copy.name);
    }
}

