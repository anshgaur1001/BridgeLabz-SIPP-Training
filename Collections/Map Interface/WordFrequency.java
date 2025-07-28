import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";

        // Convert to lowercase and remove punctuation using regex
        text = text.toLowerCase().replaceAll("[^a-z\\s]", "");

        // Split the text into words
        String[] words = text.split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                // Get current count or 0 if not present
                int count = wordCount.getOrDefault(word, 0);
                wordCount.put(word, count + 1);
            }
        }

        // Print the word frequencies
        System.out.println("Word Frequencies : ");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
