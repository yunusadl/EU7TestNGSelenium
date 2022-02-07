package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider

    public Object [][] testData(){

        String[][] data = {

                {"Person of interest","10"},
                {"Sherlock","9"},
                {"Breaking Bad","9"},
                {"The Office","8"},
                {"Friends","7"},
                {"Westworld","10"},
                {"Gotham","9"}
        };


        return data;
    }


    @Test(dataProvider = "testData")

    public void test1(String tvShow, String rating){

        System.out.println("Tv show: " + tvShow + " has rating " + rating);


    }


}
