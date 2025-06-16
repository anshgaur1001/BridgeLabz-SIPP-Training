import java.util.*;
public class Question21{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println();
		if(num<0){
			System.out.println("Not a valid input");
		}
		else{
			for(int i=1;i<num;i++){
				if(num%i==0){
					System.out.println(i);
				}
			}
		}

	}
}