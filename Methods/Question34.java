public class Question34{
    public static String getGrade(double percentage) {
        if (percentage >= 80) return "A (Level 4)";
        if (percentage >= 70) return "B (Level 3)";
        if (percentage >= 60) return "C (Level 2)";
        if (percentage >= 50) return "D (Level 1)";
        return "F (Remedial)";
    }
    public static void main(String[] args) {
        int[][] marks = {{85, 90, 80},{65, 60, 70},{45, 50, 48}};
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "Phys", "Chem", "Math", "Total", "Avg", "Grade");
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            String grade = getGrade(avg);
            System.out.printf("%-10d %-10d %-10d %-10d %-10.2f %-10s\n",
                    marks[i][0], marks[i][1], marks[i][2], total, avg, grade);
        }
    }
}
