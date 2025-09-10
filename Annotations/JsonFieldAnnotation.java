import java.util.Scanner;

public class JsonFieldAnnotation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter username : ");
        String username = sc.nextLine();

        System.out.print("Enter age : ");
        int age = sc.nextInt();

        Users user = new Users(username, age);

        String json = JsonSerializer.toJson(user);
        System.out.println("Serialized JSON : ");
        System.out.println(json);
	}
}
