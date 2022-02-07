package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test

    public void wrongPasswordTest(){

        //Name of the test

        extentLogger = report.createTest("Wrong Password Test");


        LoginPage loginPage = new LoginPage();


        extentLogger.info("Enter username: user1");

        loginPage.usernameInput.sendKeys("user1");



        extentLogger.info("Enter password: somepassword");

        loginPage.passwordInput.sendKeys("somepassword");


        extentLogger.info("Click login page");

        loginPage.loginButton.click();







      /*  driver.findElement(By.id("prependedInput")).sendKeys("user1");

        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");

        driver.findElement(By.id("_submit")).click(); */




        extentLogger.info("Verify page URL ");


        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");


        extentLogger.pass("Wrong password Test is passed");


    }


    @Test

    public void wrongUserNameTest(){

        extentLogger = report.createTest("Wrong UserName Test");


        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: someuser");

        loginPage.usernameInput.sendKeys("someuser");

        extentLogger.info("Enter password: UserUser123");

        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("Click on login");
        loginPage.loginButton.click();

        extentLogger.info("Verify page URL");

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("PASSED");


    }


}
