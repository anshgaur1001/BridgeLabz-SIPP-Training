import java.util.*;
public class Question2{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		 int arr[]=new int[5];
		double sum=0;
		for(int i=0;i<arr.length;i++){
			arr[i]=sc.nextInt();
			if(arr[i]>0){
				if(arr[i]%2==0){
					System.out.println("It's a even number");
				}
				else{
					System.out.println("It's a odd number");
				}
			}
			else if(arr[i]==0){
				System.out.println("Its a zero");
			}
			else{
				System.out.println("It's a negative number");
			}
		}
		if(arr[0]<arr[arr.length-1]){
			System.out.println("First is lesser then last");
		}
		else if(arr[0]>arr[arr.length-1]){
			System.out.println("First is greater then last");
		}
		else{
			System.out.println("Last and First are equal");
		}
	}
}