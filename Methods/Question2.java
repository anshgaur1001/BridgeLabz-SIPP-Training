import java.util.*;
public class Question2{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(Sum_NatNum(n));
	}
	public static int Sum_NatNum(int n){
		int count=0;
		for(int i=1;i<=n;i++){
			count+=i;
		}
		return count;
	}
}