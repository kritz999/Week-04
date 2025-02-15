package com.regex.basicregexproblem;
import java.util.regex.*;

public class PatternAndMatcherClasses {
  public static void main(String[] args) {

    String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

    Pattern pattern = Pattern.compile(regex);

    String [] usernames = {"user_123", "123user", "us"};

        for(String username : usernames){
            // matcher object that will check whether a given string (usernames) matches the specified pattern
           Matcher matcher = pattern.matcher(username);

           // only  returns true if the entire string follow the pattern
           if(matcher.matches()){

               System.out.println(username + "is VALID");
           }else{
               System.out.println(username +" is INVALID");
           }
        }

    }
}
