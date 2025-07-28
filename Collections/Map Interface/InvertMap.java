import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class InvertMap {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Inverted Map<V, List<K>>
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        System.out.println("Inverted Map : " + invertedMap);
    }

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> inverted = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            inverted.putIfAbsent(value, new ArrayList<>());
            inverted.get(value).add(key);
        }
        return inverted;
    }
}
