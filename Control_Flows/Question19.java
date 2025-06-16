import java.util.*;
public class Question19{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println();
		if(num<0){
			System.out.println("Not a valid input");
		}
		else{
			for(int i=1;i<=num;i++){
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
			}
		}

	}
}