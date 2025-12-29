package Module1.IntroToOOP.MyPrograms;

class Person {

    void show() {
        System.out.println("Person object created using Reflection");
    }
}

public class TestReflection {
    public static void main(String[] args) throws Exception {
        // Creating object without 'new' using reflection
        Class<?> clazz = Class.forName("Module1.IntroToOOP.MyPrograms.Person");
        Person p = (Person) clazz.getDeclaredConstructor().newInstance();
        p.show();
    }
}
