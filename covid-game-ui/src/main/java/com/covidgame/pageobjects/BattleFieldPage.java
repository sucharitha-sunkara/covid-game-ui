package com.covidgame.pageobjects;

import com.covidgame.utils.Constant;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.covidgame.common.PageObjectBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BattleFieldPage extends PageObjectBase {

    static final Logger log = Logger.getLogger(BattleFieldPage.class);
    public static WebDriver edriver;
    public String battleName;

   //BattleField Pages
    @FindBy(how = How.ID, using="bus_title")
    public WebElement busBattleField;
    @FindBy(how = How.ID, using="restaurant_title")
    public WebElement restaurantBattleField;
    @FindBy(how = How.ID, using="restaurant_title")
    public WebElement officeBattleField;
    @FindBy(how = How.ID, using="h2_battlefield")
    public WebElement gameBattleField;


    //   Right Bus Options
    public String rightAnswerForBus1= "//a[text()='Use your superheroes Mask and sanitizer while traveling on public transport and clean your hands regularly.']";
    public String rightAnswerForBus2 =  "//a[text()='Move to another seat immediately and report it to the driver!']";
    public String rightAnswerForBus3="//a[text()='Cover any sneezes or coughs with your superhero inner elbow or with a tissue that is then discarded.']";

    // Wrong Bus Options
    public String wrongAnswerForBus1="//a[text()='Please consider travelling during peak times, when more help is available to you']";
    public String wrongAnswerForBus2= "//a[text()='User your superheroes 'Punch' and keep it to yourself']";
    public String wrongAnswerForBus3= "//a[text()='Cover any sneezes or coughs with your hand and clean it under the sit where no one will notice.']";


    //   Right Restaurant Options
    public String rightAnswerForPublicPlace1= "//a[text()='Use your super hero sanitizer, keep a safe distance and advise they should keep 1.5 metres away from others.']";
    public String rightAnswerForPublicPlace2 = "//a[text()='Use reasonable logic, keep distance from the waiter and report it to management!']";
    public String rightAnswerForPublicPlace3= "//a[text()='Do not ignore the sign of possible contamination and report it to Management.']";

    // Wrong Restaurant Options
    public String wrongAnswerForPublicPlace1= "//a[text()='move away immediately call the police!']";
    public String wrongAnswerForPublicPlace2= "//a[text()='Ignore the signs, and remain oblivious or the situation']";
    public String wrongAnswerForPublicPlace3= "//a[text()='Approach the Group as it seems Fun, and partake in the social festivities']";

    //     Right Office Options
    public String rightAnswerForOffice1="//a[text()='Use your superhero Social Distance and notify your Manager.']";
    public String rightAnswerForOffice2 = "//a[text()='Use your superhero Social Distancing, notify your Manager and recommend she should be working from home.']";
    public String rightAnswerForOffice3= "//a[text()='Use your superhero Social Distance, advise your Manager of the risk and that his partner should be seeking medical advice.']";


    // Wrong Restaurant Options
    public String wrongAnswerForOffice1= "//a[text()='Keep it to yourself, do not draw attention, and pretend you did not notice!']";
    public String wrongAnswerForOffice2= "//a[text()='Email Mary to see if she needs some help, and bring her a nice warm cup of tea, so she can feel better!']";
    public String wrongAnswerForOffice3= "//a[text()='Comfort your Manager, and assure him it is only natural to have a seasonal cold this time of the year.']";

    //Correct Models
    @FindBy(how = How.ID, using = "bus_correct_modal")
    public WebElement busCorrectModal;
    @FindBy(how = How.ID, using = "restaurant_correct_modal")
    public WebElement restaurantCorrectModal;
    @FindBy(how = How.ID, using = "staticBackdrop2")
    public WebElement officeCorrectModal;


    //Incorrect Modals
    @FindBy(how = How.ID, using = "bus_incorrect_modal")
    public WebElement busIncorrectModal;
    @FindBy(how = How.ID, using = "restaurant_incorrect_modal")
    public WebElement restaurantIncorrectModal;
    @FindBy(how = How.ID, using = "staticBackdrop3")
    public WebElement officeIncorrectModal;

    @FindBy(how = How.ID, using = "leaderboard_link")
    public WebElement checkYourScoreButton;
    @FindBy(how = How.ID, using = "close_incorrect_modal_btn")
    public WebElement tryAgainOnIncorrectPopup;
    @FindBy(how = How.XPATH, using = "//button[text() = 'Try the next battle']")
    public WebElement tryNextBattleButton;


    //Time up Modal
    @FindBy(how = How.ID, using = "bus_out_of_time_modal")
    public WebElement busTimeupModal;
    @FindBy(how = How.ID, using = "restaurant_out_of_time_modal")
    public WebElement restaurantTimeupModal;
    @FindBy(how = How.ID, using="staticBackdrop4")
    public WebElement officeTimeupModal;

    @FindBy(how=How.ID, using = "bus_bar")
    public WebElement busProgressBar;
    @FindBy(how=How.ID, using = "restaurant_bar")
    public WebElement restaurantProgressBar;
    @FindBy(how=How.ID, using = "myBar")
    public WebElement officeProgressBar;
    @FindBy(how=How.ID, using = "bar")
    public WebElement gameProgressBar;

    //Try Again on Timeup Modal
    @FindBy(how = How.XPATH, using = "//div[@id='bus_out_of_time_modal']/descendant::button[text()='Try again']")
    public WebElement busTryAgainOnTimeUpPopup;
    @FindBy(how = How.XPATH, using = "//div[@id='restaurant_out_of_time_modal']/descendant::button[text()='Try again']")
    public WebElement restaurantTryAgainOnTimeUpPopup;
    @FindBy(how = How.XPATH, using="//div[@id='staticBackdrop4']/descendant::button[text()='Try again']")
    public WebElement officeTryAgainOnTimeUpPopup;


    //Return Home on Timeup Modal
    @FindBy(how = How.XPATH, using = "//div[@id='bus_out_of_time_modal']/descendant::button[contains(text(),'Return Home')]")
    public WebElement busReturnHomeOnTimeUpPopup;
    @FindBy(how = How.XPATH, using = "//div[@id='restaurant_out_of_time_modal']/descendant::button[contains(text(),'Return Home')]")
    public WebElement restaurantReturnHomeOnTimeUpPopup;
    @FindBy(how = How.XPATH, using="//div[@id='staticBackdrop4']/descendant::button[contains(text(),'Return Home')]")
    public WebElement officeReturnHomeOnTimeUpPopup;


    //Are you game? Popup
    @FindBy(how= How.ID, using="incorrectModal")
    public WebElement virusContractedPopup;
    @FindBy(how= How.XPATH, using="//button[text() = 'Try again']")
    public WebElement tryAgainOnvirusContractedPopup;

    //check your score option
    @FindBy(how= How.XPATH, using="//a[text() = 'Check your score']")
    public WebElement checkYourScoreOption;




    public BattleFieldPage(WebDriver driver,String battleName){
        edriver = driver;
        PageFactory.initElements(driver,this);
        setDriver(edriver);
        this.battleName = battleName;
    }



    public int selectRightAnswer(int score) throws Exception{
        switch(battleName) {
            case Constant.BUS_BATTLEFIELD:
                return getScore(score, rightAnswerForBus1, rightAnswerForBus2, rightAnswerForBus3);
            case Constant.RESTAURANT_BATTLEFIELD:
                return getScore(score, rightAnswerForPublicPlace1, rightAnswerForPublicPlace2, rightAnswerForPublicPlace3);
            case Constant.OFFICE_BATTLEFIELD:
                return getScore(score, rightAnswerForOffice1, rightAnswerForOffice2, rightAnswerForOffice3);
            default: return score;
        }
    }

    public void selectWrongAnswer() throws Exception{
        switch(battleName) {
            case Constant.BUS_BATTLEFIELD:
                clickWrongAnswer(wrongAnswerForBus1,wrongAnswerForBus2,wrongAnswerForBus3);
                break;
            case Constant.RESTAURANT_BATTLEFIELD:
                clickWrongAnswer(wrongAnswerForPublicPlace1,wrongAnswerForPublicPlace2,wrongAnswerForPublicPlace3);
                break;
            case Constant.OFFICE_BATTLEFIELD:
                clickWrongAnswer(wrongAnswerForOffice1,wrongAnswerForOffice2,wrongAnswerForOffice3);
                break;
            default: break;
        }
    }


    public boolean isCheckYourScoreOptionDisplayed() throws Exception{
        return isElementPresent(checkYourScoreOption);
    }

    public boolean isIncorrectModalDisplayed() throws Exception{
        return isModalDisplayed(busIncorrectModal,restaurantIncorrectModal, officeIncorrectModal);
    }

    public boolean isCorrectModalDisplayed() throws Exception{
        return isModalDisplayed(busCorrectModal,restaurantCorrectModal, officeCorrectModal);
    }

    public boolean isTimeUpModalDisplayed() throws Exception {
        return isModalDisplayed(busTimeupModal,restaurantTimeupModal, officeTimeupModal);
    }

    public boolean isVirusContractedModalDisplayed() throws Exception {
        return isElementPresent(virusContractedPopup);
    }

    public boolean isCurrentBattlePageDisplayed () throws Exception {
        return isPageDisplayed(this.battleName);
    }

    public boolean isNextBattlePageDisplayed(String nextBattle) throws Exception {
        return isPageDisplayed(nextBattle);
    }

    public boolean isPageDisplayed(String battleName) throws Exception {
       return isPageDisplayed(battleName,busBattleField,restaurantBattleField,officeBattleField);
    }

    public void doNotChooseOptionUntilTimeout() throws Exception {
        switch(battleName) {
            case Constant.BUS_BATTLEFIELD:
                waitForTimerToFinish(busProgressBar);
                break;
            case Constant.RESTAURANT_BATTLEFIELD:
                waitForTimerToFinish(restaurantProgressBar);
                break;
            case Constant.OFFICE_BATTLEFIELD:
                waitForTimerToFinish(officeProgressBar);
                break;
            case Constant.GAME_BATTLEFIELD:
                waitForTimerToFinish(gameProgressBar);
                break;
            default: break;
        }

    }

    public void clickOnCheckYourScoreOption() throws Exception {
        click(checkYourScoreOption);
    }
   public void clickOnCheckYourFinalScore() throws Exception {
        click(checkYourScoreButton);
    }

    public void clickOnTryNextBattle() throws Exception {
        click(tryNextBattleButton);
    }

    public void clickOnTryAgainOnIncorrectPopup() throws Exception {
        click(tryAgainOnIncorrectPopup);
    }

    public void clickOnTryAgainOnVirusContractedPopup() throws Exception {
        click(tryAgainOnvirusContractedPopup);
    }

    public void clickOnTryAgainOnTimeUpPopup() throws Exception {
        clickAButtonOnModal(busTryAgainOnTimeUpPopup,restaurantTryAgainOnTimeUpPopup,officeTryAgainOnTimeUpPopup);
    }

    public void clickOnReturnHomeOnTimeUpPopup() throws Exception {
        clickAButtonOnModal(busReturnHomeOnTimeUpPopup,restaurantReturnHomeOnTimeUpPopup,officeReturnHomeOnTimeUpPopup);
    }

    private void clickAButtonOnModal(WebElement busButton, WebElement restaurantButton, WebElement officeButton) throws Exception {
        switch(battleName) {
            case Constant.BUS_BATTLEFIELD:
                click(busButton);
                break;
            case Constant.RESTAURANT_BATTLEFIELD:
                click(restaurantButton);
                break;
            case Constant.OFFICE_BATTLEFIELD:
                click(officeButton);
                break;
            default: break;
        }
    }

    private boolean isModalDisplayed(WebElement busModal, WebElement restaurantModal,WebElement officeModal) throws Exception {
        return isPageDisplayed(battleName, busModal, restaurantModal, officeModal);
    }

    private boolean isPageDisplayed(String battleName,WebElement busElement, WebElement restaurantElement, WebElement officeElement ) throws Exception {
        return isPageDisplayed(battleName,busElement,restaurantElement,officeElement,gameBattleField);
    }

    private boolean isPageDisplayed(String battleName,WebElement busElement, WebElement restaurantElement, WebElement officeElement,WebElement gameElement) throws Exception {
        switch(battleName) {
            case Constant.BUS_BATTLEFIELD:
                return isElementPresent(busElement);
            case Constant.RESTAURANT_BATTLEFIELD:
                return isElementPresent(restaurantElement);
            case Constant.OFFICE_BATTLEFIELD:
                return isElementPresent(officeElement);
            case Constant.GAME_BATTLEFIELD:
                return isElementPresent(gameElement);
            default: return false;
        }
    }

    private int getScore(int score, String correctOption1, String correctOption2, String correctOption3) throws Exception {
        log.info("inside get score...");
        if(isElementExist(correctOption1)) {
            log.info(correctOption1);
            click(correctOption1);
            return score+ Constant.QUESTION1_SCORE;
        } else if(isElementExist(correctOption2)) {
            log.info(correctOption2);
            click(correctOption2);
            return score+Constant.QUESTION2_SCORE;
        } else if(isElementExist(correctOption3)){
            log.info(correctOption3);
            click(correctOption3);
            return score+Constant.QUESTION3_SCORE;
        } else  return score;
    }

    private void clickWrongAnswer(String incorrectOption1, String incorrectOption2, String incorrectOption3) throws Exception {
        if(isElementExist(incorrectOption1)){
            click(incorrectOption1);
        } else if(isElementExist(incorrectOption2)){
            click(incorrectOption2);
        } else if(isElementExist(incorrectOption3)){
            click(incorrectOption3);
        }
    }
}
