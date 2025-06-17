import java.util.Scanner;

public class Question18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

    
        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

      
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

        
            System.out.print("Physics: ");
            physics[i] = scanner.nextInt();
            if (physics[i] < 0) {
                System.out.println("Invalid input. Please enter positive marks.");
                i--;
                continue;
            }

          
            System.out.print("Chemistry: ");
            chemistry[i] = scanner.nextInt();
            if (chemistry[i] < 0) {
                System.out.println("Invalid input. Please enter positive marks.");
                i--;
                continue;
            }

         
            System.out.print("Maths: ");
            maths[i] = scanner.nextInt();
            if (maths[i] < 0) {
                System.out.println("Invalid input. Please enter positive marks.");
                i--;
                continue;
            }

         
            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) {
                grade[i] = 'A';
            } else if (percentage[i] >= 80) {
                grade[i] = 'B';
            } else if (percentage[i] >= 70) {
                grade[i] = 'C';
            } else if (percentage[i] >= 60) {
                grade[i] = 'D';
            } else {
                grade[i] = 'F';
            }
        }

     
        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": ");
            System.out.println("Physics: " + physics[i]);
            System.out.println("Chemistry: " + chemistry[i]);
            System.out.println("Maths: " + maths[i]);
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade: " + grade[i]);
            System.out.println();
        }
    }
}
