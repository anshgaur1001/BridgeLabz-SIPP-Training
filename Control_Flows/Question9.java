import java.util.*;
public class Question9{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		if(num1<0){
			System.out.println("Not a Positive number");
		}
		else{
			int fac=1;
			while(num1>0){
				fac*=num1;
				num1--;
			}
			System.out.print("Factorial: "+fac);
		}
	}
}