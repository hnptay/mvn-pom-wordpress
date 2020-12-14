package com_wordpress_login;

import browserfactory.DriverFactory;
import browserfactory.DriverManager;
import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageobject_wordpress.DashBoardPageObject;
import pageobject_wordpress.HomePageObject;
import pageobject_wordpress.LoginPageObject;
import pageobject_wordpress.MediaPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Login_10_ElementUndisplayed extends AbstractTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DriverManager driverManager;
    private DashBoardPageObject dashBoardPage;
    private MediaPageObject mediaPage;
    private HomePageObject homePage;


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
    public void TC_02_elementUndisplayedInDOM(){
        dashBoardPage = homePage.clickToWPAdminMenu();
        dashBoardPage.switchToDashBoardWindow(dashBoardPage.getPageTitle(driver));
        Assert.assertTrue(dashBoardPage.isScreenButtonDisplayed());
    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
