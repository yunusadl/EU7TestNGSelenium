package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@class='btn-group actions-group']/div[@class='btn btn-link dropdown-toggle']")

    public WebElement optionsSubtitle;

    @FindBy(xpath = "//li/input[@type='number']")

    public WebElement pageNumberInput;

    @FindBy(css = "div[class='btn-group']>button[data-toggle='dropdown']")

    public WebElement viewPerPageDropDown;



    @FindBy(xpath = "//Tbody//tr")

    List<WebElement> rowElements;

    @FindBy(xpath = "//div[@class='pagination pagination-centered']/label[3]")

    public WebElement recordNumberTextElement;

    @FindBy(xpath = "//div[@class='pagination pagination-centered']/label[2]")

    public WebElement totalPages;

    public int recordNumber = Integer.parseInt(recordNumberTextElement.getText().split("of ")[1].split(" ")[0]);




    public int getRowNumber(){

        int numberOfPages = Integer.parseInt(totalPages.getText().split("of ")[1]);


        int rowNumber = 0;

        while (Integer.parseInt(pageNumberInput.getAttribute("value"))<= numberOfPages){

            int size = Driver.get().findElements(By.xpath("//Tbody//tr")).size();


            rowNumber+=size;
        }

        return rowNumber;


    }
















}