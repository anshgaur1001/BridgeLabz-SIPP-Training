import java.util.*;
public class Question16{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int number = sc.nextInt();
		int power = sc.nextInt();
		int counter=0;
		int result=1;
		while(counter != power){
			result*=number;
			counter++;	
		}
		System.out.println("The result: "+result);
	}
}