package MapInterface;
import java.io.*;
import java.util.*;

    public class WordFrequencyCounter {
        public static void main(String[] args) {
            String filename = "input.txt"; // Change this to your file name

            try {
                String content = readFile(filename);
                Map<String, Integer> wordCount = countWordFrequency(content);
                printWordCount(wordCount);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }

        // Read the content of a file
        public static String readFile(String filename) throws IOException {
            StringBuilder content = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    content.append(line).append(" ");
                }
            }
            return content.toString();
        }

        // Count word frequency
        public static Map<String, Integer> countWordFrequency(String text) {
            Map<String, Integer> wordCount = new HashMap<>();

            // Convert to lowercase and remove punctuation
            text = text.toLowerCase().replaceAll("[^a-z0-9 ]", "");

            // Split words by whitespace
            String[] words = text.split("\\s+");

            // Count occurrences
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
            return wordCount;
        }

        // Print word count
        public static void printWordCount(Map<String, Integer> wordCount) {
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }


