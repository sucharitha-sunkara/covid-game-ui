package com.covidgame.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.FileInputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.Properties;

public class Browser {

    private static DesiredCapabilities dr = null;
    private static String EDGE_BROWSER_NAME = "ie";
    private static String FIREFOX_BROWSER_NAME = "firefox";
    private static String CHROME_BROWSER_NAME = "chrome";

    private static final int  IMPLICIT_WAIT_SECONDS =15;

    public static WebDriver driver;
    public static Configuration envConfig;
    public static Properties configProperties;
    public static boolean reOpenBrowser=true;


    @Before (order = 1)
    public void openBrowser() throws Exception {
        loadProperties();
        initialiseDriver();
    }

    @After (order = 1)
    public void closeBrowser() throws Exception {
            driver.close();
            driver.quit();
    }


    public void setLocalDriver(String browserName) throws Exception {
        String CurrentDirectory = System.getProperty("user.dir");
        if (browserName.equalsIgnoreCase(FIREFOX_BROWSER_NAME)) {
            System.setProperty("webdriver.gecko.driver", CurrentDirectory + "\\drivers\\geckodriver.exe");
            driver =  new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase(EDGE_BROWSER_NAME)) {
            System.setProperty("webdriver.edge.driver", CurrentDirectory + "\\drivers\\MicrosoftWebDriver.exe");
            driver =  new EdgeDriver();
        } else {

            if (System.getProperty("webdriver.chrome.driver") == null) {
                System.setProperty("webdriver.chrome.driver", CurrentDirectory + "\\drivers\\chromedriver.exe");
            }
            driver =  new ChromeDriver();
        }
    }

    private void initialiseDriver() throws Exception {
        try {
            setLocalDriver(envConfig.getExecutionBrowser());
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(envConfig.getApplicationUrl());
        } catch (TimeoutException te) {
            initialiseDriver();
        }
    }

    private void loadProperties() throws Exception {
        if (configProperties == null) {
            configProperties = new Properties();
            configProperties.load(new FileInputStream(getResourcePath("config.properties")));
        }
        if (envConfig == null) {
            envConfig = new Configuration();
            envConfig.setApplicationUrl(getPropertyValue("env.application.url"));
            envConfig.setExecutionBrowser(getPropertyValue("test.execution.browser"));
        }
    }

    private String getPropertyValue(String propertyName) throws Exception {
        return (System.getProperty(propertyName)) != null ?
                System.getProperty(propertyName) : configProperties.getProperty(propertyName);
    }

    public static String getResourcePath(String resourcePath) throws URISyntaxException {
        URL resource = Browser.class.getClassLoader().getResource(resourcePath);
        return resource.toURI().getPath();
    }

}
