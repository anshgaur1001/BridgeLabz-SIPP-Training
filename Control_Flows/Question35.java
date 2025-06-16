import java.util.*;
public class Question35{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int month=sc.nextInt();
		int date=sc.nextInt();
		int year=sc.nextInt();
		int Y=year-(14-month)/12;
		int X=Y+Y/4-Y/100+Y/400;
		int M=month+10*((14-month)/12)-2;
		int D=(date+X+(31*M)/12)%7;
		switch(D){
			case 0:
				System.out.println("Sunday");
				break;

			case 1:
				System.out.println("Monday");
				break;
			case 2:
				System.out.println("Tuesday");
				break;
			case 3:
				System.out.println("Wednesday");
				break;
			case 4:
				System.out.println("Thrusday");
				break;
			case 5:
				System.out.println("Friday");
				break;
			case 6:
				System.out.println("Saturday");
				break;
			default:
				System.out.println("Invalid date");
			}
				
	}
}