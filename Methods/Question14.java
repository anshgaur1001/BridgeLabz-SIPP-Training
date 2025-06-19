import java.util.Scanner;

public class Question14 {
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int val : arr)
            sum += val;
        return sum;
    }

    public static int product(int[] arr) {
        int product = 1;
        for (int val : arr)
            product *= val;
        return product;
    }

    public static double sumOfSquares(int[] arr) {
        double sum = 0;
        for (int val : arr)
            sum += Math.pow(val, 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);
        System.out.println("Factors: ");
        for (int val : factors)
            System.out.print(val + " ");
        System.out.println("\nSum: " + sum(factors));
        System.out.println("Product: " + product(factors));
        System.out.println("Sum of Squares: " + sumOfSquares(factors));
    }
}
