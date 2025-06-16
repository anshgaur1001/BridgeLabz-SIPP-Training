import java.util.*;
public class Question25{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int greatestFactor=1;
		int counter=num-1;
		for(;counter>0;counter--){
			if(num%counter==0){
				greatestFactor=counter;
				break;
			}
		}
		System.out.println("Greatest Factor: "+greatestFactor);
	}
}