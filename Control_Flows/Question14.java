import java.util.*;
public class Question14{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double total=0.0;
		double num;
		while(true){
			System.out.println("Enter 0 if you want to disontinue");
			num=sc.nextInt();
			total+=num;
			if(num==0){
				break;
			}
		}
		System.out.println("Total of all number: "+total);
	}
}