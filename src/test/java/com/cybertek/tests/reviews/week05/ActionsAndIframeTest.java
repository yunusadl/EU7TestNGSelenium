package com.cybertek.tests.reviews.week05;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
 Actions and Iframe Example
 1. Go to [https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2](https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2)
 2. Switch to iframe.
 3. Double click on the text “Double-click me to change my text color.”
 4. Assert: Text’s “style” attribute value contains “red”.
 */

public class ActionsAndIframeTest {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");


    }

    @AfterMethod

    public void tearDown() throws InterruptedException {

        //Thread.sleep(2000);

       // driver.quit();


    }

    @Test

    public void Test() throws InterruptedException {

        //Switch to iframe

        WebElement frameElement = driver.findElement(By.id("iframeResult"));

        driver.switchTo().frame(frameElement);

        WebElement textToDoubleClick = driver.findElement(By.id("demo"));

        //For double click, we need actions object

        Actions actions = new Actions(driver);

        actions.doubleClick().perform();

        Thread.sleep(2000);

        //Assert: text's "style" attribute value contains "red";


    }



}
