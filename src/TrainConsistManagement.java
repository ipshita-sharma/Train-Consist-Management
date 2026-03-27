import java.util.*;
import java.util.stream.*;

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

        // Step 1: Create bogie list (reuse from UC9)
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Step 2: Calculate total seating capacity using Stream
        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())     // Extract capacity
                .reduce(0, Integer::sum);      // Aggregate (sum)

        // Step 3: Display total capacity
        System.out.println("\n--- Total Seating Capacity ---\n");
        System.out.println("Total Seats in Train: " + totalSeats);

        // Step 4: Show original list unchanged
        System.out.println("\n--- Original Bogie List ---\n");
        for (Bogie b : bogies) {
            b.display();
        }
    }
}