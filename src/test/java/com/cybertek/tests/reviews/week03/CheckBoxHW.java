package com.cybertek.tests.reviews.week03;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class CheckBoxHW {

    WebDriver driver;

    /*

    Test Case Verify CheckBox CheckAll and UncheckAll Buttons
1.    Go to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
2.    Login with-----Username: Tester, password: test

         // Test Case 1
3.    Click on check all button verify all the checkboxes are checked
4.    Click on uncheck all button verify that all the checkboxes are unchecked

        // Test Case 2
5.    Select one of the checkbox and delete one person
6.    Then verify that deleted item is no longer exists

         // What is the precondition? ----> Login to webpage.

     */


    @BeforeMethod

    public void openPage(){

        driver = WebDriverFactory.getDriver("chrome"); // initialize our driver object.

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();

        // Login to webpage

        WebElement userNameBox = driver.findElement(By.id("ctl00_MainContent_username"));

        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));

        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));


        userNameBox.sendKeys("Tester");
        passwordBox.sendKeys("test");

        loginButton.click();


    }

    @Test (priority = 2)

    public void checkBoxAll(){

        WebElement checkAllButton = driver.findElement(By.linkText("Check All"));


        checkAllButton.click();

        //(//input[@type='checkbox'])[1] for the first one
        //(//input[@type='checkbox'])[2] for the second one

        for (int i = 1; i <= 8; i++) {

            String row = "(//input[@type='checkbox'])["+i+"]";

            Assert.assertTrue(driver.findElement(By.xpath(row)).isSelected(), "Checkbox is not selected");


        }


        WebElement uncheckAllButton = driver.findElement(By.linkText("Uncheck All"));

        uncheckAllButton.click();

        for (int i = 1; i <= 8; i++) {

            String row = "(//input[@type='checkbox'])["+i+"]";

            Assert.assertFalse(driver.findElement(By.xpath(row)).isSelected(), "Checkbox is selected");


        }






    }

    @Test (priority = 1)

    public void deletePersonTest(){

        String name = "Steve Johns"; // If i change the test should still work

        //Locator for person name cell: // //*[contains(text(),'Steve Johns')]
        //locator for checkbox of the person that I want to choose

        String locatorCheckBoxOfPerson = "//*[contains(text(),'"+name+"')]/preceding-sibling::*/input";

        WebElement checkBoxOfPerson = driver.findElement(By.xpath("//*[contains(text(),'Steve Johns')]/preceding-sibling::*/input"));

        checkBoxOfPerson.click();

        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));

        deleteButton.click();

        // After I delete, I will get all the names and put them in an arrayList then verify that deleted person is not in the list

        ArrayList<String> names = new ArrayList<>();


        for (int i = 1; i <=7; i++) {

            String eachNameLocator = "(//input[@type='checkbox'])["+i+"]/../../td[2]";

            WebElement eachNameElement = driver.findElement(By.xpath(eachNameLocator));

            String eachName = eachNameElement.getText();

            names.add(eachName);

        }

        Assert.assertFalse(names.contains(name), name+" is still in the list");








    }

    @AfterMethod

    public void closeBrowser(){

        driver.close();
    }







}
