import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SimpleWordCounter {
    public static void main(String[] args) {
        // Example text snippet
        String text = "Sports bring people together. Sports inspire teamwork. Sports create leaders.";

        // Step 1: Normalize → lowercase + remove punctuation
        String[] words = text.toLowerCase()
                             .replaceAll("[^a-z\\s]", "") // remove punctuation
                             .split("\\s+"); // split by spaces

        // Step 2: Count word frequencies using Stream API
        Map<String, Long> wordCount = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Step 3: Print results
        System.out.println("---- Word Frequencies ----");
        wordCount.forEach((word, count) -> System.out.println(word + " → " + count));

        // Step 4: Find most frequent word
        Map.Entry<String, Long> mostFrequent = wordCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println("\nMost Frequent Word: " +
                (mostFrequent != null ? mostFrequent.getKey() + " → " + mostFrequent.getValue() : "None"));

        // Step 5: Rare words (count = 1)
        System.out.println("\nRarely Used Words:");
        wordCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}
