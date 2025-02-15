package com.regex.extractionproblems;
import java.util.regex.*;
public class ExtractDates {

    public static void main(String[] args) {

       String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

       // \\b word boundary ensure the date is a stand aloe word not a part of the string
       // \\d{2} matches exactly two digit
       // / matches a literal forward slash as a seperator
       // \\d{4} matches four digit 2025

       String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(text);

       while(matcher.find()){

           System.out.println("Date found:"+ matcher.group());

       }

    }
}
