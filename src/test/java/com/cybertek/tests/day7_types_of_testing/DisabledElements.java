package com.cybertek.tests.day7_types_of_testing;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test

    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenButton = driver.findElement(By.id("green"));

        // how to check any web element is enabled or not?

        greenButton.click();


        System.out.println("greenButton.isEnabled() = " + greenButton.isEnabled());

        Assert.assertFalse(greenButton.isEnabled(), "Verify green radio button is NOT enabled(disabled)");


        greenButton.click();




    }

    @Test

    public void test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement enableDisableInputBox = driver.findElement(By.cssSelector("#input-example>input"));

        // Verify the inputBox is disabled

        Assert.assertFalse(enableDisableInputBox.isEnabled());





    }
}
