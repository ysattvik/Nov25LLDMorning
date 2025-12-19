package Module2.Builder;

public class Burger2 {
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

    public Burger2(String bun, String patty) {
        this.bun = bun;
        this.patty = patty;
    }

    public Burger2(String bun, String patty, boolean hasCheese) {
        this(bun, patty);
        this.hasCheese = hasCheese;
    }

    /// // Not allowed since function signature is same as above
//    public Burger2(String bun, String patty, boolean hasOnion) {
//        this(bun, patty);
//        this.hasOnion = hasOnion;
//    }

    // Changed the signature here to include hasOnion
    // But this is not scalable as we add more optional ingredients
    public Burger2(String bun, boolean hasOnion, String patty) {
        this(bun, patty);
        this.hasOnion = hasOnion;
    }

    public Burger2(String bun, String patty, boolean hasCheese, boolean hasTomato) {
        this(bun, patty, hasCheese);
        this.hasTomato = hasTomato;
    }
}

class client2 {
    public static void main(String[] args) {
        // Creating a burger with required ingredients only
        Burger2 burger = new Burger2("", "Veggie");
    }
}



// Cons :
// Constructor explosion : As the number of optional ingredients increases, the number of constructors grows exponentially, leading to a "constructor explosion" problem.
// Not able to create all combinations of optional ingredients since function signatures clash.
// No validations : There's no way to enforce rules or validations on the combinations of optional ingredients. For example, if you want to ensure that pickles can only be added if onions are present, this approach doesn't support such logic.
// No validations for required ingredients : Able to create a burger without required ingredients (e.g., bun or patty), which is not valid. Missing validation for required ingredients.
// Difficult to read and maintain : With many constructors, it becomes challenging to read and maintain the code, especially as more optional ingredients are added.