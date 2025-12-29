package Module1.IntroToOOP.MyPrograms;

import java.io.*;

class Person2 implements Serializable {
    String name;

    Person2(String name) {
        this.name = name;
    }
}

public class TestSerialization {
    public static void main(String[] args)throws Exception {
// Serialize object
        Person2 p1 = new Person2("Yoga");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"));
        out.writeObject(p1);
        out.close();

// Deserialize object (creates new object without 'new')
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"));
        Person2 p2= (Person2) in.readObject();
        in.close();

        System.out.println("Deserialized: " + p2.name);
    }
}

