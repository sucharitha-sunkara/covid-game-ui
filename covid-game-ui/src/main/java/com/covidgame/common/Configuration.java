package com.covidgame.common;

public class Configuration {

    private String applicationUrl;
    private String executionBrowser;
    private boolean headlessMode;
    private String screenshotPath;

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String applicationUrl) {
        this.applicationUrl = applicationUrl;
    }

    public String getExecutionBrowser() {
        return executionBrowser;
    }

    public void setExecutionBrowser(String executionBrowser) {
        this.executionBrowser = executionBrowser;
    }

    public boolean isHeadlessMode() {
        return headlessMode;
    }

    public void setHeadlessMode(boolean headlessMode) {
        this.headlessMode = headlessMode;
    }

    public String getScreenshotPath() {
        return screenshotPath;
    }

    public void setScreenshotPath(String screenshotPath) {
        this.screenshotPath = screenshotPath;
    }
}
