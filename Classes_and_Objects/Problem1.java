package Classes_and_Objects;
import java.util.*;
class Employee{
	String name;
	int id,salary;
	public Employee(String name, int id, int salary) {
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	public void displayDetails() {
		System.out.println("Employee name : "+name);
		System.out.println("Employes ID : "+id);
		System.out.println("Employee salary : "+salary);
	}
}
public class Problem1 {
	
	public static void main(String[] args) {
		Employee Employee1=new Employee("Ansh",123,250000);
		Employee Employee2=new Employee("Ayan",456,300000);
		Employee Employee3=new Employee("Ayush",789,150000);
		
		System.out.println("Details of Employee 1");
		Employee1.displayDetails();
		
		System.out.println("Details of Employee 2");
		Employee2.displayDetails();
		
		System.out.println("Details of Employee 3");
		Employee3.displayDetails();
	}
}
