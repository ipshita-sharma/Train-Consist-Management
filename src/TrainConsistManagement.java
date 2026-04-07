import java.util.Scanner;
import java.util.Arrays;

public class TrainConsistManagement {

    // Method to perform Binary Search
    public static boolean binarySearch(String[] bogieIds, String key) {

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            // Compare using compareTo()
            int result = bogieIds[mid].compareTo(key);

            if (result == 0) {
                return true; // Found
            } else if (result < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return false; // Not found
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

        // Handle empty array case
        if (bogieIds.length == 0) {
            System.out.println("No bogies available. Search cannot be performed.");
            return;
        }

        // Sort before Binary Search (important precondition)
        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogie IDs: " + Arrays.toString(bogieIds));

        // Input search key
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Perform Binary Search
        boolean found = binarySearch(bogieIds, searchKey);

        // Display result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " found in the consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT found in the consist.");
        }

        scanner.close();
    }
}