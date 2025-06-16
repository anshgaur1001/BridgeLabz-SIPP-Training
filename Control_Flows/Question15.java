import java.util.*;
public class Question15{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter date");
		int date=sc.nextInt();
		System.out.println("Enter month");
		int month=sc.nextInt();
		if(month==3 &&(date>19 && date<32)){
			System.out.println("Its a Spring Season");
		}
		else if((month>3 && month<6)&&(date>0 && date<32)){
			System.out.println("Its a Spring Season");
		}
		else if(month==6 &&(date>0 && date<21)){
			System.out.println("Its a Spring Season");
		}
		else{
			System.out.println("Not a Spring Season");
		}
	}
}