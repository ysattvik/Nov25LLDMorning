package Module2.Flyweight;

import java.util.ArrayList;

class Soldier{
    private String name;
    private String weapon;
    private String image;
    private int health;
    private int x,y; // coordinates
    private String direction;

    public Soldier(String name, String weapon, String image, int health, int x, int y, String direction) {
        this.name = name;
        this.weapon = weapon;
        this.image = image;
        this.health = health;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    void render() {
        // Render the soldier on the screen
        System.out.println("Rendering soldier: " + name + " at (" + x + ", " + y + ") facing " + direction);
    }
}

public class Sol1 {
    public static void main(String[] args) {
        ArrayList<Soldier> soldiers = new ArrayList<Soldier>();

        for(int i=0; i<1000; i++) {
            String name = "Soldier" + i;
            String weapon = "Weapon"; // 5 different weapons
            String image = "Image" + (i % 3); // 3 different images
            int health = 100; // default health
            int x = i * 10; // x coordinate
            int y = i * 5; // y coordinate
            String direction = (i % 2 == 0) ? "North" : "South"; // alternate directions

            Soldier soldier = new Soldier(name, weapon, image, health, x, y, direction);
            soldiers.add(soldier);
            soldier.render();
        }
    }
}


// Cons :
// Memory Usage: Each object consumes memory, leading to high memory usage.
// Performance: Rendering 1000 soldiers can be slow, especially if each soldier has unique properties.
// Lack of Reusability: Each soldier is a separate instance, making it hard to reuse common properties.
// Scalability: As the number of soldiers increases, the performance and memory issues will worsen.