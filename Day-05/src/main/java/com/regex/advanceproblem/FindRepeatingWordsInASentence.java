package com.regex.advanceproblem;
import java.util.*;
import java.util.regex.*;

public class FindRepeatingWordsInASentence {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Regular expression to match words
        String patternString = "\\b(\\w+)\\b";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        // Using a HashMap to track word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase for case insensitivity
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Collect repeating words
        List<String> repeatingWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }

        // Print output
        System.out.println(String.join(", ", repeatingWords));
    }
}
