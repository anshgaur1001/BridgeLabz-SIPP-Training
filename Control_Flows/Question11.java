import java.util.*;
public class Question11{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		if(num1<0){
			System.out.println("Not a Natural number");
		}
		else{
			int sum=0;
			for(int i=1;i<=num1;i++){
				sum+=i;
			}
			System.out.println("Compute value from loop: "+sum+", Compute value from formulae: "+num1*(num1+1)/2);
			System.out.println("Is both value are same: "+(sum == (num1*(num1+1)/2)));
		}
	}
}