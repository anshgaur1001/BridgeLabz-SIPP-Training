import java.util.Scanner;

public class Question16 {
    public static int recursiveSum(int n) {
        if (n == 1)
            return 1;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Enter a valid natural number.");
            return;
        }
        int recSum = recursiveSum(n);
        int formSum = formulaSum(n);
        System.out.println("Recursive Sum: " + recSum);
        System.out.println("Formula Sum: " + formSum);
        System.out.println("Both are " + (recSum == formSum ? "equal" : "not equal"));
    }
}