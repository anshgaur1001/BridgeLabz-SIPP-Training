public class StringConcatPerformance {

    public static void testConcat(int n) {
        System.out.println("Operation Count: " + n);

        // Test String (Immutable)
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "a";
        }
        long endTime = System.nanoTime();
        System.out.printf("String: %.4f ms%n", (endTime - startTime) / 1e6);

        // Test StringBuilder (Mutable, non-thread-safe)
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        endTime = System.nanoTime();
        System.out.printf("StringBuilder: %.4f ms%n", (endTime - startTime) / 1e6);

        // Test StringBuffer (Mutable, thread-safe)
        startTime = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbuf.append("a");
        }
        endTime = System.nanoTime();
        System.out.printf("StringBuffer: %.4f ms%n", (endTime - startTime) / 1e6);

        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        int[] operations = {1000, 10_000, 1_000_000}; // Ops to test
        for (int n : operations) {
            testConcat(n);
        }

        System.out.println("Conclusion:");
        System.out.println("- StringBuilder & StringBuffer are more efficient than String.");
        System.out.println("- Use StringBuilder for single-threaded, StringBuffer for multi-threaded.");
    }
}
