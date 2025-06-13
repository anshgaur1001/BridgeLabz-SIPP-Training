import java.util.*;
public class Question6{
	public static void main(String[] args){
		int fee=125000;
		int discountPercent=10;
		int discount=(125000/100)*10;
		System.out.println(" The discount amount is INR "+discount+" and final discounted fee is INR " + (fee-discount));
	}
}