import java.lang.reflect.Proxy;
import java.util.Scanner;

public class DynamicProxy {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        // Ask user for name
        System.out.print("Enter your name : ");
        String userName = sc.nextLine();

        // Create real object
        Greeting realGreeting = new GreetingImpl();

        // Create Proxy
        Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingHandler(realGreeting)
        );

        // Call method through proxy
        proxyGreeting.sayHello(userName);
	}
}
