import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomObjectMapper {
	
	// Generic method to map properties into object
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create new instance
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Loop through all map entries
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);

                    // Convert value types automatically
                    if (field.getType() == int.class && fieldValue instanceof String) {
                        fieldValue = Integer.parseInt((String) fieldValue);
                    }

                    field.set(obj, fieldValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("No field found for : " + fieldName);
                }
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException("Error mapping object : " + e.getMessage(), e);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Map<String, Object> properties = new HashMap<>();

        // Take user input
        System.out.print("Enter student name : ");
        properties.put("name", sc.nextLine());

        System.out.print("Enter student age : ");
        properties.put("age", sc.nextLine()); 

        System.out.print("Enter student course : ");
        properties.put("course", sc.nextLine());

        // Map to Student object
        Students student = toObject(Students.class, properties);

        System.out.println(student);
	}
}
