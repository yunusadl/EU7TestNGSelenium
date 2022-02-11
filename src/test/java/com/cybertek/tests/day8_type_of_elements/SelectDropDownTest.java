package com.cybertek.tests.day8_type_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {

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

    public void test1(){

        driver.get("http://practice.cybertekschool.com/dropdown");

        // Locate your web element just like any other web element with unique locators

        WebElement dropDownElement = driver.findElement(By.id("state"));

        // A special class for drop-downs, Select class.

        // create select object by passing that element to constructor

        Select stateDropDown = new Select(dropDownElement);

        List<WebElement> options = stateDropDown.getOptions(); // returns a list

        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {

            System.out.println(option.getText());

        }


    }

    @Test

    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");


        // Locate your web element just like any other web element with unique locators

        WebElement dropDownElement = driver.findElement(By.id("state"));

        // A special class for drop-downs, Select class.

        // create select object by passing that element to constructor

        Select stateDropDown = new Select(dropDownElement);

        // verify that first selection is Select a state

        String expectedOption = "Select a State";

        String actualOption = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        //HOW TO SELECT OPTIONS FROM DROPDOWN

        //1. SELECT USING VISIBLE TEXT

        stateDropDown.selectByVisibleText("Virginia");

        expectedOption = "Virginia";
        actualOption = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        //2.SELECT USING INDEX

        Thread.sleep(2000);

        stateDropDown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption, "verify first selection");

        // 3. SELECT BY VALUE

        Thread.sleep(2000);

        stateDropDown.selectByValue("VA");

        expectedOption = "Virginia";
        actualOption = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOption,expectedOption, "verify first selection");






















    }

}
