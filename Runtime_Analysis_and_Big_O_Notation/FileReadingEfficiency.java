import java.io.*;

public class FileReadingEfficiency {

    // Read using FileReader (Character stream)
    public static void readWithFileReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        FileReader fr = new FileReader(filePath);
        while (fr.read() != -1); // Read character by character
        fr.close();
        long endTime = System.nanoTime();
        System.out.printf("FileReader Time: %.2f ms%n", (endTime - startTime) / 1e6);
    }

    // Read using InputStreamReader (Byte stream)
    public static void readWithInputStreamReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        while (isr.read() != -1); // Read character by character
        isr.close();
        long endTime = System.nanoTime();
        System.out.printf("InputStreamReader Time: %.2f ms%n", (endTime - startTime) / 1e6);
    }

    public static void main(String[] args) {
        // Provide path to test file (change this to your file location)
        String filePath = "large_file.txt"; // e.g., 1MB / 100MB / 500MB file

        try {
            System.out.println("Reading: " + filePath);
            readWithFileReader(filePath);
            readWithInputStreamReader(filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Conclusion:");
        System.out.println("- InputStreamReader is faster for large/binary files.");
        System.out.println("- FileReader is suitable for small text-based files.");
    }
}
