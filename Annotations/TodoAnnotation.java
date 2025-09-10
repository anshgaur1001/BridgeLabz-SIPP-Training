import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TodoAnnotation {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        ProjectTasks project = new ProjectTasks();
        Method[] methods = ProjectTasks.class.getDeclaredMethods();

        System.out.println("Pending Tasks:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("- Method : " + method.getName());
                System.out.println("  Task : " + todo.task());
                System.out.println("  Assigned To : " + todo.assignedTo());
                System.out.println("  Priority : " + todo.priority());
                System.out.println();
            }
        }

        // Ask user for a method to execute
        System.out.print("Enter a method name to execute (optional) : ");
        String methodName = sc.nextLine();

        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                method.invoke(project);
            }
        }
	}
}
