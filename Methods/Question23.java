import java.util.Scanner;
public class Question23{
    public static boolean isPositive(int number) {
        return number >= 0;
    }
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
    public static int compare(int a, int b) {
        return Integer.compare(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            nums[i] = sc.nextInt();
            if (isPositive(nums[i])) {
                System.out.println(isEven(nums[i]) ? "Positive Even" : "Positive Odd");
            } else {
                System.out.println("Negative");
            }
        }
        int result = compare(nums[0], nums[4]);
        System.out.print("First and last number are: ");
        System.out.println(result == 0 ? "Equal" : (result > 0 ? "First is Greater" : "First is Smaller"));
    }
}
