package com.cybertek.tests.day10_FileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {

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

        driver.get("http://practice.cybertekschool.com/upload");

        // Locating choose file button

        WebElement chooseFile = driver.findElement(By.name("file"));

        //Sending file with send keys method

        String projectPath = System.getProperty("user.dir"); // Dynamic project location

        String filePath = "src/test/resources/textfile.txt"; // Copy relative path - gives file path


        String fullPath = projectPath + "/" + filePath;


        chooseFile.sendKeys(fullPath);

        //clicking upload button

        driver.findElement(By.id("file-submit")).click();

       String actualFileName = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName,"textfile.txt");














    }
}
