import java.util.Scanner;
import java.util.Arrays;

public class TrainConsistManagement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of bogie types: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] bogieNames = new String[n];

        // Input bogie names
        System.out.println("Enter bogie type names:");
        for (int i = 0; i < n; i++) {
            bogieNames[i] = scanner.nextLine();
        }

        System.out.println("Before Sorting: " + Arrays.toString(bogieNames));

        // Sorting using built-in method
        Arrays.sort(bogieNames);

        System.out.println("After Sorting (Alphabetical): " + Arrays.toString(bogieNames));

        scanner.close();
    }
}