import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ExecutionTimeLogger {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        PerformanceTest test = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        System.out.println("Available Methods : ");
        for (Method method : methods) {
            System.out.println("- " + method.getName());
        }

        System.out.print("\nEnter a method name to execute : ");
        String methodName = sc.nextLine();

        boolean found = false;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                found = true;
                if (method.isAnnotationPresent(LogExecutionTime.class)) {
                    long startTime = System.nanoTime();
                    method.invoke(test);
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    System.out.println("Execution time : " + duration + " ns");
                } else {
                    method.invoke(test);
                    System.out.println("This method is not annotated for execution time logging.");
                }
            }
        }

        if (!found) {
            System.out.println("Method not found.");
        }
	}
}
