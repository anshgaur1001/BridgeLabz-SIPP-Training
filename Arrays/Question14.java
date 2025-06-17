import java.util.Scanner;

public class {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        while (number != 0) {
            int digit = number % 10;
            digits[index++] = digit;
            if (index == maxDigit) {
                break;
            }
            number /= 10;
        }
        int largest = -1;
        int secondLargest = -1;
        for (int i = 0; i < index; i++) {
            int current = digits[i];
            if (current > largest) {
                secondLargest = largest;
                largest = current;
            } else if (current > secondLargest && current != largest) {
                secondLargest = current;
            }
        }
        System.out.println("\n--- Results ---");
        System.out.println("Digits extracted: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }

        System.out.println("\nLargest digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("Second largest digit not found (all digits same or only one digit).");
        }
    }
}
