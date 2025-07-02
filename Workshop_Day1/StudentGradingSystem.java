import java.util.*;

class Student {
    private String name;
    private String id;
    private Integer[] grades; // allow nulls to represent missing grades

    public Student(String name, String id, int subjectCount) {
        this.name = name;
        this.id = id;
        this.grades = new Integer[subjectCount];
    }

    public void setGrade(int subjectIndex, Integer grade) throws IllegalArgumentException {
        if (grade == null) {
            grades[subjectIndex] = null;
        } else if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        } else {
            grades[subjectIndex] = grade;
        }
    }

    public Integer[] getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getTotal() {
        int sum = 0;
        for (Integer grade : grades) {
            if (grade != null)
                sum += grade;
        }
        return sum;
    }

    public double getAverage() {
        int sum = 0;
        int count = 0;
        for (Integer grade : grades) {
            if (grade != null) {
                sum += grade;
                count++;
            }
        }
        return count > 0 ? (double) sum / count : 0.0;
    }
}

public class StudentGradingSystem {
    public static void main(String[] args) {
        int subjectCount = 3; // for example
        List<Student> students = new ArrayList<>();

        // Sample data
        Student s1 = new Student("Alice", "S101", subjectCount);
        Student s2 = new Student("Bob", "S102", subjectCount);
        Student s3 = new Student("Charlie", "S103", subjectCount);

        try {
            s1.setGrade(0, 85);
            s1.setGrade(1, 90);
            s1.setGrade(2, 78);

            s2.setGrade(0, 92);
            s2.setGrade(1, null); // missing grade
            s2.setGrade(2, 88);

            s3.setGrade(0, 76);
            s3.setGrade(1, 81);
            s3.setGrade(2, 95);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        students.add(s1);
        students.add(s2);
        students.add(s3);

        // Calculate and display
        System.out.println("\n=== Student Report ===");
        for (Student s : students) {
            System.out.println("Name: " + s.getName() + " (ID: " + s.getId() + ")");
            System.out.println("Total: " + s.getTotal());
            System.out.printf("Average: %.2f%n", s.getAverage());
        }

        // Find highest grade per subject
        System.out.println("\n=== Highest Grade Per Subject ===");
        for (int subjectIndex = 0; subjectIndex < subjectCount; subjectIndex++) {
            int highest = -1;
            for (Student s : students) {
                Integer[] grades = s.getGrades();
                if (grades[subjectIndex] != null && grades[subjectIndex] > highest) {
                    highest = grades[subjectIndex];
                }
            }
            System.out.println("Subject " + (subjectIndex + 1) + ": " + (highest >= 0 ? highest : "No grades"));
        }

        // Compute overall class average
        int classTotal = 0;
        int gradeCount = 0;
        for (Student s : students) {
            for (Integer grade : s.getGrades()) {
                if (grade != null) {
                    classTotal += grade;
                    gradeCount++;
                }
            }
        }
        double classAverage = gradeCount > 0 ? (double) classTotal / gradeCount : 0.0;
        System.out.printf("\nOverall class average: %.2f%n", classAverage);
    }
}
