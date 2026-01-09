package Module2.Decorator;

abstract class Burger2 {
    protected boolean extraCheese = false;
    protected boolean tomato = false;
    protected boolean lettuce = false;
    protected boolean onion = false;

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }

    public void setLettuce(boolean lettuce) {
        this.lettuce = lettuce;
    }

    public void setOnion(boolean onion) {
        this.onion = onion;
    }

    public abstract String description();
    public abstract double cost();
}

class VeggieBurger2 extends Burger2 {

    @Override
    public String description() {
        String base =  "Veggie Burger";
        if (extraCheese) {
            base += ", Extra Cheese";
        }
        if (tomato) {
            base += ", Tomato";
        }
        if (lettuce) {
            base += ", Lettuce";
        }
        if (onion) {
            base += ", Onion";
        }
        return base;
    }

    @Override
    public double cost() {
        double base =  50.00;
        if (extraCheese) {
            base += 20.00;
        }
        if (tomato) {
            base += 10.00;
        }
        if (lettuce) {
            base += 5.00;
        }
        if (onion) {
            base += 5.00;
        }
        return base;
    }
}

class CheeseBurger2 extends Burger2 {

    @Override
    public String description() {
        String base =  "Cheese Burger";
        if (extraCheese) {
            base += ", Extra Cheese";
        }
        if (tomato) {
            base += ", Tomato";
        }
        if (lettuce) {
            base += ", Lettuce";
        }
        if (onion) {
            base += ", Onion";
        }
        return base;
    }

    @Override
    public double cost() {
        double base =  60.00;
        if (extraCheese) {
            base += 20.00;
        }
        if (tomato) {
            base += 10.00;
        }
        if (lettuce) {
            base += 5.00;
        }
        if (onion) {
            base += 5.00;
        }
        return base;
    }
}

public class Sol2 {
    public static void main(String[] args) {
        VeggieBurger2 burger = new VeggieBurger2();
        burger.setExtraCheese(true);
        burger.setTomato(true);
        System.out.println("Order: " + burger.description());
        System.out.println("Total Cost: $" + burger.cost());
    }
}

// Pros :
// Much better than Sol1 as we are not creating a new class for every combination
// We can choose toppings at runtime

// Cons :
// Voilates OCP
// Too many if-else statements
// Hard to maintain and extend