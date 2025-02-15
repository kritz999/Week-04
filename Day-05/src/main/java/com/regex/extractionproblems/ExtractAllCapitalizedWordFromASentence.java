package com.regex.extractionproblems;
import java.util.regex.*;
public class ExtractAllCapitalizedWordFromASentence {

    public static void main(String[] args) {
        String regex ="\\b[A-Z][a-z]*\\b";
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";


        Pattern pattern = Pattern.compile(regex);

       Matcher matcher = pattern.matcher(text);

       while(matcher.find()){
            System.out.println(matcher.group());
        }

    }

}
