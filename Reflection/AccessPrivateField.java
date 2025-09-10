import java.lang.reflect.Field;
import java.util.Scanner;

public class AccessPrivateField {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter initial age : ");
            int initialAge = sc.nextInt();
            Person p = new Person(initialAge);
            p.showAge();

            // Get class object
            Class<?> cls = p.getClass();

            // Access private field 'age'
            Field field = cls.getDeclaredField("age");
            field.setAccessible(true);

            // Take new age from user
            System.out.print("Enter new age to set (via Reflection) : ");
            int newAge = sc.nextInt();

            // Modify private field
            field.set(p, newAge);

            // Retrieve updated value
            int updatedAge = (int) field.get(p);
            System.out.println("Updated Age (via Reflection) : " + updatedAge);

            p.showAge();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
