package Java_Consturctor;

public class Course {
	//Instance variable 
		String courseName;
		double duration,fee;
		
		//class variable
		static String instituteName="Allen";
		
		//constructor
		public Course(String courseName, double duration, double fee) {
			this.courseName=courseName;
			this.duration=duration;
			this.fee=fee;
		}
		//Instance method
		public void displayCourseDetails() {
			System.out.println("Name of the Course : "+courseName+" with institute "+instituteName);
			System.out.println("Duration of the Course : "+duration);
			System.out.println("Fee of the Course : "+fee);
		}
		
		//class Method
		public static void  updateInstitueName(String updatedInstitute) {
			instituteName=updatedInstitute;
		}
		public static void main(String[] args) {
			//Creation of the course
			Course c1=new Course("Java",120,12000);
			Course c2=new Course("JavaScript",500,20000);
			
			//Displaying details of course1
			c1.displayCourseDetails();
			
			//update institute name
			Course.updateInstitueName("PhysicsWallah");
			
			//Displaying details of course2
			c2.displayCourseDetails();
		}
}
