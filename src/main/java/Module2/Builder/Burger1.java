package Module2.Builder;

public class Burger1 {
    // Required ingredients
    private String bun;
    private String patty;

    // Optional ingredients
    private boolean hasCheese;
    private boolean hasTomato;
    private boolean hasLettuce;
    private boolean hasOnion;
    private boolean hasPickles;
    private boolean hasJalepenos;

    Burger1 (String bun, String patty, boolean cheese, boolean lettuce, boolean tomato, boolean onion, boolean pickles, boolean jalepenos) {
        this.bun = bun;
        this.patty = patty;
        this.hasCheese = cheese;
        this.hasTomato = tomato;
        this.hasLettuce = lettuce;
        this.hasOnion = onion;
        this.hasPickles = pickles;
        this.hasJalepenos = jalepenos;
    }
}

class Client1{
    public static void main(String[] args) {
        // Creating a burger with required ingredients only
        //Burger1 burger = new Burger1("Sesame", "Veggie", true, true, true, false, true);
        Burger1 burger2 = new Burger1("", "Veggie", true, true, true, false, true, false);

        Burger1 burh = new Burger1("", "", true, true, true, false, true, false);

    }
}

// Cons :
// 1. The constructor is too long and complex, making it hard to read and maintain.
// 2. Need to lookup the order of parameters to understand what each parameter means.
// 3. Error prone: if you pass parameters in the wrong order, it can lead to bugs that are hard to trace.
// 4. Adding new optional ingredients requires changing the constructor, which can break existing code.
// 5. Able to create a burger without required ingredients (e.g., bun or patty), which is not valid. Missing validation for required ingredients.
// 6. Not scalable: As more optional ingredients are added, the constructor becomes even longer and more unwieldy.
// 7. No validation logic to enforce dependencies between optional ingredients (e.g., onion can only be added if lettuce is not present).