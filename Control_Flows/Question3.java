import java.util.*;
public class Question3{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		if(num1>=18){
			System.out.print("The person's age is "+num1+" and can vote.");
		}
		else{
			System.out.print("The person's age is "+num1+" and cannot vote.");
		}
	}
}