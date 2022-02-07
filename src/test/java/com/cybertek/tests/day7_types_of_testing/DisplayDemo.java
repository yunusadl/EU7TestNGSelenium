package com.cybertek.tests.day7_types_of_testing;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayDemo {

    @Test

    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.cssSelector("#username"));

        System.out.println("usernameInput.isDisplayed() = " + usernameInput.isDisplayed());

        // verify username inputBox is not displayed on the screen
        // click start button
        //verify username displayed on the screen


        Assert.assertFalse(usernameInput.isDisplayed(), "Verify username input box is NOT displayed");


        WebElement startButton = driver.findElement(By.xpath("//button[.='Start']"));

        startButton.click();

        // Wait until elements displayed

        Thread.sleep(6000);

        Assert.assertTrue(usernameInput.isDisplayed(), "Verify username inputbox is displayed");











    }
}
