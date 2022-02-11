package com.cybertek.tests.HW;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeWork extends TestBase {


    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Test

    public void case1() {

        loginPage.loginAsStoreManager();
        dashBoardPage.navigateToModule("Activities", "Calendar Events");

        Assert.assertTrue(calendarEventsPage.optionsSubtitle.isDisplayed());
        Assert.assertEquals(calendarEventsPage.optionsSubtitle.getText(), "Options");


    }

    @Test

    public void case2() {

        loginPage.loginAsStoreManager();

        dashBoardPage.navigateToModule("Activities", "Calendar Events");

        Assert.assertEquals(calendarEventsPage.pageNumberInput.getAttribute("value"), "1");


    }

    @Test

    public void case3() {

        loginPage.loginAsStoreManager();

        dashBoardPage.navigateToModule("Activities", "Calendar Events");

        dashBoardPage.waitUntilLoaderScreenDisappear();

        System.out.println(calendarEventsPage.viewPerPageDropDown.getText());

        Assert.assertEquals(calendarEventsPage.viewPerPageDropDown.getText(), "25");


    }

    @Test

    public void case4() {

        loginPage.loginAsStoreManager();

        dashBoardPage.navigateToModule("Activities", "Calendar Events");

        calendarEventsPage.waitUntilLoaderScreenDisappear();


        Assert.assertEquals(calendarEventsPage.getRowNumber(),calendarEventsPage.recordNumber);







    }





}
