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

        // Step 1: Create bogie list (reuse from UC7)
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        // Step 2: Apply Stream filtering (capacity > 60)
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        // Step 3: Display filtered bogies
        System.out.println("\n--- Filtered Bogies (Capacity > 60) ---\n");

        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            for (Bogie b : filteredBogies) {
                b.display();
            }
        }

        // Step 4: Show original list remains unchanged
        System.out.println("\n--- Original Bogie List (Unchanged) ---\n");
        for (Bogie b : bogies) {
            b.display();
        }
    }
}