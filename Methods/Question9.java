import java.util.Scanner;

public class Question9{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature (in Fahrenheit): ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter wind speed (in miles per hour): ");
        double windSpeed = scanner.nextDouble();
        if (temperature > 50 || windSpeed < 3) {
            System.out.println("Wind chill is not defined for temperature > 50°F or wind speed < 3 mph.");
            return;
        }
        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.printf("The wind chill temperature is: %.2f°F\n", windChill);
    }
    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + (0.6215 * temperature)+ (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }
}
