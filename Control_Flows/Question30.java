import java.util.*;
public class Question30{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int sum=0;
		int org=num;
		int rem;
		while(org>0){
			rem=org%10;
			sum+=(rem*rem*rem);
			org/=10;
		}
		if(num==sum){
			System.out.println("It's an Armstrong Number");
		}
		else{
			System.out.println("It's not an Armstrong Number");
		}
	}
}