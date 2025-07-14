public class FibonacciComparison {

    // Recursive method: O(2^N)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative method: O(N)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void testFibonacci(int n) {
        System.out.println("Fibonacci Number: " + n);

        // Measure Recursive
        if (n <= 40) { // Avoid infeasibility
            long start = System.nanoTime();
            int result = fibonacciRecursive(n);
            long end = System.nanoTime();
            System.out.printf("Recursive Result: %d | Time: %.4f ms%n", result, (end - start) / 1e6);
        } else {
            System.out.println("Recursive Result: Skipped (Unfeasible)");
        }

        // Measure Iterative
        long start = System.nanoTime();
        int result = fibonacciIterative(n);
        long end = System.nanoTime();
        System.out.printf("Iterative Result: %d | Time: %.4f ms%n", result, (end - start) / 1e6);

        System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {
        int[] fibTests = {10, 30, 50}; // Test values

        for (int n : fibTests) {
            testFibonacci(n);
        }

        System.out.println("Conclusion:");
        System.out.println("- Recursive approach is infeasible for large N due to O(2^N).");
        System.out.println("- Iterative approach is fast and memory-efficient (O(N)).");
    }
}
