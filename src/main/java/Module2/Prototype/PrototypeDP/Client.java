package Module2.Prototype.PrototypeDP;

public class Client {
    public static void main(String[] args) {
        Mage mage1 = new Mage(
                "Jaina",
                new Weapon("Frost Staff", 80),
                new Stats(100, 200),
                new AI("Aggressive")
        );

        Mage magecopy = mage1.clone(); // create a new object using the clone method
        magecopy.weapon.setName("Rifle");
        System.out.println("Original Mage Address: " + mage1 + " Original Mage Info "+mage1.getInfo());
        System.out.println("Clone Mage Address: " + magecopy + " Original Mage info "+magecopy.getInfo());
    }
}
