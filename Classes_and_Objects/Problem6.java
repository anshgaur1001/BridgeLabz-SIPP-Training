package Classes_and_Objects;
import java.util.*;
class Student{
	int rollNumber,Marks;
	String name,grade;
	public Student(String name,int rollNumber, int marks) {
		this.name=name;
		this.rollNumber=rollNumber;
		this.Marks=marks;
	}
	public void grade(int marks) {
			if(marks<=100 && marks>80) {
				this.grade="Excellent";
			}
			else if(marks<=80 && marks>70) {
				this.grade="Very Good";
			}
			else if(marks<=70 && marks>60) {
				this.grade="Good";
			}
			else if(marks<=60 && marks>50) {
				this.grade="Average";
			}
			else if(marks<=50 && marks>33) {
				this.grade="Below Average";
			}
			else {
				this.grade="Fail";
			}
		}
	public void display(){
		grade(Marks);
		System.out.println("Student name is "+name+" with roll number "+rollNumber+". Grade formed is : "+grade);
	}
}
public class Problem6{
	public static void main(String[] args) {
		Student st1=new Student("Ansh",123,88);
		Student st2=new Student("Ayan",456,30);
		Student st3=new Student("Ayush",789,65);
		st1.display();
		st2.display();
		st3.display();
	}
}
