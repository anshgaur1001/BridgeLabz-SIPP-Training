import java.util.Scanner;

public class AnnotationRuntime {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter class name (Book / Article) : ");
            String className = sc.nextLine();

            // Load class dynamically
            Class<?> cls = Class.forName(className);

            if (cls.isAnnotationPresent(Author.class)) {
                Author author = cls.getAnnotation(Author.class);
                System.out.println("Author of " + className + " : " + author.name());
            } else {
                System.out.println("No @Author annotation found on " + className);
            }

        } catch (Exception e) {
            System.out.println("Class not found! Please enter correct name.");
        }
	}
}
