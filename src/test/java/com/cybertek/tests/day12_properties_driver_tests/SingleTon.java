package com.cybertek.tests.day12_properties_driver_tests;

public class SingleTon {

    //singleton class will have private constuctor
    // Other classes can not create object of this class

    private SingleTon(){

    }

    private static String str;

    public static String getInstance(){

        //if str has no value, initialize it and return it

        if(str==null){

            System.out.println("str is null, assigning value");
            str ="somevalue";

        }else {

            System.out.println("it has value just returning it");
        }

        return str;
    }


}
