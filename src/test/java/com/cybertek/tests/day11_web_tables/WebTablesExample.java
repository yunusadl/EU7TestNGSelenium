package com.cybertek.tests.day11_web_tables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/tables");




    }

    @AfterMethod

    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);

        driver.quit();


    }

    @Test

    public void printTable(){

        WebElement table = driver.findElement(By.id("table1"));

        System.out.println(table.getText());

        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));




    }

    @Test

    public void getAllHeaders(){

        //How many columns we have?

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {

            System.out.println(header.getText());
        }


    }

    @Test

    public void printTableSize(){

        //How many columns we have?


        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        System.out.println("headers.size() = " + headers.size());


        //Number of rows

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));

        System.out.println("allRows.size() = " + allRows.size());


        //Number of rows without headers (We prefer this)

        List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));

        System.out.println("allRowsWithoutHeaders.size() = " + allRowsWithoutHeaders.size());


    }

    @Test

    public void getRow(){

        //print the second row information

        List<WebElement> secondRowElements = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr[2]//td"));

        for (WebElement secondRowElement : secondRowElements) {

            System.out.println(secondRowElement.getText());
        }



        WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[2]"));

        System.out.println("row2.getText() = " + row2.getText());



        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));

        for (int i = 1; i <=rows.size(); i++) {

            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr["+i+"]"));

            System.out.println(i + "-" + row.getText());


        }





    }

    @Test

    public void getAllCellInOneRow(){



        List<WebElement> allCellsinOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr[1]//td"));


        for (WebElement eachCell : allCellsinOneRow) {

            System.out.println(eachCell.getText());


        }





    }

    @Test

    public void getAsingleCellByIndex(){

        WebElement singleCell = driver.findElement(By.xpath("//table[@id='table1']//tr[3]/td[5]"));

        System.out.println(singleCell.getText());





    }

    @Test

    public void printAllCellsByIndex(){

        int rowNumber = getNumberOfRows();
        int columnNumber = getNumberOfColumn();

        for (int i = 1; i<= rowNumber; i++){

            for (int j = 1; j<= columnNumber; j++){

                String cellXpath = "//table[@id='table1']//tr["+i+"]/td["+j+"]";

                WebElement eachCell = driver.findElement(By.xpath(cellXpath));

                System.out.println(eachCell.getText());


            }
        }








    }

    private int getNumberOfColumn() {

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        return headers.size();
    }

    private int getNumberOfRows() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody//tr"));


        return rows.size();
    }

    @Test

    public void getCellInRelationToAnotherCell(){ //************IMPORTANT CONCEPT********************

        String firstName = "Jason";

        String xPath = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";

        WebElement email = driver.findElement(By.xpath(xPath));

        System.out.println(email.getText());

    }


}
