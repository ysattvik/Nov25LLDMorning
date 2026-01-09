package Module2.Flyweight;

import java.util.ArrayList;

class SoldierAsset{
    public static final String weapon = "AK47";
    public static final String image = "SoldierImage";
    public static final int health = 100;
}

class Soldier2{
    String name;
    int x, y; // coordinates
    String direction;

    public Soldier2(String name, int x, int y, String direction) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void render() {
        // Render the soldier on the screen
        System.out.println("Rendering soldier: " + name + " at (" + x + ", " + y + ") facing " + direction +
                " with weapon: " + SoldierAsset.weapon + ", image: " + SoldierAsset.image + ", health: " + SoldierAsset.health);
    }
}

public class Sol2 {
    public static void main(String[] args) {
        ArrayList<Soldier2> soldiers = new ArrayList<Soldier2>();

        for(int i=0; i<1000; i++) {
            String name = "Soldier" + i;
            int x = i * 10; // x coordinate
            int y = i * 5; // y coordinate
            String direction = (i % 2 == 0) ? "North" : "South"; // alternate directions

            Soldier2 soldier = new Soldier2(name, x, y, direction);
            soldiers.add(soldier);
            soldier.render();
        }
    }
}

// Pros :
// Memory Efficiency: Shared properties (weapon, image, health) are stored in a single SoldierAsset class, reducing memory usage.
// Performance Improvement: Rendering is faster as common properties are reused.
// Reusability: Common properties are defined in a single class, making it easy to manage.
// Scalability: The design can handle a larger number of soldiers without significant performance degradation.

// Cons :
// If we have multiple different assets for soldiers, we need to create multiple static classes for each asset type.
// What if someone creates a duplicate soldierType with same assets? This can lead to confusion and bugs.