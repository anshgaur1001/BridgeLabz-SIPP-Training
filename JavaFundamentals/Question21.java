import java.util.*;
public class Question21{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		float celsius=input.nextFloat();
		float farenheitResult = (celsius*9/5)+32;
		System.out.println("The "+celsius+" celsius is "+ farenheitResult +" Fahrenheit");
	}
}