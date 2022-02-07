package com.cybertek.tests.day7_types_of_testing;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Radio_Button_Test {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        // locating radio buttons

        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));

        WebElement redRadioButton = driver.findElement(By.id("red"));

        // how to check radio button is selected

        System.out.println("blueRadioButton.isSelected() = " + blueRadioButton.isSelected());

        System.out.println("redRadioButton.isSelected() = " + redRadioButton.isSelected());

        // verify blue is selected red is not selected
        //blue ---> true
        //red ---> false

        Assert.assertTrue(blueRadioButton.isSelected(), "Verify that blue is selected");
        Assert.assertFalse(redRadioButton.isSelected(), "Verify that red is  NOT selected");

        // How to click radio button

        redRadioButton.click();

        // Verify that blue is not selected and red is selected

        Assert.assertFalse(blueRadioButton.isSelected(), "Verify that blue is NOT selected");
        Assert.assertTrue(redRadioButton.isSelected(), "Verify that red is selected");





        Thread.sleep(2000);

        driver.quit();




    }
}
