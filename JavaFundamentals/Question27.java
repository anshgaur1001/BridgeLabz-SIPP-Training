import java.util.Scanner;

public class Question27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float fahrenheit = scanner.nextFloat();
	float celsius=(fahrenheit-32)*5/9;
        System.out.println("The "+fahrenheit+" fahrenheit is "+celsius+ " celsius");
    }
}