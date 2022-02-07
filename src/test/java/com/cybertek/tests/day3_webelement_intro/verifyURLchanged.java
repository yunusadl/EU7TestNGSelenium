package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {

    public static void main(String[] args) throws InterruptedException {

         /* Verify URL changed


        - open chrome browser
        - go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        - enter any email
        - click on Retrieve password
        - verify that url changed to http://practice.cybertekschool.com/email_sent
         */




         //  open chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // go to http://practice.cybertekschool.com/forgot_password

        driver.get("http://practice.cybertekschool.com/forgot_password");

        // enter any email

        WebElement emailInputBox = driver.findElement(By.name("email"));

        // sendKeys() --> send keyboard action to web element

        emailInputBox.sendKeys("mike@cybertek.com");

        // click on retrieve password password

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();



        // verify that url changed to http://practice.cybertekschool.com/email_sent
        // create expectedUrl

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        // save actual url after entering email and clicking retrieve password button

        String actualUrl= driver.getCurrentUrl();



        if(expectedUrl.equals(actualUrl)){

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedUrl);
            System.out.println("actualUrl = " + actualUrl);

        }

        // Close the browser

        driver.quit();































    }
}
