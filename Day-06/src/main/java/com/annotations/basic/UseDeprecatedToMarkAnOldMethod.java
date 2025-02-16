package com.annotations.basic;

 class LegacyAPI{
     @Deprecated
    void oldFeature(){

         System.out.println("old feature");

        }

    void newFeature(){

        System.out.println("new feature");
        }

}

public class UseDeprecatedToMarkAnOldMethod {
    public static void main(String[] args) {

        LegacyAPI l1 = new LegacyAPI();
        l1.oldFeature();
        l1.newFeature();
    }

}
