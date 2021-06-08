package com.covidgame.ui;

import com.covidgame.common.Browser;
import com.covidgame.pageobjects.BattleFieldPage;
import com.covidgame.pageobjects.BattleSelectionPage;
import com.covidgame.pageobjects.HomePage;
import com.covidgame.pageobjects.LeaderboardPage;
import com.covidgame.utils.Constant;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {


    static final Logger log = Logger.getLogger(StepDefinitions.class);
    public WebDriver driver;
    public HomePage homePage;
    public BattleSelectionPage battleSelectionPage;
    public LeaderboardPage leaderboardPage;
    public BattleFieldPage battlefieldPage;
    public int initialScore=0;
    public int finalScore;

    public StepDefinitions() {
        driver = Browser.driver;
    }

    @Given("^User opened the webpage$")
    public void userOpenedWebPage() throws Throwable {
        homePage = new HomePage(driver);
        battleSelectionPage = new BattleSelectionPage(driver);
        leaderboardPage = new LeaderboardPage(driver);
    }

    @Given("^User creates a Warrior (.+) and starts the Journey$")
    public void createWarrior(String warriorName) throws Exception {
        //Need them when you wanted to use generate new warrior's everything
//        int randomNo = (int)(Math.random()*9000) +1000;
//        warriorName = warriorName.replace("<RandNo>", String.valueOf(randomNo));

        homePage.startJourney(warriorName);
        log.info("Created Warrior " + warriorName + " and started the journey");
    }

    @When("^User chooses (.+) Battlefield$")
    public void selectBattlefield(String battleName) throws Exception {
        log.info("In Battle Selection page is displayed");
        battleSelectionPage.selectBattle(battleName);
        log.info(battleName + " battlefield is selected");
        battlefieldPage = new BattleFieldPage(driver,battleName);

    }

    @Then("^Battlefield page is displayed")
    public void checkBattleFieldPageIsDisplayed() throws Exception {
        Assert.assertTrue(battlefieldPage.isCurrentBattlePageDisplayed());
    }

    @When("^User selects the right option$")
    public void selectRightAnswer() throws Exception {
           finalScore= battlefieldPage.selectRightAnswer(initialScore);
    }

    @Then("^Option Correct Popup is displayed$")
    public void checkCorrectPopupIsDisplayed() throws Exception {
        Assert.assertTrue(battlefieldPage.isCorrectModalDisplayed());
    }

    @When("^User Clicks on Check your Score$")
    public void clickOnCheckYourScore() throws Exception {
        battlefieldPage.clickOnCheckYourFinalScore();
    }

    @Then("^Leaderboard page is displayed$")
    public void checkLeaderboardPageIsDisplayed() throws Exception {
        log.info("check if leaderboard page is displayed...");
        Assert.assertTrue(leaderboardPage.isPageDisplayed());
        log.info("Leaderboard page is displayed");
    }

    @And("^check Warrior score is increased$")
    public void checkScoreIncreased() throws Exception {
         log.info("Final Score: " + finalScore + " Initial Score: " + initialScore);
         Assert.assertTrue("Final score: " + finalScore + " Initial Score: " + initialScore, finalScore>initialScore);
    }


    @When("^User does not select option within timeout$")
    public void userDoesNotChooseOption() throws Exception {
          battlefieldPage.doNotChooseOptionUntilTimeout();
    }

    @Then("^Time Up Popup is returned$")
    public void checkTimeUpPopup() throws Exception {
        Assert.assertTrue(battlefieldPage.isTimeUpModalDisplayed());
    }


    @And("^User selects an incorrect option$")
    public void userChoosesIncorrectOption() throws Exception {
        battlefieldPage.selectWrongAnswer();
    }

    @Then("^Option Incorrect Popup is returned$")
    public void checkTryAgainPopupIsDisplayed() throws Exception{
       Assert.assertTrue(battlefieldPage.isIncorrectModalDisplayed());
    }
    @When("^User clicks on Try again on Incorrect Popup$")
    public void clickTryAgainOnIncorrectPopup() throws Exception {
        battlefieldPage.clickOnTryAgainOnIncorrectPopup();
    }

    @When("^User clicks on Try again on Time Up Popup$")
    public void clickTryAgainOnTimeupPopup() throws Exception {
        battlefieldPage.clickOnTryAgainOnTimeUpPopup();
    }

    @When("^User clicks on Return Home$")
    public void  clickOnReturnHome() throws Exception {
        battlefieldPage.clickOnReturnHomeOnTimeUpPopup();
    }

    @Then("^Choose Battle page is displayed$")
    public void checkChooseBattlePageIsDisplayed() throws Exception {
        Assert.assertTrue(battleSelectionPage.isPageDisplayed());
    }

    @When("^User clicks on Try Next Battle$")
    public void clickOnTryNextBattle() throws Exception {
        battlefieldPage.clickOnTryNextBattle();
    }

    @Then("^Next Battlefield (.+) page is displayed$")
    public void checkNextBattlePageIsDisplayed(String nextBattle) throws Exception {
        Assert.assertTrue(battlefieldPage.isNextBattlePageDisplayed(nextBattle));

    }

    @Then("^Virus contracted popup is displayed$")
    public void checkVirusContractedPopupIsDisplayed() throws Exception {
        Assert.assertTrue(battlefieldPage.isVirusContractedModalDisplayed());
    }

    @When("^user clicks on try again on Virus Contracted popup$")
    public void clickTryAgainOnVirusContractedPopup() throws Exception {
        battlefieldPage.clickOnTryAgainOnVirusContractedPopup();
    }

    @Then("^Home page is displayed$")
    public void checkHomePageIsDisplayed() throws Exception {
        Assert.assertTrue(homePage.isPageDisplayed());
    }

    @When("^User answers all questions in (.+) battle$")
    public void userAnswersAllQuestions(String battleName) throws Exception {
        finalScore = 0;
        for (int i=0; i<3; i++) {
            finalScore += battlefieldPage.selectRightAnswer(initialScore);
            battlefieldPage.clickOnCheckYourFinalScore();
            leaderboardPage.clickOnContinueFightingButton();
            battleSelectionPage.selectBattle(battleName);
        }
    }

    @Then("^Check your Score Option is displayed$")
    public void checkCheckYourScoreOptionIsDisplayed() throws Exception {
        Assert.assertTrue(battlefieldPage.isCheckYourScoreOptionDisplayed());
    }

    @When("^User clicks on check your score$")
    public void userClicksOnCheckYourScoreOption() throws Exception {
        battlefieldPage.clickOnCheckYourScoreOption();
    }

    @When("^User clicks on Continue Fighting$")
    public void userClickOnContinueFightingButton() throws Exception {
        leaderboardPage.clickOnContinueFightingButton();
    }






}
