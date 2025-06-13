import java.util.*;
public class Question1{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int height=sc.nextInt();
		float inch=height/2.54f;
		double feet=inch/12;
		System.out.println("Your Height in cm is " + height + " while in feet is" + feet + "and inches is " + inch);
	}
}