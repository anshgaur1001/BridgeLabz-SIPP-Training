import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        List<String> jsonPairs = new ArrayList<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    String key = annotation.name();
                    String jsonValue = (value instanceof String) ? "\"" + value + "\"" : value.toString();
                    jsonPairs.add("\"" + key + "\":" + jsonValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        json.append(String.join(",", jsonPairs));
        json.append("}");
        return json.toString();
    }
}