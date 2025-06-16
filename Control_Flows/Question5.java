import java.util.*;
public class Question5{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		if(num1==0){
			System.out.print("Zero");
		}
		else if(num1>0){
			System.out.print("Positive");
		}
		else{
			System.out.print("Negative");
		}
	}
}