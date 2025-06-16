import java.util.*;
public class Question32{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int sum=0;
		int temp=num;
		int rem;
		while(temp>0){
			rem=temp%10;
			sum+=rem;
			temp/=10;
		}
		if(num%sum==0){
			System.out.println("HarshaNumber");
		}
		else{
			System.out.println("Not a HarshadNumber");
		}
	}
}