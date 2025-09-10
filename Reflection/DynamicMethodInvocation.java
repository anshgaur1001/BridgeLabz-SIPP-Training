import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvocation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter method name (add / subtract / multiply) : ");
            String methodName = sc.nextLine();

            System.out.print("Enter first number : ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number : ");
            int num2 = sc.nextInt();

            // Create object of MathOperations
            MathOperations obj = new MathOperations();

            // Get Class object
            Class<?> cls = obj.getClass();

            // Get the method dynamically
            Method method = cls.getMethod(methodName, int.class, int.class);

            // Invoke the method
            Object result = method.invoke(obj, num1, num2);

            System.out.println("Result of " + methodName + " : " + result);

        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name! Please enter add, subtract, or multiply.");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
