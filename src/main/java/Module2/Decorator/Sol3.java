package Module2.Decorator;

// Decorator Design Pattern
// Decorator design pattern allows you to dynamically add behavior and responsibilities
// to objects without modifying their code by wrapping them in decorator objects.


// Decorator Design Pattern Components:
// Base Component: An abstract class or interface that defines the common interface for both concrete components and decorators.
// Concrete Component: Classes that implement the base component interface.
// Abstract Decorator: An abstract class that implements the base component interface and contains a reference to a component object.
// Concrete Decorators: Classes that extend the abstract decorator class and add additional behavior or state to the component.

// When to use Decorator design pattern :
// When you want to add responsibilities/behaviors to individual objects dynamically and transparently, without affecting other objects.


// Abstract Component
abstract class Burger3 {
    public abstract String description();
    public abstract double cost();
}

// Concrete Components

class VeggieBurger3 extends Burger3 {
    @Override
    public String description() {
        return "Veggie Burger";
    }

    @Override
    public double cost() {
        return 50.00;
    }
}

class CheeseBurger3 extends Burger3 {
    @Override
    public String description() {
        return "Cheese Burger";
    }

    @Override
    public double cost() {
        return 70.00;
    }
}

// Abstract Toppings
// Decorator class extends the base component
abstract class ToppingDecorator3 extends Burger3 {
    protected Burger3 burger;

    public ToppingDecorator3(Burger3 burger) {
        this.burger = burger;
    }
}

// Concrete Toppings
class CheeseDecorator extends ToppingDecorator3 {
    public CheeseDecorator(Burger3 burger) {
        super(burger);
    }

    @Override
    public String description() {
        return burger.description() + ", Extra Cheese";
    }

    @Override
    public double cost() {
        return burger.cost() + 20.00;
    }
}

class TomatoDecorator extends ToppingDecorator3 {
    public TomatoDecorator(Burger3 burger) {
        super(burger);
    }

    @Override
    public String description() {
        return burger.description() + ", Tomato";
    }

    @Override
    public double cost() {
        return burger.cost() + 10.00;
    }
}

class LettuceDecorator extends ToppingDecorator3 {
    public LettuceDecorator(Burger3 burger) {
        super(burger);
    }

    @Override
    public String description() {
        return burger.description() + ", Lettuce";
    }

    @Override
    public double cost() {
        return burger.cost() + 5.00;
    }
}

public class Sol3 {
    public static void main(String[] args) {
        Burger3 burger = new VeggieBurger3();
        burger = new TomatoDecorator(burger);
        burger = new CheeseDecorator(burger);
        System.out.println("Order: " + burger.description());
        System.out.println("Total Cost: $" + burger.cost());


        // Chaining decorators
        Burger3 burger2 = new LettuceDecorator(new CheeseDecorator(new CheeseBurger3()));
        System.out.println("Total Cost: $" + burger2.cost());
    }
}

// Cons of decorator design pattern ;
// Hard to remove or modify a decorator at runtime
// Order of the decorator matters