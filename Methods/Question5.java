import java.util.*;
public class Question5{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double side1=sc.nextDouble();
		double side2=sc.nextDouble();
		double side3=sc.nextDouble();
		System.out.println(rounds(side1,side2,side3));
	}
	public static double rounds(double num1, double num2, double num3){
		double round=5/(num1+num2+num3);
		return round;
	}
}