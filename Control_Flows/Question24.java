import java.util.*;
public class Question24{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num>100){
			System.out.println("Please type number less than 100");
		}
		else{
			for(int i=num;i>=1;i--){
				if(num%i==0){
					System.out.println(i);
				}
			}
		}
	}
}