import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 1, 9, 4, 6, 10, 7}; // the array to be sorted
        
        // Perform bubble sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        
        // Print the sorted array
        System.out.println(Arrays.toString(arr));
    }
}

