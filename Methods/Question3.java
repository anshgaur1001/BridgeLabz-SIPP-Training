import java.util.*;
public class Question3{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int arr[]=findRemainderAndQuotient(num1, num2);
		System.out.println("Quotient : "+arr[0]+", remainder : "+arr[1]);
	}
	public static int[] findRemainderAndQuotient(int number, int divisor){
        int arr[]={number/divisor,number%divisor};
        return arr;
	}
}