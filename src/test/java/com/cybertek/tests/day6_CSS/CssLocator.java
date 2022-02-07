package com.cybertek.tests.day6_CSS;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        Thread.sleep(2000);

        WebElement dontClickButton = driver.findElement(By.cssSelector("button#disappearing_button"));

        System.out.println(dontClickButton.getText());

        driver.quit();


    }
}
