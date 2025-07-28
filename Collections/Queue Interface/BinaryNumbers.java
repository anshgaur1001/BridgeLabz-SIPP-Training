import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryNumbers {

    // Method to generate binary numbers
    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < N; i++) {
            String front = queue.remove();
            System.out.print(front + " ");

            queue.add(front + "0");
            queue.add(front + "1");
        }
    }

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        // Input: number of binary numbers to generate
        System.out.print("Enter N : ");
        int N = sc.nextInt();

        System.out.println("First " + N + " binary numbers : ");
        generateBinaryNumbers(N);
    }
}
