import java.util.*;
public class Question26{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num>100){
			System.out.println("Please type number less than 100");
		}
		else{
			int counter=num-1;
			while(counter>1){
				if(num%counter==0){
					System.out.println(counter);
				}
				counter--;
			}
		}
	}
}