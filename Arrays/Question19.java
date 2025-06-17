import java.util.Scanner;

public class Question19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

    
        number = Math.abs(number);

    
        int[] digits = new int[20];
        int count = 0;

        long temp = number;
        while (temp != 0) {
            digits[count] = (int)(temp % 10);
            temp = temp / 10;
            count++;
        }

     
        int[] reversedDigits = new int[count];
        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[i];
        }

        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reversedDigits[i]);
        }
    }
}
