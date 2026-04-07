import java.util.Scanner;

public class TrainConsistManagement {

    // Method to perform Linear Search
    public static boolean linearSearch(String[] bogieIds, String key) {

        // Traverse array sequentially
        for (int i = 0; i < bogieIds.length; i++) {

            // Compare using equals()
            if (bogieIds[i].equals(key)) {
                return true; // Match found → early termination
            }
        }

        return false; // No match found after full traversal
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of bogies: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] bogieIds = new String[n];

        // Input bogie IDs
        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIds[i] = scanner.nextLine();
        }

        // Input search key
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Perform search
        boolean found = linearSearch(bogieIds, searchKey);

        // Display result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " found in the consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT found in the consist.");
        }

        scanner.close();
    }
}