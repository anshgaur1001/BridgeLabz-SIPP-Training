import java.util.*;
public class Question17{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int number = sc.nextInt();
		for(int i=6;i<10;i++){
			System.out.println(number +" * "+ i + " = "+(number*i));
		}
	}
}