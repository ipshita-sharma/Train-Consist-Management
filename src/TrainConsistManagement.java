import java.util.HashMap;
import java.util.Map;

// Inventory Class (Centralized State Management)
class RoomInventory {

    private Map<String, Integer> inventory;

    // Constructor → Initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        // Register room types with availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Get availability of a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability (controlled modification)
    public void updateAvailability(String roomType, int count) {
        if (inventory.containsKey(roomType)) {
            inventory.put(roomType, count);
        } else {
            System.out.println("Room type not found: " + roomType);
        }
    }

    // Display full inventory
    public void displayInventory() {
        System.out.println("\n--- Current Room Inventory ---\n");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " → Available: " + entry.getValue());
        }
    }
}

// Main Application Class (Version 3.1)
public class TrainConsistManagement {

    public static void main(String[] args) {

        System.out.println("=== Book My Stay App ===");

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Example: Retrieve availability
        System.out.println("\nChecking availability for Double Room...");
        int available = inventory.getAvailability("Double Room");
        System.out.println("Available Double Rooms: " + available);

        // Example: Update availability
        System.out.println("\nUpdating availability for Double Room...");
        inventory.updateAvailability("Double Room", 2);

        // Display updated inventory
        inventory.displayInventory();
    }
}