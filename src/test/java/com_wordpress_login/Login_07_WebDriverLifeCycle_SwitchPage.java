package com_wordpress_login;

import browserfactory.DriverFactory;
import browserfactory.DriverManager;
import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageobject_wordpress.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Login_07_WebDriverLifeCycle_SwitchPage extends AbstractTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private ReadPageObject readPage;
    private DriverManager driverManager;
    private DashBoardPageObject dashBoardPage;
    private MediaPageObject mediaPage;
    private PostPageObject postPage;
    private HomePageObject homePage;
    private LinkPageObject linkPage;

    @Parameters ("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driverManager = DriverFactory.getBrowserManager(browserName);
        driver = driverManager.getDriver(GlobalConstants.WORDPRESS_URL);
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @Test
    public void TC_01_loginToWordPress() {
        loginPage.inputToEmailTextbox(GlobalConstants.WORDPRESS_USER);
        loginPage.clickToContinueButton();
        loginPage.inputToPasswordTextbox(GlobalConstants.WORDPRESS_PASSWORD);
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isHomeHeaderDisplayed());
    }

    @Test
    public void TC_02_switchPage(){
        //switch to DashBoard
        dashBoardPage = homePage.clickToWPAdminMenu();
        dashBoardPage.switchToDashBoardWindow(dashBoardPage.getPageTitle(driver));
        //switch to Post Page
        postPage = dashBoardPage.clickToPostMenu(driver);
        //switch to Media Page
        mediaPage = postPage.clickToMediaMenu(driver);
        //switch to Links Page
        linkPage = mediaPage.clickToLinkMenu(driver);
    }

    @AfterClass
    public void afterClass() {
        driverManager.quitDriver();
    }
}
