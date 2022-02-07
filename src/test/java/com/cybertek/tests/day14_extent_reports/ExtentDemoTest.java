package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    // This class is used for starting and building reports

    ExtentReports report;

    //This class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    //this will define a test, eneable adding logs, authors, test steps

    ExtentTest extentLogger;

    @BeforeMethod

    public void setUp(){

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

    @Test

    public void test1(){

        extentLogger = report.createTest("TC123 Login as Driver Test");

        //test steps

        extentLogger.info("Open chrome browser");

        extentLogger.info("Go to this URL");


        extentLogger.info("Enter driver username password");

        extentLogger.info("Click login");

        extentLogger.info("Verify logged in");


        //pass()--> marks the test case as passed

        extentLogger.pass("TC123 is passed");





    }

    @AfterMethod

    public void tearDown(){

        //this is when report is actual created

        report.flush();
    }



}
