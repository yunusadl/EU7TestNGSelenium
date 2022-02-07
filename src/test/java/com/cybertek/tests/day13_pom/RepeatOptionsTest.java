package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {

    /*

    open browser
    Login as driver
    Go to activities -> Calendar events
    Click on create calendar events
    Click on repeat
    Verify that repeat everyday is checked
    Verify that repeat weekday is not checked

     */

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();




    @Test

    public void test1(){

        //    Login as driver


        loginPage.loginAsDriver();


       // Go to activities -> Calendar events


        dashBoardPage.navigateToModule("Activities","Calendar Events");



        // Click on create calendar events

        // wait for loader mask


        calendarEventsPage.waitUntilLoaderScreenDisappear();


        calendarEventsPage.createCalendarEvent.click();


        // Click on repeat

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();



        createCalendarEventsPage.repeat.click();


        //    Verify that repeat everyday is checked


        Assert.assertTrue(createCalendarEventsPage.days.isSelected());

        //     Verify that repeat weekday is not checked


        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected());














    }


     /*

        VERIFY REPEAT OPTIONS

        Login as driver
        go to Activities-> Calendar Events
        Click on create calendar events button
        Click on repeat checkbox
        Verify that repeat options are Daily,Weekly,Monthly, Yearly (in this order)



         */


     @Test

    public void test2(){

         //        Login as driver

         loginPage.loginAsDriver();

         //        go to Activities-> Calendar Events

         dashBoardPage.navigateToModule("Activities","Calendar Events");

         calendarEventsPage.waitUntilLoaderScreenDisappear();

         //        Click on create calendar events button

         calendarEventsPage.createCalendarEvent.click();

         //        Click on repeat checkbox

         createCalendarEventsPage.repeat.click();

         Select repeatsDropDown = createCalendarEventsPage.repeatOptionsList();

         //        Verify that repeat options are Daily,Weekly,Monthly, Yearly (in this order)

         List<String> expectedList  = Arrays.asList("Daily","Weekly","Monthly","Yearly");

         List<String> actualList = new ArrayList<>();


         List<WebElement> actualOptions = repeatsDropDown.getOptions();


         for(WebElement options: actualOptions){

            actualList.add(options.getText());


         }

         //ready method for getting text of web elements.

         List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);




         Assert.assertEquals(actualList,expectedList);




     }

}
