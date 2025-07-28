import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Comparator;

// Class to represent a Patient
class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity : " + severity + ")";
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return Integer.compare(p2.severity, p1.severity); 
            }
        });

        Scanner sc = new Scanner(System.in);

        // Input number of patients
        System.out.print("Enter number of patients : ");
        int n = sc.nextInt();
        sc.nextLine();

        // Input patient details
        for (int i = 0; i < n; i++) {
            System.out.print("Enter patient name : ");
            String name = sc.nextLine();
            System.out.print("Enter severity (1-10) : ");
            int severity = sc.nextInt();
            sc.nextLine();

            triageQueue.add(new Patient(name, severity));
        }

        System.out.println("\nPatients will be treated in the following order : ");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}
