import java.util.*;
public class Question4{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int rows=sc.nextInt();
		int columns=sc.nextInt();
		int arr1[][]=new int[rows][columns];
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				arr1[i][j]=sc.nextInt();
			}
		}
		int arr2[]=new int[rows*columns];
		int idx=0;
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				arr2[idx]=arr1[i][j];
				idx++;
			}
		}
		System.out.println(Arrays.toString(arr2));
	}
}