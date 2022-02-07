package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.get(),this);


    }


    //@FindBy represents findElement method, selenium annotation

    //driver.findElement(By.id=("prependedInput"));

    @FindAll({@FindBy(id = "prependedInput"),

            @FindBy(name = "_username")})

    public WebElement usernameInput;


    @FindBy(id = "prependedInput2")

    public WebElement passwordInput;

    @FindBy(id = "_submit")

    public WebElement loginButton;


   // @FindBy(css = ".btn.btn-primary")

   // public List<WebElement> buttons; //Web elements are stored in List.



    public void login(String username,String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();


    }

    public void loginAsDriver(){

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();


    }





}
