import java.util.*;
public class Question27{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println();
		if(num<0){
			System.out.println("Not a valid input");
		}
		else{
			int i=1;
			while(i!=num){
				if(i%3==0 && i%5==0){
					System.out.println("FizzBuzz");
				}
				else if(i%5==0){
					System.out.println("Buzz");
				}
				else if(i%3==0){
					System.out.println("Fizz");
				}
				else{
					System.out.println(i);
				}
				i++;
			}
		}

	}
}