import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Employee {
    private String name;
    private String department;
    
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    // toString for easy printing
    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees : ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee name : ");
            String name = sc.nextLine();
            System.out.print("Enter department : ");
            String department = sc.nextLine();
            employees.add(new Employee(name, department));
        }

        // Grouping logic
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee emp : employees) {
            grouped.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>()).add(emp);
        }

        // Display grouped employees
        System.out.println("\nGrouped Employees by Department : ");
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
