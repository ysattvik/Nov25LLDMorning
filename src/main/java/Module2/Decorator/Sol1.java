package Module2.Decorator;

// Abstract Component
abstract class Burger {
    public abstract String description();
    public abstract double cost();
}

// Concrete Components // Base Burgers
class VeggieBurger extends Burger {
    @Override
    public String description() {
        return "Veggie Burger";
    }

    @Override
    public double cost() {
        return 50.00;
    }
}

class CheeseBurger extends Burger {
    @Override
    public String description() {
        return "Cheese Burger";
    }

    @Override
    public double cost() {
        return 70.00;
    }
}

// Extra toppings
// Extra cheese, tomato, lettuce, onion, dip

class VeggieBurgerWithTomato extends VeggieBurger{
    private Burger burger;

    public VeggieBurgerWithTomato(Burger burger) {
        this.burger = burger;
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

class VeggieBurgerWithLettuce extends VeggieBurger{
    private Burger burger;

    public VeggieBurgerWithLettuce(Burger burger) {
        this.burger = burger;
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

class VeggieBurgerWithTomatoAndLettuce extends VeggieBurger{
    private Burger burger;

    public VeggieBurgerWithTomatoAndLettuce(Burger burger) {
        this.burger = burger;
    }

    @Override
    public String description() {
        return burger.description() + ", Tomato, Lettuce";
    }

    @Override
    public double cost() {
        return burger.cost() + 10.00 + 5.00;
    }
}

public class Sol1 {
}


// We tried to use inhertiance to add toppings to burgers. But it became a class explosion problem.
// Class Explosion
// Changing the ocst of a topping would require changing in multiple classes.
// Not scalable for more toppings.