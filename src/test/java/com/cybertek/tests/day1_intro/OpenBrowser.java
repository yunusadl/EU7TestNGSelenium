package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class OpenBrowser {

    public static void main(String[] args) {

       // We have to enter this line every time we want to open chrome

        // Hey WebDriverManager can you please make chrome ready for me for automation?

//        WebDriverManager.chromedriver().setup();
//
//        // WebDriver represent the browser
//        // We are creating driver for chrome browser
//        // new ChromeDriver() --> this part will open chrome browser
//
//        WebDriver driver = new ChromeDriver();
//
//
//        // .get(url) used for navigation to page
//
//        driver.get("https://cydeo.com");

        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com");

      //  WebDriverManager.chromedriver().setup();

      //  WebDriver dr = new ChromeDriver();

        driver.get("https://www.facebook.com");


















        





    }
}
