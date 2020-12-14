package pageobject_wordpress;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class LinkPageObject extends AbstractPage {
    WebDriver driver;

    public LinkPageObject(WebDriver driver){
        this.driver = driver;
    }
}
