package com.covidgame.pageobjects;

import com.covidgame.common.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObjectBase {

    public static WebDriver edriver;

    @FindBy(how = How.ID, using = "worrior_username")
    public WebElement warrior;
    @FindBy(how = How.LINK_TEXT, using="Create warrior")
    public WebElement createWarrior;
    @FindBy(how = How.ID, using="start")
    public WebElement startJourney;


    public HomePage(WebDriver driver){
        edriver = driver;
        PageFactory.initElements(driver,this);
        setDriver(edriver);
    }

    public void startJourney(String warriorName) throws Exception {
        sendKeys(warrior, warriorName);
        createWarrior.click();
        startJourney.click();
    }

    public boolean isPageDisplayed() throws Exception {
        return isElementPresent(warrior);
    }
}
