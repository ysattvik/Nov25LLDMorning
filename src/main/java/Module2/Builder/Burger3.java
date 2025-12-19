package Module2.Builder;

public class Burger3 {
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

    // Required ingredients constructor
    public Burger3 (String bun, String patty) {
        this.bun = bun;
        this.patty = patty;
    }

//    void setBun(String bun) {
//        this.bun = bun;
//    }
//
//    public void setPatty(String patty) {
//        this.patty = patty;
//    }

    void setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
    }

    void setHasTomato(boolean hasTomato) {
        this.hasTomato = hasTomato;
    }

    void setHasLettuce(boolean hasLettuce) {
        this.hasLettuce = hasLettuce;
    }

    void setHasOnion(boolean hasOnion) {
        if(!hasLettuce){
            this.hasOnion = hasOnion;
        }else{
            throw new IllegalArgumentException("Onion can only be added if lettuce is not present");
        }
    }

    void setHasPickles(boolean hasPickles) {
        if(hasOnion) {
            this.hasPickles = hasPickles;
        }else{
            throw new IllegalArgumentException("Pickles can only be added if onion is present");
        }
    }

    void setHasJalepenos(boolean hasJalepenos) {
        this.hasJalepenos = hasJalepenos;
    }
}

class Client3 {
    public static void main(String[] args) {
        Burger3 burger = new Burger3("Sesame", "Veggie");
        burger.setHasCheese(true);
        burger.setHasLettuce(true);
        burger.setHasPickles(true);
        burger.setHasCheese(false);
    }
}

// Pros :
// 2. Simpler constructor for required ingredients only, making it easier to create a basic burger.
// 3. Validation logic for optional ingredients is included in setter methods to enforce dependencies.

// Cons :
// 1. Able to choose optional ingredients only after creating the Burger object which can lead to errors because of validation dependencies between optional ingredients.
// 2. Not mutable fields for required ingredients, but optional ingredients are mutable which can lead to inconsistent state if not handled properly.
// 3. You can still create a burger without required ingredients if you provide empty strings, no validation for required ingredients.
// 4. Validation are scattered across multiple setter methods, making it harder to maintain and ensure consistency. Not centralized.