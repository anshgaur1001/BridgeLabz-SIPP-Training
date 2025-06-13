import java.util.*;
public class Question14{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int unitPrice=input.nextInt();
		int Quantity=input.nextInt();
		System.out.println("The total purchase price is INR "+(unitPrice*Quantity)+" if the quantity "+Quantity+" and the unit price is INR "+unitPrice);
	}
}