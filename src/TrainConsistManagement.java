import java.util.*;

// -------------------- GOODS BOGIE CLASS --------------------

class GoodsBogie {
    private String type;   // e.g., Cylindrical, Rectangular
    private String cargo;  // e.g., Petroleum, Coal

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public void display() {
        System.out.println("Type: " + type + " | Cargo: " + cargo);
    }
}


// -------------------- MAIN APPLICATION --------------------

public class TrainConsistManagement {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Step 1: Create list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // Step 2: Display bogies
        System.out.println("\n--- Goods Bogies ---\n");
        for (GoodsBogie g : goodsBogies) {
            g.display();
        }

        // Step 3: Safety validation using Stream + allMatch()
        boolean isSafe = goodsBogies.stream()
                .allMatch(b ->
                        // Rule: Cylindrical → only Petroleum allowed
                        !b.getType().equalsIgnoreCase("Cylindrical")
                                || b.getCargo().equalsIgnoreCase("Petroleum")
                );

        // Step 4: Display result
        System.out.println("\n--- Safety Compliance Check ---\n");

        if (isSafe) {
            System.out.println("Train is SAFE for operation.");
        } else {
            System.out.println("Train is UNSAFE! Invalid cargo detected.");
        }
    }
}