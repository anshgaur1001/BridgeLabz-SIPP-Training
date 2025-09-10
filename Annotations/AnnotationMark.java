import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class AnnotationMark {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Ask user for method name to execute
        System.out.print("Enter method name to execute : ");
        String methodName = sc.nextLine();

        MyClass obj = new MyClass();
        Method[] methods = MyClass.class.getDeclaredMethods();

        System.out.println("\nImportant Methods:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("- " + method.getName() + " (Level : " + annotation.level() + ")");
            }
        }

        // Execute the method entered by the user
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                method.invoke(obj);
            }
        }
	}
}
