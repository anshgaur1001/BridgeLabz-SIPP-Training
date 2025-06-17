import java.util.*;

public class Question7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	System.out.print("Enter a number to print its multiplication table: ");
        int number = scanner.nextInt();
        int[] table = new int[10];
	for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }
	System.out.println("\nMultiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + table[i - 1]);
        }
    }
}
