import java.util.Scanner;

public class Question15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = scanner.nextLong();


        String numStr = Long.toString(Math.abs(number)); 
        int[] frequency = new int[10];

      
        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0'; 
            frequency[digit]++;
        }


        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " time(s)");
            }
        }
    }
}
