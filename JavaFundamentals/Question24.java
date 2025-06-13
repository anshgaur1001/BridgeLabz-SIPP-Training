import java.util.*;
public class Question24{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int chocolates=sc.nextInt();
		int children=sc.nextInt();
		System.out.println("The number of chocolates each child gets is "+(chocolates/children)+" and the number of remaining chocolates is "+(chocolates%children));
	}
}