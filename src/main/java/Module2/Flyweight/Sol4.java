package Module2.Flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight design pattern is a structural pattern that allows sharing of objects to support a large number of similar objects efficiently ensuring that memory usage is optimized.

// Components of Flyweight Pattern:
// 1. Flyweight: The shared object that contains the common state.
// 2. Flyweight Factory: The factory that manages the creation and sharing of Flyweight objects.
// 3. Product: The unique data of each product that uses the Flyweight.

// When to use Flyweight Pattern?
// 1. When an application needs to support a large number of similar objects.
// 2. When the cost of creating and managing these objects is high.
// 3. When the objects share a common state or behavior, allowing them to be reused.

class SoldierType3{
    private String name;
    private String weapon;
    private String image;
    private int health;

    public SoldierType3(String name, String weapon, String image, int health) {
        this.name = name;
        this.weapon = weapon;
        this.image = image;
        this.health = health;
    }

    public void render(int x, int y, String direction) {
        // Render the soldier on the screen
        System.out.println("Rendering soldier: " + name +
                " with weapon: " + weapon + ", image: " + image + ", health: " + health +
                "at (" + x + ", " + y + ") facing " + direction);
    }
}

class Soldier4{
    private SoldierType3 soldierType;
    private int x, y; // coordinates
    private String direction;

    public Soldier4(SoldierType3 soldierType, int x, int y, String direction) {
        this.soldierType = soldierType;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void render(){
        soldierType.render(x, y, direction);
    }
}

class SoldierTypeFactory4 {
    private static final Map<String, SoldierType3> soldierTypes = new HashMap<>();

    public static SoldierType3 getSoldierType(String name, String weapon, String image, int health) {
        String key = name + weapon + image + health;
        if (!soldierTypes.containsKey(key)) {
            soldierTypes.put(key, new SoldierType3(name, weapon, image, health));
        }
        return soldierTypes.get(key);
    }
}

public class Sol4 {
    public static void main(String[] args) {
        SoldierType3 soldiertyp1 = SoldierTypeFactory4.getSoldierType("SoldierType1", "AK47", "SoldierImage1", 100);
        SoldierType3 soldiertyp2 = SoldierTypeFactory4.getSoldierType("SoldierType2", "M16", "SoldierImage2", 100);
        SoldierType3 soldiertyp3 = SoldierTypeFactory4.getSoldierType("SoldierType1", "AK47", "SoldierImage1", 100);

        Soldier4[] soldiers = new Soldier4[1000];
        for(int i=0; i<1000; i++) {
            int x = i * 10; // x coordinate
            int y = i * 5; // y coordinate
            String direction = (i % 2 == 0) ? "North" : "South"; // alternate directions

            // Alternate between two soldier types
            SoldierType3 soldierType = (i % 2 == 0) ? soldiertyp1 : soldiertyp2;
            soldiers[i] = new Soldier4(soldierType, x, y, direction);
            soldiers[i].render();
        }
    }
}

// Pros :

// Memory Efficiency: By reusing SoldierType3 instances, memory usage is significantly reduced compared to creating separate instances for each soldier.
// Scalability: The flyweight pattern allows for efficient scaling as the number of soldiers increases, without a proportional increase in memory usage.
// Reusability: The factory pattern promotes reusability of soldier types, making it easier to manage and maintain the code.
// Can create multiple soldiers with the same type without creating duplicates.
// Performance Improvement: Rendering soldiers is faster due to reduced memory overhead and efficient management of soldier types.