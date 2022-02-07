package com.cybertek.tests.day9_popups_tabs_Iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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

    public void switchWindowsTest(){

        driver.get("http://practice.cybertekschool.com/windows");

        // get title

        System.out.println("Title before new window: " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();


        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();



        for (String windowHandle : windowHandles) {

            if(!windowHandle.equals(currentWindowHandle)){

                driver.switchTo().window(windowHandle);
            }

        }

        System.out.println("Title after new window: " + driver.getTitle());

    }

    @Test

    public void moreThanTwoWindows(){

        driver.get("http://practice.cybertekschool.com/windows");



        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("Title before switch" + driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

        //Loop through each window

        for (String windowHandle : windowHandles) {

            //one by one switch

            driver.switchTo().window(windowHandle);

            // whenever your title is equal your expected window title

            if(driver.getTitle().equals("New Window")){

                // stop execution

                break;
            }


        }

        System.out.println("After switch: " + driver.getTitle());


    }
}
