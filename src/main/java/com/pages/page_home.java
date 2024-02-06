package com.pages;

import com.custom.waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class page_home {

    private String baseUrl = "https://robotsparebinindustries.com/";
    private By homeButtonLocator = By.xpath("//a[contains(@class,'nav-link') and @href='#/']");
    private By roboButtonLocator = By.xpath("//a[@href='https://www.robocorp.com']");
    private By visitUsButtonLocator = By.xpath("//a[@href='https://hub.robocorp.com']");
    private By loginFormLocator = By.xpath("//form");
    private By alertBoxLocator = By.xpath("//div[@class='alert alert-info']");

    private waits wait = new waits();

    public String getUrl() {
        return baseUrl;
    }

    public WebDriver clickHomeButton(WebDriver driver) {
        driver.findElement(homeButtonLocator).click();
        return driver;
    }

    public WebDriver clickRoboCorpButton(WebDriver driver) throws InterruptedException {
        wait.customWait(driver , Duration.ofMillis(1500),"elementToBeClickable", roboButtonLocator);
        driver.findElement(roboButtonLocator).click();
        Thread.sleep(1500);
        return driver;
    }

    public WebDriver clickVisitUsButton(WebDriver driver) throws InterruptedException {
        wait.customWait(driver , Duration.ofMillis(1500),"elementToBeClickable", visitUsButtonLocator);
        driver.findElement(visitUsButtonLocator).click();
        Thread.sleep(1500);
        return driver;
    }
    public String getHomeButtonsStatus(WebDriver driver) {
        return driver.findElement(homeButtonLocator).getAttribute("class");
    }

    public String getHomePageHeaderText(WebDriver driver){
        return driver.findElement(By.xpath("//h1")).getText();
    }

    public boolean isPageComponentsDisplayed(WebDriver driver) {
        wait.customWait(driver, Duration.ofMillis(1500),"presenceOfElement", loginFormLocator);
        return(driver.findElement(loginFormLocator).isDisplayed() && driver.findElement(alertBoxLocator).isDisplayed());
    }

}
