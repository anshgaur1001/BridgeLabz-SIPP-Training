import java.util.*;
public class Question11{
	public static void main(String[] args){
		double a,b,c;
		Scanner input=new Scanner(System.in);
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		System.out.println("The results of Int Operations are "+(a+b*c)+" ," +(a*b+c)+" ,"+(c + a / b)+" and "+(a % b + c));
		
	}
}