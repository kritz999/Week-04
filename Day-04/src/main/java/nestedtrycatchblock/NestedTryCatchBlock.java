package nestedtrycatchblock;

import java.util.Scanner;

public class NestedTryCatchBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] number ={10,20,30,40,50};

        System.out.println("Enter the index");
        int i = sc.nextInt();

        System.out.println("Enter the divisor");
        int divisor = sc.nextInt();

        try {
            int value = number[i];
            try {
                int result = value / divisor;
                System.out.println("result :" + result);
            } catch (ArithmeticException e) {
                System.out.println("cannot divide by zero");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("invalid array index");


        }finally{
            sc.close();
        }
    }
}
