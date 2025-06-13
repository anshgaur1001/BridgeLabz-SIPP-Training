import java.util.*;
public class Question15{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int feet=input.nextInt();
		int yards=feet/3;
		int miles=yards/1760;
		System.out.println("The distance in yards is "+yards+" while the distance in miles is "+miles);
	}
}