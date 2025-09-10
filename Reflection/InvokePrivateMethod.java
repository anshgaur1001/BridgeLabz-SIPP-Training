import java.lang.reflect.Method;
import java.util.Scanner;

public class InvokePrivateMethod {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter first number : ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number : ");
            int num2 = sc.nextInt();

            // Create Calculator object
            Calculator calc = new Calculator();

            // Get Class object
            Class<?> cls = calc.getClass();

            // Access private method multiply(int, int)
            Method method = cls.getDeclaredMethod("multiply", int.class, int.class);

            // Make it accessible
            method.setAccessible(true);

            // Invoke the private method
            Object result = method.invoke(calc, num1, num2);

            System.out.println("Result of multiplication : " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
