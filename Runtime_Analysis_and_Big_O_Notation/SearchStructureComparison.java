import java.util.*;

public class SearchStructureComparison {

    public static void testSearchPerformance(int size, int target) {
        System.out.println("Dataset Size: " + size);

        // Prepare random data
        Random rand = new Random();
        List<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            int value = rand.nextInt(size * 10);
            arrayList.add(value);
            hashSet.add(value);
            treeSet.add(value);
        }

        // Array Search (O(N))
        long start = System.nanoTime();
        boolean foundInArray = arrayList.contains(target);
        long end = System.nanoTime();
        System.out.printf("Array Search Time: %.4f ms%n", (end - start) / 1e6);

        // HashSet Search (O(1))
        start = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        end = System.nanoTime();
        System.out.printf("HashSet Search Time: %.4f ms%n", (end - start) / 1e6);

        // TreeSet Search (O(log N))
        start = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        end = System.nanoTime();
        System.out.printf("TreeSet Search Time: %.4f ms%n", (end - start) / 1e6);

        System.out.println("--------------------------------------------");
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100_000, 1_000_000};
        int target = 123456; // Arbitrary number unlikely to appear

        for (int size : datasetSizes) {
            testSearchPerformance(size, target);
        }

        System.out.println("Conclusion:");
        System.out.println("- HashSet is fastest for lookup (O(1) on average).");
        System.out.println("- TreeSet maintains order but is slightly slower (O(log N)).");
        System.out.println("- Array is slowest due to linear search (O(N)).");
    }
}
