import java.util.*;
public class Question29{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		if(num<=0){
			System.out.println("Not a natural number");
		}
		else{
			for(int i=1;i<=num;i++){
				if(i%2==0){
					System.out.println(i+" is a even number");
				}
				else{
					System.out.println(i+" is not a odd number");
				}
			}
		}
	}
}	