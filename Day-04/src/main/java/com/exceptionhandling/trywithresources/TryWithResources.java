package com.exceptionhandling.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    public static void main(String[] args) {
       try(BufferedReader br = new BufferedReader(new FileReader("text.txt"))){
            String firstline = br.readLine();  //read first line
           if(firstline!=null){
               System.out.println(firstline);
           }else{
               System.out.println("file is empty");
           }

       }catch(IOException e){
           System.out.println("error reading the file");
       }


    }
}
