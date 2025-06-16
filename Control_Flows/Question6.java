import java.util.*;
public class Question6{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		if(num1<0){
			System.out.print("The given number is not a natural number");
		}
		else{
			int sum=0;
			for(int i=0;i<=num1;i++){
				sum+=i;
			}
		System.out.println("Compute using while loop: "+sum+", Compute using formulae: "+num1*(num1+1)/2);
		}
	}
}