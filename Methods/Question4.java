import java.util.*;
import java.lang.*;
public class Question4{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		double num=sc.nextDouble();
        double arr[]=calculateTrigonometricFunctions(num);
        System.out.println(Arrays.toString(arr));

	}
	public static double[] calculateTrigonometricFunctions(double angle){
        double radian= (angle*(3.14/180));
        double arr[]={Math.sin(radian),Math.cos(radian),Math.tan(radian)};
        return arr;
	}
}