package Module2.Flyweight;

class SoldierType{
    private String name;
    private String weapon;
    private String image;
    private int health;

    public SoldierType(String name, String weapon, String image, int health) {
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

class Soldier3{
    private SoldierType soldierType;
    private int x, y; // coordinates
    private String direction;

    public Soldier3(SoldierType soldierType, int x, int y, String direction) {
        this.soldierType = soldierType;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void render(){
       soldierType.render(x, y, direction);
    }
}

public class Sol3 {
    public static void main(String[] args) {
        SoldierType soldierType1 = new SoldierType("SoldierType1", "AK47", "SoldierImage1", 100);
        SoldierType soldierType2 = new SoldierType("SoldierType2", "M16", "SoldierImage2", 100);
        //SoldierType soldierType3 = new SoldierType("SoldierType1", "AK47", "SoldierImage1", 100); // Duplicate soldierType

        Soldier3[] soldiers = new Soldier3[1000];
        for(int i=0; i<1000; i++) {
            int x = i * 10; // x coordinate
            int y = i * 5; // y coordinate
            String direction = (i % 2 == 0) ? "North" : "South"; // alternate directions

            // Alternate between two soldier types
            SoldierType soldierType = (i % 2 == 0) ? soldierType1 : soldierType2;
            soldiers[i] = new Soldier3(soldierType, x, y, direction);
            soldiers[i].render();
        }
    }
}


// Pros :
// 1. Memory Efficiency: By sharing common soldier properties, memory usage is significantly reduced.
// 2. Improved Performance: Rendering is faster due to reduced memory overhead.
// Divided soldier data into two classes: SoldierType for shared properties and Soldier3 for individual instances.
// Intrinsic data & Extrinsic data separation: