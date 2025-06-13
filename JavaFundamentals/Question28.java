import java.util.Scanner;

public class Question28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double Principal = scanner.nextDouble();
        double Rate = scanner.nextDouble();
        double Time = scanner.nextDouble();
	double SI=(Principal*Rate*Time)/100;
        System.out.println("The Simple Interest is "+SI+" for Principal "+Principal+", Rate of Interest "+Rate+" and Time "+Time);
    }
}
