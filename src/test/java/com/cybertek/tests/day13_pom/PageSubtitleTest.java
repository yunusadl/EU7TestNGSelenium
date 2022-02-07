package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {


    /*
    Test case
    open browser
    login as Driver
    Verify that page subtitle is Quick LaunchPad
    Go to activities -> calendar events
    verify that page subtitle is Calendar events

     */

    @Test

    public void test1(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        String expectedSubTitle = "Quick Launchpad";

        DashBoardPage dashBoard = new DashBoardPage();

        String actualSubTitle = dashBoard.getPageSubTitle();

        Assert.assertEquals(actualSubTitle,expectedSubTitle,"Verify Subtitle");

        dashBoard.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        Assert.assertEquals( calendarEventsPage.getPageSubTitle(), "Calendar Events","Verify subtitle Calendar Events");





    }
}
