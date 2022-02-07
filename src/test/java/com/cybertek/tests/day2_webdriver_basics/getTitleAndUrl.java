package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getTitleAndUrl {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http:/practice.cybertekschool.com"); // https does not work since it requires certification

        // getting title with selenium

        // shortcut for creating variable alt + enter

        String title = driver.getTitle();

        // soutv is shortcut for printing variable name and value

        System.out.println("title = " + title);

        // getCurrentUrl() --> get the url from browser.

        String currentUrl = driver.getCurrentUrl();

        System.out.println("currentUrl = " + currentUrl);

        //getPageSource() --> gets the source of page - source code

        String pageSource = driver.getPageSource();

        System.out.println("pageSource = " + pageSource);




    }
}
