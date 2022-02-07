package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass

    public void setUpClass(){

        System.out.println("---BEFORE CLASS---");

    }

    @Test

    public void test1(){


        System.out.println("First Test Case");


    }

    @Ignore

    @Test

    public void test2(){

        System.out.println("Second Test Case");
    }

    @Test

    public void test3(){

        System.out.println("Third Test Case");
        System.out.println("Executed one time before the class");
    }

    @BeforeMethod

    public void setUp(){

        System.out.println("WebDriver, Opening Browser");


    }

    @AfterMethod

    public void tearDown(){

        System.out.println("Closing Browser, Quit");

    }

    @AfterClass

    public void tearDownClass(){

        System.out.println("----AFTER CLASS---");

        System.out.println("Some reporting code here");
    }


}
