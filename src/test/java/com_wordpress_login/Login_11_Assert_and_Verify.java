package com_wordpress_login;

import browserfactory.DriverFactory;
import browserfactory.DriverManager;
import commons.AbstractTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageobject_wordpress.DashBoardPageObject;
import pageobject_wordpress.HomePageObject;
import pageobject_wordpress.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Login_11_Assert_and_Verify extends AbstractTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driverManager = DriverFactory.getBrowserManager(browserName);
        driver = driverManager.getDriver(GlobalConstants.WORDPRESS_URL);
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }

    @Test
    public void TC_01_loginToWordPress() {
        loginPage.inputToEmailTextbox(GlobalConstants.WORDPRESS_USER);
        loginPage.clickToContinueButton();
        loginPage.inputToPasswordTextbox(GlobalConstants.WORDPRESS_PASSWORD);
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isHomeHeaderDisplayed());
        verifyTrue(false);
    }

    @Test
    public void TC_02_elementUndisplayedInDOM() {
        dashBoardPage = homePage.clickToWPAdminMenu();
        dashBoardPage.switchToDashBoardWindow(dashBoardPage.getPageTitle(driver));
        verifyFalse(true);
    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private DriverManager driverManager;
    private DashBoardPageObject dashBoardPage;
    private HomePageObject homePage;
}
