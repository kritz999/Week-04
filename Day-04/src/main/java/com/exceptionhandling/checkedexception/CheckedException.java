package com.exceptionhandling.checkedexception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {


    public static void main(String[] args) {
        String fileName = "dat.txt";
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            //readLine() will reads entire lines instead of character by character
            while((line= br.readLine())!=null){
                System.out.println(line);
            }
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }catch(IOException e){
            System.out.println("while reading a file an error occurred ");
        }
    }
}
