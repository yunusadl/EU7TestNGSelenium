package com.cybertek.tests.reviews.week05;

/*
        v.Test application www.IonicPartners.com:
        vi. Test 1: Go to <Blog> page and scroll it down
        vii. Test 2: Go to <About> page, scroll it down and click on Twitter icon at the bottom of the page

 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class HomeWork {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/");


    }

    @AfterMethod

    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);

        driver.quit();


    }


    public void test01(){


    }



}
