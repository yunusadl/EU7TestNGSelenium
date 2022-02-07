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

public class NoSelectDropdown {


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

        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));

        //click to see available options

        dropDownElement.click();

        List<WebElement> dropDownOptions = driver.findElements(By.className("dropdown-item"));

        // print ize of options

        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());
        Assert.assertEquals(dropDownOptions.size(),5,"Verify size of options");


        //print the one by one

        for (WebElement dropDownOption : dropDownOptions) {

            System.out.println(dropDownOption.getText());
        }

        //click yahoo

        dropDownOptions.get(2).click();






    }


}
