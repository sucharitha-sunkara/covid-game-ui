package com.covidgame.pageobjects;

import com.covidgame.common.PageObjectBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LeaderboardPage extends PageObjectBase {

    static final Logger log = Logger.getLogger(BattleFieldPage.class);

    public String scoreXpath = "//p[@id='showData']/descendant::td[contains(text(), '<warriorname>')/ancestor::tr/td[3]]";

    public static WebDriver edriver;

    @FindBy(how = How.ID, using="leaderboard_link")
    public WebElement continueFightingButton;

    public LeaderboardPage(WebDriver driver) throws Exception {
        edriver = driver;
        PageFactory.initElements(driver,this);
        setDriver(edriver);
    }
    public int getScoreOfWarrior(String warriorName) throws Exception{
        scoreXpath.replace("<warriorname>" , warriorName);
        return(int)getText(scoreXpath);
    }


    public boolean isPageDisplayed() throws Exception {
        return isElementPresent(continueFightingButton);
    }

    public void clickOnContinueFightingButton () throws Exception{
        click(continueFightingButton);
    }



}
