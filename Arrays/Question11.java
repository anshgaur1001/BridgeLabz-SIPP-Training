import java.util.*;

public class Question11{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	System.out.print("Enter a positive integer: ");
        long number = scanner.nextLong();
        if (number < 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
	String numStr = Long.toString(number);
        int length = numStr.length();
	int[] digits = new int[length];
        for (int i = 0; i < length; i++) {
            digits[i] = numStr.charAt(i) - '0'; // Convert char to int
        }
	int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }
	System.out.println("\nDigit Frequency in " + number + ":");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " times");
            }
        }
    }
}
