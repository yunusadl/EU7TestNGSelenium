package com.cybertek.tests.day9_popups_tabs_Iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod

    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);

        //driver.quit();


    }

    @Test

    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/iframe");

        //How to switch frames

        //1.Switch using name or ID attribute of iframe

        driver.switchTo().frame("mce_0_ifr");

        // clear before sendkeys

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");

        driver.switchTo().defaultContent(); // Goes back to first frame (main HTML)

        //2. Switch using INDEX

        driver.switchTo().frame(0);

        // clear before sendKeys

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with INDEX");

        //Second way to switch parent

        driver.switchTo().parentFrame();


        //3. Using WEBELEMENT

        WebElement iFrame = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iFrame);

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith with WebElement");



    }

    @Test

    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/nested_frames");

        // You can switch one frame at a time. First switch the frame_top

        driver.switchTo().frame("frame-top");

        //Later switch to frame_middle which is inside frame_top

        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());
        

       // driver.switchTo().frame(2); you can not switch to sibling frame


        // Go to parent frame first

        driver.switchTo().parentFrame();

        driver.switchTo().frame(0);

        Thread.sleep(1000);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        // go to main html first to switch to bottom

        driver.switchTo().defaultContent();

        //switch now to bottom frame

        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());




    }


}
