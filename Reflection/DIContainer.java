import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class DIContainer {
    private Map<Class<?>, Object> instances = new HashMap<>();

    public <T> T getInstance(Class<T> clazz) throws Exception {
        // If already created, return it
        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }

        // Create new instance
        T obj = clazz.getDeclaredConstructor().newInstance();

        // Inject dependencies
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> dependencyType = field.getType();
                Object dependency = getInstance(dependencyType); 
                field.setAccessible(true);
                field.set(obj, dependency);
            }
        }

        // Cache instance
        instances.put(clazz, obj);
        return obj;
    }
}