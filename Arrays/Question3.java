import java.util.*;
public class Question3{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double arr[]=new double[10];
		double  sum=0;
		int idx=0;
		double temp;
		while(true){
			temp=sc.nextDouble();
			if(temp<1 || idx>=10){
				break;
			}
			arr[idx]=temp;
			idx++;
			sum+=temp;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("Total sum = " + sum);
	}
}