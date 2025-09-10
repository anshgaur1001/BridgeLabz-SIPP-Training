import java.lang.reflect.*;
import java.util.*;

public class ReflectiveJSON {

    public static String toJson(Object obj) {
        return toJson(obj, new IdentityHashMap<>());
    }

    private static String toJson(Object obj, IdentityHashMap<Object, Boolean> visited) {
        if (obj == null) return "null";

        // primitive wrappers, numbers, boolean
        if (obj instanceof Number || obj instanceof Boolean) {
            return obj.toString();
        }

        // String
        if (obj instanceof String || obj instanceof Character) {
            return "\"" + escapeJson(obj.toString()) + "\"";
        }

        // Prevent cycles
        if (visited.containsKey(obj)) return "\"<cyclic>\"";
        visited.put(obj, true);

        // Array
        if (obj.getClass().isArray()) {
            int len = Array.getLength(obj);
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < len; i++) {
                sb.append(toJson(Array.get(obj, i), visited));
                if (i < len - 1) sb.append(",");
            }
            sb.append("]");
            return sb.toString();
        }

        // Collection
        if (obj instanceof Collection) {
            Collection<?> col = (Collection<?>) obj;
            StringBuilder sb = new StringBuilder("[");
            Iterator<?> it = col.iterator();
            while (it.hasNext()) {
                sb.append(toJson(it.next(), visited));
                if (it.hasNext()) sb.append(",");
            }
            sb.append("]");
            return sb.toString();
        }

        // Map
        if (obj instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) obj;
            StringBuilder sb = new StringBuilder("{");
            Iterator<? extends Map.Entry<?, ?>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<?, ?> e = it.next();
                sb.append("\"").append(escapeJson(String.valueOf(e.getKey()))).append("\":");
                sb.append(toJson(e.getValue(), visited));
                if (it.hasNext()) sb.append(",");
            }
            sb.append("}");
            return sb.toString();
        }

        // Otherwise: inspect fields
        StringBuilder sb = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            try {
                sb.append("\"").append(f.getName()).append("\":");
                sb.append(toJson(f.get(obj), visited));
            } catch (Exception e) {
                sb.append("\"<error>\"");
            }
            if (i < fields.length - 1) sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }

    private static String escapeJson(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
