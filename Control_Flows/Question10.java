import java.util.*;
public class Question10{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		if(num1<0){
			System.out.println("Not a Positive number");
		}
		else{
			int fac=1;
			for(int i=1;i<=num1;i++){
				fac*=i;
			}
			System.out.println("Factorial: "+fac);
		}
	}
}