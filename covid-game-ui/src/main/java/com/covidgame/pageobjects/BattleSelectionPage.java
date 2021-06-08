package com.covidgame.pageobjects;

import com.covidgame.common.PageObjectBase;
import com.covidgame.utils.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BattleSelectionPage extends PageObjectBase {

    public static WebDriver edriver;

    @FindBy(how = How.XPATH, using = "//button[text()='Start']")
    public WebElement startBattle;

    String selectBattlefieldXpath = "//a[contains(text(), '<battleName>')]";

    @FindBy(how = How.ID, using ="welcome_text")
    public WebElement chooseBattlePage;


    public BattleSelectionPage(WebDriver driver){
        edriver = driver;
        PageFactory.initElements(driver,this);
        setDriver(edriver);
    }

    public boolean isPageDisplayed() throws Exception{
        return isElementPresent(chooseBattlePage);
    }

    public void selectBattle(String battleName) throws Exception{
        waitUntilElementIsVisible(chooseBattlePage);
        click(selectBattlefieldXpath.replace("<battleName>",battleName));
        click(startBattle);
    }




}
