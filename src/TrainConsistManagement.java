import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagement {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Step 1: Create HashMap for bogie → capacity mapping
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Step 2: Insert bogie capacities (Passenger bogies)
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 24);

        // Optional: Goods bogies (load capacity example)
        bogieCapacityMap.put("Rectangular Goods", 100);
        bogieCapacityMap.put("Cylindrical Goods", 80);

        // Step 3: Display all bogies with capacities
        System.out.println("\n--- Bogie Capacity Details ---\n");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        // Step 4: Example lookup (fast access)
        System.out.println("\nCapacity lookup for Sleeper:");
        int sleeperCapacity = bogieCapacityMap.get("Sleeper");
        System.out.println("Sleeper Capacity: " + sleeperCapacity);
    }
}