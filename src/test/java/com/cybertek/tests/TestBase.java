package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

   protected WebDriver driver;

   protected Actions actions;

   protected WebDriverWait wait;

    // This class is used for starting and building reports

    protected ExtentReports report;

    //This class is used to create HTML report file
    protected ExtentHtmlReporter htmlReporter;

    //this will define a test, eneable adding logs, authors, test steps

   protected  ExtentTest extentLogger;

   @BeforeTest

   public void SetUpTest(){

       //initialize the class

       report = new ExtentReports();

       //create a report path

       //Project path

       System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));

       String projectPath = System.getProperty("user.dir");


       String filePath = "/test-output/report.html";

       String path = projectPath + filePath;


       // initialize the html reporter

       htmlReporter = new ExtentHtmlReporter(path);

       // attach the html report to report object

       report.attachReporter(htmlReporter);


       //title in report


       htmlReporter.config().setReportName("Vytrack Smoke Test");

       // set environment information

       report.setSystemInfo("Environment","QA");

       report.setSystemInfo("Browser", ConfigurationReader.get("browser"));

       report.setSystemInfo("OS",System.getProperty("os.name"));


   }

    @BeforeMethod

    public void setup(){

        driver = Driver.get();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        actions = new Actions(driver);

        wait = new WebDriverWait(driver,10);

        driver.get(ConfigurationReader.get("url"));




    }

    //ITestResult class describes the result of a test in TestNG

    @AfterMethod

    public void tearDown(ITestResult result) throws InterruptedException, IOException {

       //if test fails

        if (result.getStatus() == ITestResult.FAILURE){

            //Record the name of failed testcase

            extentLogger.fail(result.getName());

            //take screenshot and return location of screenshot

            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report

            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture exception and put inside report

            extentLogger.fail(result.getThrowable());



        }



        Driver.closeDriver();

    }

    @AfterTest

    public void tearDownTest(){

        //this is when report is actual created

        report.flush();


    }
}
