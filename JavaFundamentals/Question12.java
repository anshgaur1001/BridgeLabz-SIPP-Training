import java.util.*;
public class Question12{
	public static void main(String[] args){
		int a,b,c;
		Scanner input=new Scanner(System.in);
		a=input.nextInt();
		b=input.nextInt();
		c=input.nextInt();
		System.out.println("The results of Int Operations are "+(a+b*c)+" ," +(a*b+c)+" ,"+(c + a / b)+" and "+(a % b + c));
		
	}
}