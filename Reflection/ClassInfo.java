import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfo {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        // Accept class name from user
        System.out.print("Enter fully qualified class name : ");
        String className = sc.nextLine();

        try {
            // Load class dynamically
            Class<?> cls = Class.forName(className);

            System.out.println("\nClass Name : " + cls.getName());
            System.out.println("Package : " + cls.getPackage());

            // Display constructors
            System.out.println("\n--- Constructors ---");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Display fields
            System.out.println("\n--- Fields ---");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // Display methods
            System.out.println("\n--- Methods ---");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found! Please enter a valid class name.");
        }
    }
}
