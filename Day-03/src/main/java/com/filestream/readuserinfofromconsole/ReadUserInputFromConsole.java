package com.filestream.readuserinfofromconsole;
import java.io.*;

public class ReadUserInputFromConsole {
    public static void main(String[] args) throws IOException {

       try( BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("user_info.txt")){


           System.out.println("Enter your name");
           String name = br.readLine();

           System.out.println("Enter your age");
           String age = br.readLine();


           System.out.println("Enter your favorite programming language");
           String lang = br.readLine();


           fw.write("User name is :"+name+"\n");
           fw.write("User age is :"+age+"\n");
           fw.write("Users favorite programming language :"+ lang+"\n");




       }catch(IOException e){
           e.printStackTrace();
       }




    }
}
