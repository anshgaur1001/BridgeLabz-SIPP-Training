import java.lang.reflect.Field;
import java.util.Scanner;

public class AccessModifyStaticFields {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        try {
            // Print original value
            Configuration.printKey();

            // Take new API_KEY from user
            System.out.print("Enter new API_KEY : ");
            String newKey = sc.nextLine();

            // Get Class object
            Class<?> cls = Class.forName("Configuration");

            // Access private static field
            Field field = cls.getDeclaredField("API_KEY");

            // Make it accessible
            field.setAccessible(true);

            // Modify static field (null since it's static)
            field.set(null, newKey);

            Configuration.printKey();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
