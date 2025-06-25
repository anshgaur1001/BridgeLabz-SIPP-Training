package Static_and_Final_Keyword;
public class Employee {
	//Static variable
	static String CompanyName="JPMC";
	static int totalEmployee=0;
	
	//instatnce variable 
	String Name,Designation;
	
	//final Keyword not not change the Employee ID and make it fixed
	final int ID;
	
	
	//use of this keyword ton resolve ambiguity
	public Employee(String Name,int ID,String Designation) {
		this.Name=Name;
		this.ID=ID;
		this.Designation=Designation;
		totalEmployee++;
	}
	
	//Method to display Employee details
		public void EmployeeDetails(){
			if (this instanceof Employee) {
				System.out.println("ComapnyName : "+CompanyName);
				System.out.println("Name : "+Name);
				System.out.println("Employee ID : "+ID);
				System.out.println("Designation : "+Designation);
			}
			else {
				System.out.println("Invalid Employee instance.");
			}
		}
	
	//static method
	public static void displayTotalEmployee() {
		System.out.println("Total Number of Employee : "+totalEmployee);
	}
	
	//main methor for creation and testing of the Employee
	public static void main(String[] args) {
		Employee e1=new Employee("Ansh",123,"Manager");
		Employee e2=new Employee("Apran",456,"General Manager");
		
		e1.EmployeeDetails();
		e2.EmployeeDetails();
		
		Employee.displayTotalEmployee();
	}
	
}
