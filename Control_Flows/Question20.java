import java.util.*;
public class Question20{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println();
		if(num<0){
			System.out.println("Number is not valid");
		}
		int counter=1;
		while(counter<num){
			if(num%counter==0){
				System.out.println(counter);
			}
			counter++;
		}

	}
}