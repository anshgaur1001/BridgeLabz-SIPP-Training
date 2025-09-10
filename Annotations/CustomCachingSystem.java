import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class CustomCachingSystem {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        ExpensiveCalculator calculator = new ExpensiveCalculator();

        while (true) {
            System.out.print("Enter a number to calculate factorial : ");
            int num = scanner.nextInt();

            if (num == -1) break;

            // Check if method has @CacheResult annotation
            Method method = ExpensiveCalculator.class.getMethod("factorial", int.class);
            if (method.isAnnotationPresent(CacheResult.class)) {
                long result = (long) method.invoke(calculator, num);
                System.out.println("Factorial of " + num + " = " + result);
            } else {
                System.out.println("Method is not cacheable.");
            }
        }
	}
}
