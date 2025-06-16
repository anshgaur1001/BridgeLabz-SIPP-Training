import java.util.*;
public class Question23{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int greatestFactor=1;
		int counter=num-1;
		while(counter!=1){
			if(num%counter==0){
				greatestFactor=counter;
				break;
			}
			counter--;
		}
		System.out.println("Greatest Factor: "+greatestFactor);
	}
}