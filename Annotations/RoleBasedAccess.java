import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class RoleBasedAccess {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter your role (ADMIN/USER): ");
        String userRole = sc.nextLine().trim().toUpperCase();

        AdminService service = new AdminService();

        // Try to call performAdminTask
        Method adminMethod = AdminService.class.getMethod("performAdminTask");

        if (adminMethod.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = adminMethod.getAnnotation(RoleAllowed.class);
            if (roleAllowed.value().equals(userRole)) {
                adminMethod.invoke(service); 
            } else {
                System.out.println("Access Denied!");
            }
        } else {
            adminMethod.invoke(service); 
        }

        // Optional: Call user method (no restriction)
        Method userMethod = AdminService.class.getMethod("performUserTask");
        userMethod.invoke(service);
	}
}
