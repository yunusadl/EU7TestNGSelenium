package com.cybertek.tests.reviews.week02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorHWTest {

    public static void main(String[] args) throws InterruptedException {

        // Go to eBay
        // search Selenium
        // click on search button
        // print number of results
        // verify title contains selenium



        // open an empty browser


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");

        WebElement searchBox = driver.findElement(By.id("gh-ac"));

        String expectedSearchItem = "Selenium";

        searchBox.sendKeys(expectedSearchItem);

        WebElement searchButton = driver.findElement(By.id("gh-btn"));

        searchButton.click();

        WebElement searchResult = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")); // You can use class even with spaces with xpath.

        String result = searchResult.getText();

        String title = driver.getTitle();

        String numberOfResults = result.split(" result")[0];

        System.out.println(numberOfResults);

        if(title.contains("selenium")){

            System.out.println("PASS");
        } else {

            System.out.println("FAIL");
        }





        Thread.sleep(2000);

        driver.close();















    }
}
