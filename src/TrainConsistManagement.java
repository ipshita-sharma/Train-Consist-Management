import java.util.Scanner;
import java.util.Arrays;

public class TrainConsistManagement {

    // Binary Search with validation (UC20)
    public static boolean searchBogie(String[] bogieIds, String key) {

        // ✅ Fail-Fast Validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in the train. Cannot perform search.");
        }

        // Ensure sorted before binary search
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int result = bogieIds[mid].compareTo(key);

            if (result == 0) {
                return true; // Found
            } else if (result < 0) {
                low = mid + 1; // Search right
            } else {
                high = mid - 1; // Search left
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

        // Input bogie IDs (only if size > 0)
        if (n > 0) {
            System.out.println("Enter bogie IDs:");
            for (int i = 0; i < n; i++) {
                bogieIds[i] = scanner.nextLine();
            }
        }

        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        try {
            // Perform search
            boolean found = searchBogie(bogieIds, searchKey);

            if (found) {
                System.out.println("Bogie ID " + searchKey + " found in the consist.");
            } else {
                System.out.println("Bogie ID " + searchKey + " NOT found in the consist.");
            }

        } catch (IllegalStateException e) {
            // Handle exception and show meaningful message
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}