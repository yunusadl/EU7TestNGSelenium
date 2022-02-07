package com.cybertek.tests.reviews.week01;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class t01_YahooPractice {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://www.yahoo.com");

        if (driver.getTitle().toLowerCase().contains("yahoo")) {

            System.out.println("Verified");
        } else {

            System.out.println("Not Verfied");
        }

        driver.close();


    }
}
