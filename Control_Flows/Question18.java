import java.util.*;
public class Question18{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int salary = sc.nextInt();
		int service_year=sc.nextInt();
		if(service_year>5){
			System.out.println("Bonus: "+(salary/100)*5);
		}
		else{
			System.out.println("No bonus");
		}
	}
}