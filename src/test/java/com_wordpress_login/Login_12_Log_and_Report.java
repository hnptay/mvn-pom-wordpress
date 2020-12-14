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


public class Login_12_Log_and_Report extends AbstractTest {

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driverManager = DriverFactory.getBrowserManager(browserName);
        log.info("Pre-condition - STEP 01: Open browser");
        driver = driverManager.getDriver(GlobalConstants.WORDPRESS_URL);
        log.info("Pre-condition - STEP 02: Open Login page");
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        log.info("Post-condition - Close browser");
        closeBrowserAndDriver(driver);
    }

    @Test
    public void TC_01_loginToWordPress() {
        log.info("TC_01_loginToWordPress - STEP 01: Input to 'Email' text box");
        loginPage.inputToEmailTextbox(GlobalConstants.WORDPRESS_USER);
        log.info("TC_01_loginToWordPress - STEP 02: Click to continue button");
        loginPage.clickToContinueButton();
        log.info("TC_01_loginToWordPress - STEP 03: Input to 'Password' text box");
        loginPage.inputToPasswordTextbox(GlobalConstants.WORDPRESS_PASSWORD);
        log.info("TC_01_loginToWordPress - STEP 04: Click to Login button");
        homePage = loginPage.clickToLoginButton();
        log.info("TC_01_loginToWordPress - STEP 05: Verify Home Page is displayed");
        Assert.assertTrue(homePage.isHomeHeaderDisplayed());
    }

    @Test
    public void TC_02_elementUndisplayedInDOM() {
        log.info("TC_02_elementUndisplayedInDOM - STEP 01: Click to 'WPAdmin' menu");
        dashBoardPage = homePage.clickToWPAdminMenu();
        log.info("TC_02_elementUndisplayedInDOM - STEP 02: Switch to 'Dashboard' window");
        dashBoardPage.switchToDashBoardWindow(dashBoardPage.getPageTitle(driver));
    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private DriverManager driverManager;
    private DashBoardPageObject dashBoardPage;
    private HomePageObject homePage;
}
