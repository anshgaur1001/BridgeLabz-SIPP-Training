package Day2;

public class StudentRecordManagement {
	static class Student{
		String name;
		int roll_number;
		int age;
		char Grade;
		Student next;
		Student(String name,int roll_number,int age,char Grade){
			this.name=name;
			this.roll_number=roll_number;
			this.age=age;
			this.Grade=Grade;
			this.next=null;
		}
	}
	public static Student head;
	public static Student tail;
	
	//function for add in start
	public static void add_First(String name,int roll_number,int age,char Grade) {
		Student newStudent=new Student(name,roll_number,age,Grade);
        if(head==null){
            head=tail=newStudent;
            return;
        }
        newStudent.next=head;
        head=newStudent;
	}
	
	//function for add in end
	public static void add_Last(String name,int roll_number,int age,char Grade) {
		Student newStudent=new Student(name,roll_number,age,Grade);
        if(head==null){
            tail=head=newStudent;
            return;
        }
        tail.next=newStudent;
        tail=newStudent;
        }
	
	//function for add in mid
	public void add_Student(int idx,String name,int roll_number,int age,char Grade){
        if(idx==0){
            add_First(name,roll_number,age,Grade);
            return;
        }
        Student newStudent=new Student(name,roll_number,age,Grade);
        Student temp=head;
        int i=0;
        while(i<idx-1){
            temp=temp.next;
            i++;    
        }
        newStudent.next=temp.next;
        temp.next=newStudent;
    }
	
	//Delete a student record by roll number
	public void Roll_Find(int roll_num) {
		Student temp=head;
		if(temp.roll_number==roll_num) {
			head=temp.next;
			temp.next=null;
			return;
		}
		while(temp.next!=null) {
			if(temp.next.roll_number==roll_num) {
				temp.next=temp.next.next;
				return;
			}
			temp=temp.next;
		}
		System.out.println("Record not found. Please enter a valid roll  number");
	}
	
	
	//Search for a student record by roll number
	public void Roll_Search(int roll_Num) {
		Student temp=head;
		while(temp!=null) {
			if(temp.roll_number==roll_Num) {
				System.out.println("Name : "+temp.name);
				System.out.println("Roll Number : "+temp.roll_number);
				System.out.println("Age : "+temp.age);
				System.out.println("Grade : "+temp.Grade);
			}
			temp=temp.next;
		}
		System.out.println("Record not found. Please enter a valid roll  number");
	}
	
	//Display all Students details
	public void DisplayDetails(Student head){
		if(head==null) {
			System.out.println("No data available");
			return;
		}
		Student temp=head;
		while(temp!=null) {
			System.out.println("Name : "+temp.name);
			System.out.println("Roll Number : "+temp.roll_number);
			System.out.println("Age : "+temp.age);
			System.out.println("Grade : "+temp.Grade);
			System.out.println("----------------------------------------------------------------------");
			System.out.println();
			temp=temp.next;
		}
	}
	
	//update student's grade based on their Roll Number
	public void Roll_Update(int Roll_Num,char grade) {
		Student temp=head;
		while(temp!=null) {
			if(temp.roll_number==Roll_Num) {
				temp.Grade=grade;
			}
			temp=temp.next;
		}
		System.out.println("Record not found. Please enter a valid roll  number");
	}
	
	//Main method for testing
	public static void main(String[] args) {
		StudentRecordManagement std=new StudentRecordManagement();
		std.add_First("Rahul", 123, 25, 'A');
		std.add_First("Praveen", 456, 35, 'C');
		std.add_Student(1, "Aryan", 789, 21, 'B');
		std.add_Last("Modit",147,23,'D');
		
		std.DisplayDetails(head);
	}
}