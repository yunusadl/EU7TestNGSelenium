package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // make browser fullscreen

        driver.manage().window().maximize(); // fullscreen() does not work for mac, just use maximize()


        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.name("full_name"));

        fullNameInputBox.sendKeys("John Harris");


        // put some email and click sign up button

        // proper way

        WebElement emailInputBox = driver.findElement(By.name("email"));

        emailInputBox.sendKeys("johnharris@abc.com");



        // lazy way

        driver.findElement(By.name("email")).sendKeys("mike@smith.com");




        WebElement signUpButton = driver.findElement(By.name("wooden_spoon"));

        signUpButton.click();






    }
}
