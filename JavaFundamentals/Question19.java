import java.util.*;
public class Question19{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int side1=input.nextInt();
		float side2=input.nextInt();
		float side3=input.nextInt();
		System.out.println("The total number of rounds the athlete will run is "+5/(side1+side2+side3)+" to complete 5 km");
	}
}