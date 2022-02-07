package com.cybertek.tests.reviews.week05;

import com.cybertek.tests.day10_actions_js.JavaScriptExecutor;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
    http://practice.cybertekschool.com/

    - P.I.Q.: How many ways do you know to scroll using Selenium?
    1. action.moveToElement().perform()
    2. PageUp, PageDown keys for scrolling

        action.sendKeys(Keys.PAGE_UP, PAGE_DOWN)

    3. jse.executeScript("window.scrollBy(0,250)");
    4. jse.executeScript("arguments[0].scrollIntoView(true)",cybertekSchoolLink);
     */

public class ScrollingTest {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/");


    }

    @AfterMethod

    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);

        driver.quit();


    }

    @Test

    public void moveToElementTest() throws InterruptedException {

        //Scroll down to "Powered by Cybertek School"

        Actions actions = new Actions(driver);

        //Locate the element

        WebElement cyberttekSchoolLink = driver.findElement(By.linkText("Cybertek School"));

        //scrolling to that element

        Thread.sleep(2000);

        actions.moveToElement(cyberttekSchoolLink).perform();

        Thread.sleep(2000);

        //Advanced keyboard actions

        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();


        Thread.sleep(3000);



    }

    @Test

    public void scrollTestWithJSE() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // First way with JSE

        Thread.sleep(2000);

        jse.executeScript("window.scroll(0,document.body.scrollHeight)");

        Thread.sleep(2000);

        jse.executeScript("window.scroll(0,-document.body.scrollHeight)");

        Thread.sleep(2000);

        //Second way with JSE

        WebElement cyberttekSchoolLink = driver.findElement(By.linkText("Cybertek School"));

        jse.executeScript("argument[0].scrollIntoVıew(true)",cyberttekSchoolLink);






















    }





}
