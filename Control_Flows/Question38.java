import java.util.Scanner;

public class Question38{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double first = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double second = scanner.nextDouble();
        System.out.print("Enter an operator (+, -, *, /): ");
        String op = scanner.next();
        System.out.print("Enter the number of times to perform operation (loop): ");
        int number = scanner.nextInt();
	for (int i = 1; i < number; i++) {
            switch (op) {
                case "+":
                    System.out.println("Result: " + (first + second));
                    break;
                case "-":
                    System.out.println("Result: " + (first - second));
                    break;
                case "*":
                    System.out.println("Result: " + (first * second));
                    break;
                case "/":
                    if (second != 0) {
                        System.out.println("Result: " + (first / second));
                    } else {
                        System.out.println("Error: Division by zero");
                    }
                    break;
                default:
                    System.out.println("Invalid Operator");
                    break;
            }
        }
    }
}
