package com.regex.basicregexproblem;
import java.util.regex.*;
public class ValidateALicensePlateNumber {

    public static void main(String[] args) {

        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        String[] plateNumber = { "AB1234","A12345"};

        for(String platenum : plateNumber){

            Matcher matcher = pattern.matcher(platenum);
            if(matcher.matches()){
                System.out.println(platenum+" is valid ");
            }else{
                System.out.println(platenum+ " not valid ");
            }
        }
    }
}
