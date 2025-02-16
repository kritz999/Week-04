package com.refection.basicproblems;

import java.lang.reflect.Method;

class Calculator{
   private int multiply(int a, int b){

        return a+b;
   }

}


public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator cal = new Calculator();


        Class<?> cls = cal.getClass();

        //access private method
        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);

        int result = (int) method.invoke(cal,5,10);
        System.out.println("Addition result :"+result);

    }
}
