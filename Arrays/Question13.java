import java.util.Scanner;

public class Question13{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
	for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for " + names[i] + ":");
            
            System.out.print("Enter age: ");
            ages[i] = scanner.nextInt();
            
            System.out.print("Enter height (in cm): ");
            heights[i] = scanner.nextDouble();
        }
        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }

            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        System.out.println("\n--- Results ---");
        System.out.println("Youngest friend is: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend is: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");
    }
}
