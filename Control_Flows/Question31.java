import java.util.*;
public class Question31{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		Boolean isPrime=true;
		for(int i=2;i<num;i++){
			if(num%2==0){
				isPrime=false;
				break;
			}
		}
		System.out.println(isPrime);
	}
}