import java.lang.reflect.Method;

class MethodTimer {
    public static void runMethod(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);

        if (method.isAnnotationPresent(Timed.class)) {
            long start = System.nanoTime();
            method.invoke(obj);
            long end = System.nanoTime();

            System.out.println("[TIME] Execution time: " + (end - start) / 1_000_000.0 + " ms");
        } else {
            method.invoke(obj);
        }
    }
}