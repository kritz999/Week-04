package com.regex.extractionproblems;
import java.util.regex.*;
public class ExtractAllEmailAddressFromAText {

    public static void main(String[] args) {

        String email = "Contact us at support@example.com and info@company.org";
        String regex = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";

        Pattern pattern  = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        while(matcher.find()){
            System.out.println("Email found :"+ matcher.group());
        }


    }
}
