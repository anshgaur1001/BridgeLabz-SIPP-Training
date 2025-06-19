public class Question27{
    public static int[][] generateData() {
        int[][] data = new int[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = (int)(Math.random() * 90000) + 10000;
            data[i][1] = (int)(Math.random() * 11);
        }
        return data;
    }
    public static double[][] calculateBonus(int[][] data) {
        double[][] newData = new double[10][2];
        for (int i = 0; i < 10; i++) {
            double bonus = data[i][1] > 5 ? 0.05 : 0.02;
            newData[i][1] = data[i][0] * bonus;
            newData[i][0] = data[i][0] + newData[i][1];
        }
        return newData;
    }
    public static void displaySummary(int[][] oldData, double[][] newData) {
        double totalOld = 0, totalNew = 0, totalBonus = 0;
        System.out.printf("%-10s %-15s %-10s %-10s\n", "Salary", "Years", "New Salary", "Bonus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10d %-15d %-10.2f %-10.2f\n", oldData[i][0], oldData[i][1], newData[i][0], newData[i][1]);
            totalOld += oldData[i][0];
            totalNew += newData[i][0];
            totalBonus += newData[i][1];
        }
        System.out.println("Total Old Salary: " + totalOld);
        System.out.println("Total New Salary: " + totalNew);
        System.out.println("Total Bonus: " + totalBonus);
    }
    public static void main(String[] args) {
        int[][] employees = generateData();
        double[][] bonusData = calculateBonus(employees);
        displaySummary(employees, bonusData);
    }
}
