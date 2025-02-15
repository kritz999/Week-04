package com.regex.advanceproblem;
import java.util.regex.*;
public class ValidateASocialSecurityNumber {
    public static void main(String[] args) {
        String text1 = "My SSN is 123-45-6789.";
        String text2 = "Invalid SSN 123456789.";

        // Regular expression to match SSN format "XXX-XX-XXXX"
        String ssnPattern = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        validateSSN(text1, ssnPattern);
        validateSSN(text2, ssnPattern);
    }

    public static void validateSSN(String text, String pattern) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(text);

        if (matcher.find()) {
            System.out.println(" \"" + matcher.group() + "\" is valid");
        } else {
            System.out.println("No valid SSN found in: \"" + text + "\"");
        }
    }
}
