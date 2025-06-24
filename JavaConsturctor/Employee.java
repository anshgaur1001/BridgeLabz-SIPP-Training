package Java_Consturctor;

public class Employee {
	public int employeeID;            // Public
    protected String department;      // Protected
    private double salary;            // Private

 // Constructor
    public Employee(int employeeID, String department, double salary) {
    	this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

 // Public method to set the salary
    public void setSalary(double salary) {
    	this.salary = salary;
    }

 // Public method to get the salary
    public double getSalary() {
    	return salary;
    }
    public static void main(String[] args) {
        // Creating a Manager object
        Manager manager = new Manager(101, "Engineering", 85000, "Backend Services");

        // Displaying manager details
        manager.displayManagerDetails();

        // Modifying salary using the public method
        manager.setSalary(90000);
        System.out.println("\nAfter Salary Update:");
        manager.displayManagerDetails();
    }
}
//subclass
class Manager extends Employee {
	private String team;

 // Constructor
	public Manager(int employeeID, String department, double salary, String team) {
		super(employeeID, department, salary);
        this.team = team;
    }

 // Method to display Manager details
	public void displayManagerDetails() {
		System.out.println("Employee ID: " + employeeID);       // Public access
        System.out.println("Department: " + department);       // Protected access
        System.out.println("Team: " + team);
        System.out.println("Salary: " + getSalary());           // Private access via public getter
    }
}

