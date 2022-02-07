package com.cybertek.tests.day7_types_of_testing;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test

    public static void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));

        blueRadioBtn.getAttribute("value");


        // get the value of type attribute

        System.out.println(blueRadioBtn.getAttribute("type"));

        // get the value of name attribute

        System.out.println(blueRadioBtn.getAttribute("name"));


        System.out.println(blueRadioBtn.getAttribute("checked"));

        // trying to get attribute that does not exist
        // when we use non-existing attributes, it will return null to us

        System.out.println(blueRadioBtn.getAttribute("href"));

        System.out.println(blueRadioBtn.getAttribute("outerHTML")); // prints all attributes


        driver.get("http://practice.cybertekschool.com/multiple_buttons");


        WebElement button2 = driver.findElement(By.name("button2"));

        System.out.println(button2.getAttribute("outerHTML"));

        String outerHTML = button2.getAttribute("outerHTML");

        Assert.assertTrue(outerHTML.contains("button2"));



        System.out.println(button2.getAttribute("innerHTML")); // works in certain cases


        driver.quit();



    }
}
