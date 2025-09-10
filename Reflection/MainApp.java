import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name : ");
        String name = sc.nextLine();

        System.out.print("Enter age : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter street : ");
        String street = sc.nextLine();

        System.out.print("Enter city : ");
        String city = sc.nextLine();

        System.out.print("Enter hobbies (comma separated) : ");
        String hobbiesInput = sc.nextLine();
        List<String> hobbies = Arrays.asList(hobbiesInput.split(","));

        // Create objects
        Address addr = new Address(street, city);
        Persons person = new Persons(name, age, addr, hobbies);

        // Convert to JSON
        String json = ReflectiveJSON.toJson(person);
        System.out.println("\nJSON Representation:");
        System.out.println(json);
    }
}
