import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class LoggingHandler implements InvocationHandler {
    private Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log method name
        System.out.println("[LOG] Method called: " + method.getName());

        // Call the actual method
        return method.invoke(target, args);
    }
}