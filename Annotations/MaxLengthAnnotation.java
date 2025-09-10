import java.util.Scanner;

public class MaxLengthAnnotation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter username (max 8 characters) : ");
        String inputUsername = sc.nextLine();

        try {
            User user = new User(inputUsername);
            System.out.println("Username is valid : " + user.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error : " + e.getMessage());
        }
	}
}
