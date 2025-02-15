package com.regex.advanceproblem;
import java.util.regex.*;
import java.util.*;

public class ExtractCurrencyValuesFromAText {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        // Regular expression to match currency values (with or without '$')
        String regex = "\\$?\\d+(\\.\\d{1,2})?";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> currencyValues = new ArrayList<>();

        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        // Print extracted values as comma-separated string
        System.out.println(String.join(", ", currencyValues));
    }
}
