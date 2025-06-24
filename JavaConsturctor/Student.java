package Java_Consturctor;

public class Student {
	//instance variable with public, protected and private access modifiers
	public int rollNumber;
	protected String name;
	private double CGPA;
	
	//constructor
	public Student(int rollNumber,String name, double CGPA) {
		this.rollNumber=rollNumber;
		this.name=name;
		this.CGPA=CGPA;
	}
	//method to access CGPA
	public double getCGPA() {
		return CGPA;
	}
	
	//method to modify CGPA
	public void setCGPA(double Updated_CGPA) {
		this.CGPA=CGPA;
	}	
	
	//Method to display student details
	public void displayStudentInfo() {
		System.out.println("Student Name : "+name);
		System.out.println("Roll Number : "+rollNumber);
		System.out.println("CGPA : "+CGPA);
	}
	
	public static void main(String[] args){
		//creating Student
		Student std1=new Student(123,"Aryan",8.5); 
		std1.displayStudentInfo();
		//Updating CGPA
		std1.setCGPA(7.1);
		System.out.println("Updated CGPA: "+std1.getCGPA());
		
		//creating a PostGraduateStudent object
		PostgraduateStudent pg=new PostgraduateStudent(159,"Ishita Sharma",8.9,"AIML");
		pg.displayPostgraduateInfo();
	}
}
	
//subclass:postGraduateStudent
class PostgraduateStudent extends Student{
	private String researchTopic;
	//constructor
	public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchTopic) {	
		super(rollNumber,name,CGPA);
		this.researchTopic=researchTopic;
	}
	
	// Method to display postgraduate student details
    public void displayPostgraduateInfo() {
        // Accessing protected 'name' and public 'rollNumber' from parent
        System.out.println("\nPostgraduate Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("CGPA: " + getCGPA()); // Accessing private CGPA via getter
    }
}