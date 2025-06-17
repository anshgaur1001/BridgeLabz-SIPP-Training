import java.util.Scanner;

public class Question20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();

        double[][] personData = new double[number][3]; 
        String[] weightStatus = new String[number];

       
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");

           
            System.out.print("Enter weight (in kg): ");
            double weight = scanner.nextDouble();
            while (weight <= 0) {
                System.out.print("Weight must be positive. Enter again: ");
                weight = scanner.nextDouble();
            }

      
            System.out.print("Enter height (in cm): ");
            double heightCm = scanner.nextDouble();
            while (heightCm <= 0) {
                System.out.print("Height must be positive. Enter again: ");
                heightCm = scanner.nextDouble();
            }

        
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

        
            personData[i][0] = weight;
            personData[i][1] = heightCm;
            personData[i][2] = bmi;

          
            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

   
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d:\n", (i + 1));
            System.out.printf("Weight: %.2f kg\n", personData[i][0]);
            System.out.printf("Height: %.2f cm\n", personData[i][1]);
            System.out.printf("BMI: %.2f\n", personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println();
        }
    }
}
