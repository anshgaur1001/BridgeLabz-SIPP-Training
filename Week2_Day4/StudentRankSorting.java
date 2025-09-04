import java.util.*;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " - " + marks;
    }
}

public class StudentRankSorting {

    // Merge Sort implementation
    public static void mergeSort(Student[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(Student[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Custom comparison logic
        while (i < n1 && j < n2) {
            if (compare(L[i], R[j]) <= 0) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Custom comparator:
    // 1. Higher marks first
    // 2. If equal, name alphabetically
    private static int compare(Student a, Student b) {
        if (a.marks != b.marks) {
            return (b.marks - a.marks); // Descending by marks
        } else {
            return a.name.compareTo(b.name); // Ascending by name
        }
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student("Rahul", 88),
            new Student("Aditi", 95),
            new Student("Zoya", 88),
            new Student("Karan", 76),
            new Student("Meera", 95),
            new Student("Aarav", 92)
        };

        System.out.println("Unsorted List:");
        for (Student s : students) {
            System.out.println(s);
        }

        mergeSort(students, 0, students.length - 1);

        System.out.println("\nSorted Rank List:");
        int rank = 1;
        for (Student s : students) {
            System.out.println(rank++ + ". " + s);
        }
    }
}
