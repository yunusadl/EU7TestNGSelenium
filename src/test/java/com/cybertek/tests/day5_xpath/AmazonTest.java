package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    /*

    TASK

    go to amazon.com

    search for selenium

    click search button

    verify 1-48 of 304 results for selenium

    // NOT A GOOD TEST CASE



     */


    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        searchBox.sendKeys("selenium");

        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));

        searchButton.click();

        WebElement searchResultText = driver.findElement(By.xpath("//span[contains(text(), 'results for')]"));

        String searchResult = searchResultText.getText();

        System.out.println("searchResult = " + searchResult);

        String expectedResult = "1-48 of over 330 results for";

        if(searchResult.equals(expectedResult)){

            System.out.println("PASS");
        } else {

            System.out.println("FAIL");
        }

        driver.quit();



    }
}
