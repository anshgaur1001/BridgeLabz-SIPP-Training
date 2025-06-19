import java.util.Scanner;
public class Question19 {
    public static void findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta > 0) {
            double r1 = (-b + Math.sqrt(delta)) / (2 * a);
            double r2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Two roots: " + r1 + " and " + r2);
        } else if (delta == 0) {
            double r = -b / (2 * a);
            System.out.println("One root: " + r);
        } else {
            System.out.println("No real roots.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        findRoots(a, b, c);
    }
}
