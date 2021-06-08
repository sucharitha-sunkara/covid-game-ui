package com.covidgame.common;

import com.covidgame.utils.Constant;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class PageObjectBase {
    private static final Logger log = Logger.getLogger(PageObjectBase.class);

    public static WebDriver edriver;
    private static WebDriver jsWaitDriver;
    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;

    public static void setDriver(WebDriver driver) {
        edriver = driver;
        jsWaitDriver = driver;
        jsWait = new WebDriverWait(jsWaitDriver, 20L);
        jsExec = (JavascriptExecutor) jsWaitDriver;
    }

    public void sendKeys(WebElement element, String text) throws Exception {
        waitUntilElementIsVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void click (String xpath) throws Exception {
        WebElement element = edriver.findElement(By.xpath(xpath));
                click(element);
    }
    public void click (WebElement element) throws Exception {
        try {
            new WebDriverWait(edriver, Constant.WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException e) {
            Thread.sleep(Constant.WAIT_STALE_ELEMENT_TIMEOUT_SECONDS);
            PageFactory.initElements(edriver, this);
        } catch (Exception e) {
        }
        waitUntilElementIsVisible(element);
        element.click();
        waitWhileBrowserIsBusy();
    }

    public Object getText(String xpath) throws Exception {
        WebElement element = edriver.findElement(By.xpath(xpath));
        return element.getText();
    }


    public boolean isElementPresent(WebElement element) throws Exception{
        waitWhileBrowserIsBusy();
        waitUntilElementIsVisible(element);
        try {
            return element.isDisplayed();
        } catch(Exception e ){
            return false;
        }
    }

    public boolean isElementExist(String xpath) throws Exception {
        turnOffImplicitWait(Constant.MIN_IMPLICIT_WAIT_MILL_SECONDS);
        boolean isExist = !edriver.findElements(By.xpath(xpath)).isEmpty();
        turnOnImplicitWait();
        return isExist;
    }

    public void turnOffImplicitWait(long timeout) throws Exception {
        edriver.manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS);
    }

    public void turnOnImplicitWait() throws Exception {
        edriver.manage().timeouts().implicitlyWait(Constant.IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
    }

    public static void waitUntilElementIsVisible(WebElement element) throws Exception {
        waitWhileBrowserIsBusy();

        int attempt = 0;
        while (attempt < Constant.NO_OF_ATTEMPTS) {
            try {
                new WebDriverWait(edriver, Constant.WAIT_TIMEOUT_SECONDS)
                        .until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (StaleElementReferenceException ex) {
                attempt++;
                if (attempt == Constant.NO_OF_ATTEMPTS) {
                    throw ex;
                }
            }
        }
    }
        public static void waitWhileBrowserIsBusy() throws Exception {
            ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    return executor.executeScript("return document.readyState").equals("complete");
                }
            };

            Wait<WebDriver> wait = new WebDriverWait(edriver, Constant.WAIT_TIMEOUT_SECONDS);
            try {
                wait.until(expectation);
            } catch (Throwable t) {
                log.error("Browser did not responded in " + Constant.WAIT_TIMEOUT_SECONDS
                        + " sec(s)");
            }

        }

        public static void waitForTimerToFinish(WebElement timer) throws Exception {

            for (int i=0; i<=30;i++) {
                timer.getAttribute("style");
                if(timer.getAttribute("style").contains("width: 100%;")) return;
                Thread.sleep(1000);
            }

        }

    public static String  getTitle() throws Exception{
         return edriver.getTitle();
    }

    public static String  getCurrentUrl() throws Exception{
        return edriver.getCurrentUrl();
    }


    }
