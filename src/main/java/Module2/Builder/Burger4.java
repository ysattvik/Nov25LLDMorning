package Module2.Builder;

// Builder Pattern Pattern is a creational design pattern that allows for the step-by-step construction of complex objects.
// It is particularly useful when an object requires many parameters, some of which are optional.

// Intent of the Builder Pattern:
// 1. To separate the construction of a complex object from its representation so that the same construction process can create different representations.

// Structure of the Builder Pattern:
// 1. Builder: A static inner class that constructs the object step by step.
// 2. Product: The complex object that is being built.
// 3. Client: The class that uses the Builder to create the object.

public class Burger4 {
    // Required ingredients
    private final String bun;
    private final String patty;

    // Optional ingredients
    private final boolean hasCheese;
    private final boolean hasTomato;
    private final boolean hasLettuce;
    private final boolean hasOnion;
    private final boolean hasPickles;
    private final boolean hasJalepenos;

    //public Burger4(){}

    // Make constructor private to force object creation through Builder
    private Burger4(Builder builder){
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.hasCheese = builder.hasCheese;
        this.hasTomato = builder.hasTomato;
        this.hasLettuce = builder.hasLettuce;
        this.hasOnion = builder.hasOnion;
        this.hasPickles = builder.hasPickles;
        this.hasJalepenos = builder.hasJalepenos;
    }

    public static class Builder {
        // Copy all the attributes from Burger4(product) class

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

        // Builder constructor for required ingredients
        public Builder(String bun, String patty) {
            this.bun = bun;
            this.patty = patty;
        }

        //Method chaining for optional ingredients
        public Builder setHasCheese(boolean hasCheese) {
            this.hasCheese = hasCheese;
            return this;
        }
        public Builder setHasTomato(boolean hasTomato) {
            this.hasTomato = hasTomato;
            return this;
        }
        public Builder setHasLettuce(boolean hasLettuce) {
            this.hasLettuce = hasLettuce;
            return this;
        }
        public Builder setHasOnion(boolean hasOnion) {
            this.hasOnion = hasOnion;
            return this;
        }
        public Builder setHasPickles(boolean hasPickles) {
            this.hasPickles = hasPickles;
            return this;
        }
        public Builder setHasJalepenos(boolean hasJalepenos) {
            this.hasJalepenos = hasJalepenos;
            return this;
        }

        // Build method to create Burger4 object
        public Burger4 build() {
            // You can add validations here before you actually build the product
            if(hasLettuce && hasOnion) {
                throw new IllegalArgumentException("Onion can only be added if lettuce is not present");
            }
            if(hasPickles && !hasOnion) {
                throw new IllegalArgumentException("Pickles can only be added if onion is present");
            }
            if(bun == null || patty == null) {
                throw new IllegalArgumentException("Bun and Patty are required ingredients");
            }


            return new Burger4(this);
        }
    }
}

class Client4 {
    public static void main(String[] args) {
        // Using the Builder to create a Burger4 object
        Burger4.Builder builder = new Burger4.Builder("Sesame", "Veggie");
        builder.setHasCheese(true)
               .setHasTomato(true)
               .setHasLettuce(false)
               .setHasOnion(true)
               .setHasPickles(true)
               .setHasJalepenos(false);

        Burger4 burger1 = new Burger4.Builder("Whole Wheat", "Chicken")
                .setHasCheese(true)
                .setHasTomato(true)
                .setHasLettuce(true)
                .build();

    }
}

// What about validations?
// -> All validations are centralized in the build() method of the Builder class ensuring that the constructed object is always in a valid state.

// What about immutability?
// -> The Builder pattern cam create immutable objects by using final fields and not providing setters for the fields in the Product class.

// Pros :
// 1. Improved readability: The Builder pattern provides a clear and fluent interface for constructing complex objects, making the code easier to read and understand.
// 2. Flexibility: It allows for optional parameters and different configurations without the need for multiple constructors.
// 3. Immutability: The constructed object can be made immutable by using final fields and not providing setters.
// 4. Centralized validation: All validations can be centralized in the build() method, ensuring that the object is always created in a valid state.
// 5. Scalability: As more optional parameters are added, the Builder pattern scales well without making the constructor unwieldy.

// Cons :
// 1. Increased complexity: The Builder pattern introduces additional classes and code, which can increase the overall complexity of the codebase.
// 2. Boilerplate code: The Builder pattern can lead to more boilerplate code, especially for simple objects that do not require complex construction.
