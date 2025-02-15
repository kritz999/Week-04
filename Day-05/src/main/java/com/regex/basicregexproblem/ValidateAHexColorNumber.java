package com.regex.basicregexproblem;
import java.util.regex.*;
public class ValidateAHexColorNumber {

    public static void main(String[] args) {

        String regex = "^[#][A-Fa-f0-9]{6}$";
        Pattern pattern = Pattern.compile(regex);

        String [] color = {"#FFA500", "#ff4500", "#123"};

        for(String s : color){
            Matcher matcher = pattern.matcher(s);

            if(matcher.matches()){
                System.out.println("Is Valid");
            }else{
                System.out.println("Is Invalid ");
            }


        }

    }
}
