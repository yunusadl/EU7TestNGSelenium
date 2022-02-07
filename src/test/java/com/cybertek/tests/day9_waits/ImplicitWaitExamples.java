package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExamples {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod

    public void tearDown() throws InterruptedException {

       // Thread.sleep(2000);

        driver.quit();


    }

    @Test

    public void test1() throws InterruptedException {

       // driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

       // WebElement element = driver.findElement(By.cssSelector("#username"));

        // An element that is hidden and not part of html are two different things, second one gives no such element exception

       // element.sendKeys("Ciguli"); // Element not interactable exception


        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        // This is not line specific wait, it sets up find element method to wait up to set time and keep checking.
        // We could as well put this line in beforeMethod. Once you set it, it is valid for every time we use findElement
        //This waits for elements to be found in HTML. Waits only until element is located.



        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



        WebElement element = driver.findElement(By.cssSelector("#finish"));


        System.out.println(element.getText());












    }


}
