package com.cybertek.tests.day10_FileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {

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

    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        Actions actions = new Actions(driver);

        Thread.sleep(2000);

        actions.moveToElement(img1).perform();


        WebElement text = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(text.isDisplayed(),"verify text 1 is displayed");

       // Assert.assertEquals(text.isDisplayed(),true); // another approach




    }

    /*
    hover over each image in the website
    verify each name: user text is displayed
     */

    @Test

    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i <= 3; i++) {

            String xpathImage = "(//img)["+i+"]";

            WebElement img  = driver.findElement(By.xpath(xpathImage));

            Actions actions = new Actions(driver);

            Thread.sleep(2000);

            actions.moveToElement(img).perform();

            String textXpath = "//h5[.='name: user"+i+"']";


            WebElement text = driver.findElement(By.xpath(textXpath));

            Assert.assertTrue(text.isDisplayed(),"verify text "+i+" is displayed");




        }








    }



}
