package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage {

    //Since we are extending basepage we do not need explicit constructor for this class

 //   @FindBy(xpath = "//td[contains(.,'mbrackstone9@example.com')][@data-column-label='Email']")

  //  public WebElement emailCell;




    public WebElement getContactEmail(String email){

        String xPath = "//td[contains(.,'" +email+ "')][@data-column-label='Email']";

        return Driver.get().findElement(By.xpath(xPath));

    }


}
