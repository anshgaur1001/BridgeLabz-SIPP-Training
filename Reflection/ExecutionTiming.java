import java.util.Scanner;

public class ExecutionTiming {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Task task = new Task();

        System.out.println("Available methods: quickTask, slowTask, normalTask");
        System.out.print("Enter method name to execute : ");
        String methodName = sc.nextLine();

        try {
            MethodTimer.runMethod(task, methodName);
        } catch (NoSuchMethodException e) {
            System.out.println("No such method found : " + methodName);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
