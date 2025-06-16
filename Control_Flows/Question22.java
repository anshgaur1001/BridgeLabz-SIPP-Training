import java.util.*;
public class Question22{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter age of Amar, akbar and anthony");
		int Age1 = sc.nextInt();
		int Age2 = sc.nextInt();
		int Age3 = sc.nextInt();
		System.out.println();
		if(Age1<Age2 && Age1<Age3){
			System.out.println("Amar is the youngest friend");
		}
		else if(Age2<Age1 && Age2<Age3){
			System.out.println("Akbar is the youngest friend");
		}
		else{
			System.out.println("Anthony is the youngest friend");
		}
		System.out.println("Enter height of Amar, akbar and anthony");
		int height1 = sc.nextInt();
		int height2 = sc.nextInt();
		int height3 = sc.nextInt();
		if(height1>height2 && height1>height3){
			System.out.println("Amar is the tallest friend");
		}
		else if(height2>height1 && height2>height3){
			System.out.println("Akbar is the tallest friend");
		}
		else{
			System.out.println("Anthony is the tallest friend");
		}

	}
}