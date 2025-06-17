import java.util.*;
public class Question1{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double arr[]=new double[11];
		double sum=0;
		for(int i=0;i<11;i++){
			arr[i]=sc.nextDouble();
			sum += arr[i];
		}
		System.out.println("Mean height : "+(sum/11));
	}
}