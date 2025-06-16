import java.util.*;
public class Question13{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		if(num1<0){
			System.out.println("The number "+num1+" is not a natural number");
		}
		else{
			System.out.println("The sum of "+num1+" natural numbers is "+num1*(num1+1)/2);
		}
	}
}