import java.util.*;
public class Question1{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.print("Is the number "+n+" divisible by 5? ");
		if(n%5==0){
			System.out.print("Yes");
		}
		else{
			System.out.print("No");
		}
	}
}