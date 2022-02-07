package com.cybertek.tests.day9_popups_tabs_Iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpsAndAlerts {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod

    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);

       // driver.quit();


    }

    @Test

    public void test1(){

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=6a7fb");

        // Click confirm button

        WebElement confirmButton = driver.findElement(By.xpath("//button[.='Confirm']")); // Use either span or button


        confirmButton.click();

        // Click no button

        WebElement noButton = driver.findElement(By.xpath("//span[.='No']"));

        noButton.click();




    }

    @Test


    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        // click Click for JS Alert Button

        driver.findElement(By.xpath("//button[1]")).click();



        // swwitch to JS alert pop up


        Alert alert = driver.switchTo().alert();

        Thread.sleep(2000);

        alert.accept();

        // click for JS Confirm

        driver.findElement(By.xpath("//button[2]")).click();

        Thread.sleep(2000);

        alert.dismiss();

        // click for JS Prompt

        driver.findElement(By.xpath("//button[3]")).click();

        Thread.sleep(2000);

        // Send keys to JS Prompt

        alert.sendKeys("MikeSmith");

        System.out.println(alert.getText());


        // click OK

        alert.accept();

















    }

}
