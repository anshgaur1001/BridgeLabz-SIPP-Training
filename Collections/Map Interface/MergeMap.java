import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MergeMap {
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of entries in Map1 : ");
        int n1 = sc.nextInt();
        Map<String, Integer> map1 = new HashMap<>();
        System.out.println("Enter key and value pairs for Map1 : ");
        for (int i = 0; i < n1; i++) {
            String key = sc.next();
            int value = sc.nextInt();
            map1.put(key, value);
        }

        System.out.print("Enter number of entries in Map2 : ");
        int n2 = sc.nextInt();
        Map<String, Integer> map2 = new HashMap<>();
        System.out.println("Enter key and value pairs for Map2 : ");
        for (int i = 0; i < n2; i++) {
            String key = sc.next();
            int value = sc.nextInt();
            map2.put(key, value);
        }

        // Merging maps
        Map<String, Integer> result = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        System.out.println("Merged Map : " + result);
    }
}
