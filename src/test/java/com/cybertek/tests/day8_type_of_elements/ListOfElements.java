package com.cybertek.tests.day8_type_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod

    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);

        driver.quit();


    }

    @Test


    public void test1(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // save put web elements in a list


        List<WebElement> buttons = driver.findElements(By.xpath("//button"));

        System.out.println("buttons.size() = " + buttons.size());

        // verify button size

        Assert.assertEquals(buttons.size(), 6);


        //iter + enter to get for each loop

        for (WebElement button : buttons) {

            Assert.assertTrue(button.isDisplayed(), "verify buttons are displayed");



        }

        // click second button

        buttons.get(1).click();


    }

    @Test

    public void test2(){

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("buttonssadsafdf"));

        System.out.println("buttons.size() = " + buttons.size()); // Verify size all the time, since no exception would be thrown with wrong locator.




    }
}
