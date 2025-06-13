import java.util.*;
public class Question22{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String Name=sc.next();
		String fromCity=sc.next();
		String viaCity=sc.next();
		String toCity=sc.next();
		int fromToVia=sc.nextInt();
		int ViaToFinalCity=sc.nextInt();
		int timeFromToVia=sc.nextInt();
		int timeViaToFinalCity=sc.nextInt();
		System.out.println("The Total Distance travelled by "+Name+" from "+fromCity+" to "+toCity+" via "+viaCity+" is "+(fromToVia+ViaToFinalCity)+" km and the Total Time taken is "+(timeFromToVia+timeViaToFinalCity)+" minutes");
	}
}