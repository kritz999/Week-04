package com.regex.advanceproblem;
import java.util.regex.*;
import java.util.*;
public class ExtractProgrammingLanguage {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // List of programming languages
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "Swift", "Kotlin", "R", "Perl", "PHP", "TypeScript");

        // Create a regex pattern with word boundaries
        String patternString = "\\b(" + String.join("|", languages) + ")\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        // Store matched languages
        List<String> matchedLanguages = new ArrayList<>();

        while (matcher.find()) {
            matchedLanguages.add(matcher.group());
        }

        // Print output as comma-separated values
        System.out.println(String.join(", ", matchedLanguages));
    }
}
