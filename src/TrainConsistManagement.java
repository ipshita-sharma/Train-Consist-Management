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
}


// -------------------- MAIN APPLICATION --------------------

public class TrainConsistManagement {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Step 1: Create large dataset of bogies
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 60));
            bogies.add(new Bogie("First Class", 24));
        }

        // ---------------- LOOP-BASED FILTERING ----------------

        long startLoop = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ---------------- STREAM-BASED FILTERING ----------------

        long startStream = System.nanoTime();

        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ---------------- RESULTS ----------------

        System.out.println("\n--- Performance Comparison ---\n");

        System.out.println("Loop Filtering Time (ns): " + loopTime);
        System.out.println("Stream Filtering Time (ns): " + streamTime);

        // Verify both results are same
        System.out.println("\n--- Result Validation ---\n");
        System.out.println("Loop Result Size: " + loopFiltered.size());
        System.out.println("Stream Result Size: " + streamFiltered.size());

        if (loopFiltered.size() == streamFiltered.size()) {
            System.out.println("Both approaches produce SAME result.");
        } else {
            System.out.println("Mismatch in results!");
        }
    }
}