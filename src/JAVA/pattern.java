 import java.util.Scanner;

public class pattern {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter the number of rows
        System.out.print("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        
        // Generate the pattern
        for (int i = 0; i <= numRows; i++) {
            for (int j = numRows; j >= numRows-1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        // Close the scanner to release resources
        scanner.close();
    }
}