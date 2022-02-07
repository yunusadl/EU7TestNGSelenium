package com.cybertek.tests.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/index.html");

        WebElement laptopsLink = driver.findElement(By.linkText("Laptops"));

        laptopsLink.click();

        Thread.sleep(2000);

        WebElement sonyVaioI7 = driver.findElement(By.partialLinkText("Sony vaio i7")); // One space might cause problem

        sonyVaioI7.click();

        Thread.sleep(2000);

        WebElement priceText = driver.findElement(By.xpath("//h3[@class='price-container']"));

        String priceLabel = priceText.getText();

        System.out.println(priceLabel);

        String expectedPrice = "790";
        String actualPrice = priceLabel.split(" ")[0].substring(1);





        if (actualPrice.equals(expectedPrice)){

            System.out.println("PASS");
        } else {

            System.out.println("FAIL");
        }

        driver.quit();











    }
}
