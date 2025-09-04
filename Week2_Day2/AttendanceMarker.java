import java.util.*;

public class AttendanceMarker {
    private int[][] attendance; // 2D array: rows = students, cols = days
    private int totalStudents;
    private int totalDays;

    public AttendanceMarker(int students, int days) {
        this.totalStudents = students;
        this.totalDays = days;
        attendance = new int[students][days]; // initialized with 0 (all absent)
    }

    // 1. Mark attendance for a given student and day
    public void markAttendance(int studentId, int day, int status) {
        if (studentId < 1 || studentId > totalStudents || day < 1 || day > totalDays) {
            System.out.println("Invalid student ID or day!");
            return;
        }
        attendance[studentId - 1][day - 1] = status; // status: 1 = Present, 0 = Absent
    }

    // 2. Daily summary: Count how many students were present on a given day
    public int dailySummary(int day) {
        if (day < 1 || day > totalDays) {
            System.out.println("Invalid day!");
            return -1;
        }
        int count = 0;
        for (int i = 0; i < totalStudents; i++) {
            count += attendance[i][day - 1];
        }
        return count;
    }

    // 3. Monthly summary: Count total days present for each student
    public int monthlySummary(int studentId) {
        if (studentId < 1 || studentId > totalStudents) {
            System.out.println("Invalid student ID!");
            return -1;
        }
        int totalPresent = 0;
        for (int d = 0; d < totalDays; d++) {
            totalPresent += attendance[studentId - 1][d];
        }
        return totalPresent;
    }

    // 4. Defaulter list: Students with attendance < 75%
    public List<Integer> defaulterList() {
        List<Integer> defaulters = new ArrayList<>();
        int threshold = (int) Math.ceil(totalDays * 0.75); // min required attendance
        for (int i = 0; i < totalStudents; i++) {
            int presentDays = monthlySummary(i + 1);
            if (presentDays < threshold) {
                defaulters.add(i + 1); // roll numbers = index+1
            }
        }
        return defaulters;
    }

    // Show full attendance grid
    public void displayGrid() {
        System.out.println("\nAttendance Grid (1=Present, 0=Absent):");
        for (int i = 0; i < totalStudents; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            for (int j = 0; j < totalDays; j++) {
                System.out.print(attendance[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Demo Run
    public static void main(String[] args) {
        AttendanceMarker marker = new AttendanceMarker(5, 5); // 5 students, 5 days (demo)

        // Mark some attendance
        marker.markAttendance(1, 1, 1); // Student 1 present Day 1
        marker.markAttendance(2, 1, 1); // Student 2 present Day 1
        marker.markAttendance(3, 1, 0); // Student 3 absent Day 1
        marker.markAttendance(4, 1, 1);
        marker.markAttendance(5, 1, 1);

        marker.markAttendance(1, 2, 0);
        marker.markAttendance(2, 2, 1);
        marker.markAttendance(3, 2, 0);
        marker.markAttendance(4, 2, 1);
        marker.markAttendance(5, 2, 0);

        marker.displayGrid();

        // Example queries
        System.out.println("\nHow many students came on Day 2? " + marker.dailySummary(2));
        System.out.println("Did Student 5 attend more than 2 days? " +
                (marker.monthlySummary(5) > 2 ? "Yes" : "No"));

        System.out.println("\nStudents with <75% attendance:");
        for (int roll : marker.defaulterList()) {
            System.out.println("Student " + roll);
        }
    }
}
