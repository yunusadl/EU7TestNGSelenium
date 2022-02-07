package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {


    @Test

    public void loginAsDriver(){

        LoginPage loginPage = new LoginPage();

        String userName = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(userName);
        loginPage.passwordInput.sendKeys(password);

        loginPage.loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }

    @Test

    public void loginAsStoreManager(){

        LoginPage loginPage = new LoginPage();

        String userName = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        loginPage.login(userName,password);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");



    }


    @Test

    public void loginAsStoreManager2(){

        LoginPage loginPage = new LoginPage();


        loginPage.loginAsStoreManager();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");



    }




}
