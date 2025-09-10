import java.util.Scanner;

public class DependencyInjection {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
            DIContainer container = new DIContainer();

            System.out.print("Enter client name : ");
            String name = sc.nextLine();

            // Create client with injected dependencies
            Client client = container.getInstance(Client.class);

            System.out.println("Starting services for client : " + name);
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
