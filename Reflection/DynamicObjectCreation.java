import java.lang.reflect.Constructor;
import java.util.Scanner;

public class DynamicObjectCreation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Student Age : ");
            int age = sc.nextInt();

            // Get Class object
            Class<?> cls = Class.forName("Student");  

            // Get Constructor with parameters (String, int)
            Constructor<?> constructor = cls.getConstructor(String.class, int.class);

            // Create object dynamically (without 'new')
            Object obj = constructor.newInstance(name, age);

            // Call display method
            cls.getMethod("display").invoke(obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
