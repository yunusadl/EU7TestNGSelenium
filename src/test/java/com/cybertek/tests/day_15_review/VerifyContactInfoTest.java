package com.cybertek.tests.day_15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {

    /*
    Open the chrome
    login as a sales manager
    navigate to customers --> contacts
    click on email mbrackstone9@example.com
    verify that full name is Mariam Brackstone
    verify that email is mbrackstone9@example.com
    verify that phone number is +18982323434

     */


    @Test

    public void contactDetailsTest(){

        extentLogger = report.createTest("Contact Info Verification");



        LoginPage loginPage = new LoginPage();


        String userName = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        extentLogger.info("username: " + userName);
        extentLogger.info("password: " +password);
        extentLogger.info("Login as a sales manager");

        loginPage.login(userName,password);

        extentLogger.info("Navigate to Customers-->Contacts");


        new DashBoardPage().navigateToModule("Customers","Contacts");


        ContactsPage contactsPage = new ContactsPage();

        contactsPage.waitUntilLoaderScreenDisappear();

        extentLogger.info("Click on email mbrackstone9@example.com");

        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();


        String expectedName = "Mariam Brackstone";
        String expectedPhone = "+18982323434";
        String expectedEmail = "mbrackstone9@example.com";


        contactInfoPage.waitUntilLoaderScreenDisappear();



        extentLogger.info("Verify fullname: " + expectedName);

        Assert.assertEquals(contactInfoPage.fullname.getText(),expectedName,"Verify username");


        extentLogger.info("Verify Phone: " + expectedPhone);


        Assert.assertEquals(contactInfoPage.phone.getText(),expectedPhone,"Verify phone number");


        extentLogger.info("Verify email :" + expectedEmail);


        Assert.assertEquals(contactInfoPage.email.getText(),expectedEmail,"Verify email");


        extentLogger.pass("PASSED");




























    }


}
