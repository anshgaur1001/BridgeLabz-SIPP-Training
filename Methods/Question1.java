import java.util.*;
public class Question1{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(IsNumber(n));		
	}
	public static int IsNumber(int n){
		if(n==0){
			return 0;
		}
		else if(n>0){
			return 1;
		}
		else{
			return 0;
		}
	}
}