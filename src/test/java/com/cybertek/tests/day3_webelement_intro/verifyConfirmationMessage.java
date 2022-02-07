package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {

         /*
    Verify confirmation message

        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'
     */

         // open chrome brpwser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // go to http://practice.cybertekschool.com/forgot_password

        driver.get("http://practice.cybertekschool.com/forgot_password");

        // enter any email

        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail = "mike@smith.com";

        // Send keyboard action to the web element

        emailInputBox.sendKeys("mike@smith.com");

        // Verify that email is displayed in the input box

        // two main ways to get text from web elements
        //1.getText() --> it will work %99 and it will return string
        //2.getAttribute("value") --> second way getting text especially input boxes


        String actualEmail = emailInputBox.getAttribute("value");

        System.out.println("actualEmail = " + actualEmail);


        if(expectedEmail.equals(actualEmail)){

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");


        }

        // click on retrieve password

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();

        //  verify that confirmation message says 'Your e-mail's been sent!'

        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));

        System.out.println(actualConfirmationMessage.getText());

        //save expectedMessage

        String expectedMessage = "Your e-mail's been sent!";

        String actualMessage = actualConfirmationMessage.getText();

        if(expectedEmail.equals(actualEmail)){

            System.out.println("PASS");


        }else{

            System.out.println("FAIL");
            System.out.println("expectedEmail = " + expectedEmail);
            System.out.println("actualEmail = " + actualEmail);

        }

        // close browser

        driver.close();

        










    }
}
