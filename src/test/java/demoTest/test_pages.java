package demoTest;

import com.pages.page_robocorp;
import com.pages.page_home;
import com.pages.page_visitus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class test_pages {

    WebDriver driver;
    page_robocorp pageRoboCorp;
    page_home pageHome;
    page_visitus pageVisitUs;

    @BeforeTest
    public void loadTheHomePage() throws InterruptedException {
        // Will be run once before all other tests i.e. they will then inherit the driver
        pageHome = new page_home();
        pageRoboCorp = new page_robocorp();
        pageVisitUs = new page_visitus();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pageHome.getUrl());
        Thread.sleep(1000);
    }

    @Test
    public void case01_testTheHomePageUrl() {
        // Launch the home page, generate expected and actual URLs and compare them
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = pageHome.getUrl();
        String expectedHeaderText = "RobotSpareBin Industries Inc.";
        Assert.assertEquals(expectedUrl, currentUrl,"[ERROR] Different than the expected URL!");
        Assert.assertTrue(pageHome.getHomePageHeaderText(driver).contains(expectedHeaderText), "[ERROR] Different Header Text Displayed!");

    }

    @Test
    public void case02_testTheHomePageLoad() {
        // Verify the components of the home page are loaded
        pageHome.clickHomeButton(driver);
        Assert.assertTrue(pageHome.getHomeButtonsStatus(driver).contains("active"), "[ERROR] Home Button is not active!");
        Assert.assertTrue(pageHome.isPageComponentsDisplayed(driver), "[ERROR] Login Form or Info Box are not displayed!");

    }

    @Test
    public void case03_testGoToVisitUs() throws InterruptedException {
        pageHome.clickVisitUsButton(driver);
        String expectedUrl = pageVisitUs.getPageUrl();
        String actualUrl = driver.getCurrentUrl();
        //back to home
        driver.navigate().back();
        Thread.sleep(1500);
        Assert.assertEquals(expectedUrl, actualUrl, "[ERROR] Opened a different page ");
    }

    @Test
    public void case04_testGoToRoboCorp() throws InterruptedException {
        pageHome.clickRoboCorpButton(driver);
        String expectedUrl = pageRoboCorp.getPageUrl();;
        String actualUrl = driver.getCurrentUrl();
        //back to home
        driver.navigate().back();
        Thread.sleep(1500);
        Assert.assertEquals(expectedUrl, actualUrl, "[ERROR] Opened a different page ");
    }

    @Test
    public void case05_testPagesFooterText() throws InterruptedException {
        pageHome.clickRoboCorpButton(driver);
        Assert.assertEquals(39,pageRoboCorp.getFooterText(driver),"[ERROR] unmatched footer text");
        //back to home
        driver.navigate().back();
        Thread.sleep(1500);
        pageHome.clickVisitUsButton(driver);
        Assert.assertEquals(17,pageVisitUs.getFooterText(driver),"[ERROR] unmatched footer text");

    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}

