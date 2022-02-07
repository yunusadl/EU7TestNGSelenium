package com.cybertek.tests.reviews.week01;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class t02_CybertekUrlTask {
    public static void main(String[] args) {

       WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http:practice.cybertekschool.com");

        // I want to maximize page, Sometimes selenium can not find elements without maximization

        driver.manage().window().maximize();

        String expectedUrlText = "cybertekschool";

        String actualUrl = driver.getCurrentUrl();


        System.out.println("Verify if the URL contains \"cybertekschool\" : " + actualUrl.contains(expectedUrlText));

        System.out.println("Verify : " + driver.getTitle().equalsIgnoreCase("Practice"));







        driver.close();
    }
}
