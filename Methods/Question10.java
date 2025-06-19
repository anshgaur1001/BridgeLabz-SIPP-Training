import java.util.Scanner;

public class Question10{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        if (numberOfStudents < 2) {
            System.out.println("At least 2 students are required for a handshake.");
            return;
        }
        int maxHandshakes = calculateHandshakes(numberOfStudents);
        System.out.println("Maximum number of handshakes possible: " + maxHandshakes);
    }
    public static int calculateHandshakes(int n) {
        return (n * (n - 1)) / 2;
    }
}
