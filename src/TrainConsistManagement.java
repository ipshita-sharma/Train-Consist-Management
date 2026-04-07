import java.util.Scanner;

public class TrainConsistManagement {

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop for comparison
            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // Swap if out of order
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    // Method to display array
    public static void displayArray(int[] capacities) {
        for (int capacity : capacities) {
            System.out.print(capacity + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of passenger bogies: ");
        int n = scanner.nextInt();

        int[] capacities = new int[n];

        // Input capacities
        System.out.println("Enter capacities of passenger bogies:");
        for (int i = 0; i < n; i++) {
            capacities[i] = scanner.nextInt();
        }

        System.out.print("Before Sorting: ");
        displayArray(capacities);

        // Perform Bubble Sort
        bubbleSort(capacities);

        System.out.print("After Sorting (Ascending): ");
        displayArray(capacities);

        scanner.close();
    }
}