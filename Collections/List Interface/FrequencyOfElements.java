import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FrequencyOfElements {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<String> list = new ArrayList<>();
        System.out.println("Enter the strings : ");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : list) {
            if (frequencyMap.containsKey(word)) {
                frequencyMap.put(word, frequencyMap.get(word) + 1);
            } else {
                frequencyMap.put(word, 1);
            }
        }
        System.out.println("Frequency of elements : " + frequencyMap);
	}
}
