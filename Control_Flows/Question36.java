import java.util.Scanner;

public class Question36{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks for Physics: ");
        int physics = sc.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = sc.nextInt();
        System.out.print("Enter marks for Math: ");
        int math = sc.nextInt();
        float average = (physics + chemistry + math) / 3.0f;
	    System.out.println("Average marks: " + average);
        if (average >= 80) {
            System.out.println("Grade: A");
            System.out.println("Remarks: (Level 4, above agency-normalized standards)");
        } 
        else if (average >= 70) {
            System.out.println("Grade: B");
            System.out.println("Remarks: (Level 3, at agency-normalized standards)");
        } 
        else if (average >= 60) {
            System.out.println("Grade: C");
            System.out.println("Remarks: (Level 2, below, but approaching agency-normalized standards)");
        } 
        else if (average >= 50) {
            System.out.println("Grade: D");
            System.out.println("Remarks: (Level 1, well below agency-normalized standards)");
        } 
        else if (average >= 40) {
            System.out.println("Grade: E");
            System.out.println("Remarks: (Level 1-, too below agency-normalized standard");
        }
	else if (average <= 39) {
            System.out.println("Grade: E");
            System.out.println("Remarks: (Level 1-, too below agency-normalized standard");
        }

   }
}