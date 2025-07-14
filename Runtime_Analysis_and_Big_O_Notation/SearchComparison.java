import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search: O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Binary Search: O(log N) - assumes array is sorted
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void performSearch(int size, int target) {
        Random rand = new Random();
        int[] data = new int[size];

        // Fill array with random numbers
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(size * 10); // random numbers
        }

        // Linear Search Timing
        long startTime = System.nanoTime();
        linearSearch(data, target);
        long endTime = System.nanoTime();
        double linearTimeMs = (endTime - startTime) / 1e6;

        // Binary Search Timing
        Arrays.sort(data); // Sorting for binary search
        startTime = System.nanoTime();
        binarySearch(data, target);
        endTime = System.nanoTime();
        double binaryTimeMs = (endTime - startTime) / 1e6;

        // Output results
        System.out.println("Dataset Size: " + size);
        System.out.printf("Linear Search Time: %.4f ms%n", linearTimeMs);
        System.out.printf("Binary Search Time: %.4f ms%n", binaryTimeMs);
        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        int target = 5000;

        for (int size : datasetSizes) {
            performSearch(size, target);
        }

        System.out.println("Binary Search performs better on large sorted datasets.");
    }
}
