package pageobject_wordpress;

import commons.AbstractPage;
import pageUI_wordpress.DashBoardPageUI;
import org.openqa.selenium.WebDriver;

public class DashBoardPageObject extends AbstractPage {
    private WebDriver driver;

    public DashBoardPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void switchToDashBoardWindow(String windowTitle){
        switchToWindowByTitle(driver, windowTitle);
    }

    public boolean isScreenButtonDisplayed(){
        return isElementUndisplayed(driver, DashBoardPageUI.SCREEN_BUTTON);
    }

}
