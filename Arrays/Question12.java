import java.util.*;

public class Question12{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int EMPLOYEE_COUNT = 10;
        double[] salaries = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonuses = new double[EMPLOYEE_COUNT];
        double[] newSalaries = new double[EMPLOYEE_COUNT];
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
	for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
	System.out.print("Enter salary: ");
            double salary = scanner.nextDouble();
            if (salary <= 0) {
                System.out.println("Invalid salary. Please enter again.");
                i--;
                continue;
            }
	System.out.print("Enter years of service: ");
            double years = scanner.nextDouble();
            if (years < 0) {
                System.out.println("Invalid years of service. Please enter again.");
                i--;
                continue;
            }
            salaries[i] = salary;
            yearsOfService[i] = years;
        }
	for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            double bonusPercent = (yearsOfService[i] > 5) ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPercent;
            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }
	System.out.println("\n--- Bonus and Salary Details ---");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Employee : Old Salary = ₹%.2f, Bonus = ₹%.2f, New Salary = ₹%.2f%n",
                    (i + 1), salaries[i], bonuses[i], newSalaries[i]);
        }
	System.out.println("\n--- Totals ---");
        System.out.printf("Total Bonus Payout: ₹%.2f%n", totalBonus);
        System.out.printf("Total Old Salary: ₹%.2f%n", totalOldSalary);
        System.out.printf("Total New Salary: ₹%.2f%n", totalNewSalary);
    }
}
	