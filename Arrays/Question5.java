import java.util.*;
public class Question5{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i]=sc.nextInt();
			if(arr[i]<0){
				System.out.println("Not a valid age");
			}
			else if(arr[i]<18){
				System.out.println("The student with the age "+arr[i]+" cannot vote");
			}
			else{
				System.out.println("The student with the age "+arr[i]+" can vote");
			}
		}
	}
}