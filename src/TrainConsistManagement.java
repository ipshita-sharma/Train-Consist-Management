import java.util.*;

// -------------------- BOGIE CLASS --------------------

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void display() {
        System.out.println("Bogie: " + name + " | Capacity: " + capacity);
    }
}


// -------------------- MAIN APPLICATION --------------------

public class TrainConsistManagement {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Step 1: Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        // Step 2: Sort bogies by capacity (ascending order)
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Step 3: Display sorted bogies
        System.out.println("\n--- Bogies Sorted by Capacity (Ascending) ---\n");

        for (Bogie b : bogies) {
            b.display();
        }

        // Step 4: Optional → Sort in descending order
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\n--- Bogies Sorted by Capacity (Descending) ---\n");

        for (Bogie b : bogies) {
            b.display();
        }
    }
}