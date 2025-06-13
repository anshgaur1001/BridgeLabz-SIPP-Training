import java.util.*;
public class Question7{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int fee=sc.nextInt();
		int discountPercent=sc.nextInt();
		int discount=(fee/100)*discountPercent;
		System.out.println(" The discount amount is INR "+discount+" and final discounted fee is INR " + (fee-discount));
	}
}