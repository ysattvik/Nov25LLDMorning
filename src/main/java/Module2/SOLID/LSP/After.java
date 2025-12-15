package Module2.SOLID.LSP;

public class After {
    // Liskov Substitution Principle (LSP) states that objects of a superclass should be replaceable with objects
    // of a subclass without affecting the correctness/behavior of the program.

    abstract static class Bird {
        public abstract void eat();
    }

    abstract static class FlyingBird extends Bird {
        public void fly(){
            System.out.println("I can fly");
        };
    }

    public static class Sparrow extends FlyingBird {
        @Override
        public void eat() {
            System.out.println("Sparrow is eating seeds.");
        }

        // Altering the behavior of the fly method
        // Voilating the LSP
        @Override
        public void fly() {
            System.out.println("Sparrow is sleeping.");
        }
    };

    public static class Penguin extends Bird {
        @Override
        public void eat() {
            System.out.println("Penguin is eating fish.");
        }
    };

    public static void main(String[] args) {
        FlyingBird sp = new Sparrow();
        sp.eat();
        sp.fly();

        Bird pe = new Penguin();
        pe.eat();
        //pe.fly
    }

}

// Where is LSP voilated ?
// Subclass alters expected behavior of the superclass methods.
// Subclass throws exceptions that the superclass does not throw.

// How to apply LSP ?
// 1. Ensure that subclasses extend the behavior of the superclass without changing its original functionality.
// 2. Use abstract classes or interfaces to define clear contracts for subclasses to follow.