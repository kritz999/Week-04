package com.regex.extractionproblems;

import java.util.ArrayList;
import java.util.List;

public class CensorBadWordsInASentence {


    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";

        String [] badwords ={"damn","stupid"};

        String regex = "";

        for(String word : badwords){
            text = text.replaceAll("(?i)\\b"+word+"\\b","*****");
        }
        System.out.println(text);

    }
}
