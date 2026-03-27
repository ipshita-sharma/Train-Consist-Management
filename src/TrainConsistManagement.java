import java.util.*;
import java.util.stream.Collectors;

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

        // Step 1: Create bogie list (reuse from UC8)
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("Sleeper", 70)); // duplicate type for grouping
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("AC Chair", 58));

        // Step 2: Group bogies by type (name)
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // Step 3: Display grouped structure
        System.out.println("\n--- Grouped Bogies by Type ---\n");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("   Capacity: " + b.getCapacity());
            }

            System.out.println();
        }

        // Step 4: Verify original list remains unchanged
        System.out.println("--- Original List (Unchanged) ---\n");
        for (Bogie b : bogies) {
            b.display();
        }
    }
}