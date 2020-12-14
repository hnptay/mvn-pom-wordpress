package pageobject_bankguru;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;

public class EditCustomerPageObject extends AbstractPage {
    public EditCustomerPageObject(WebDriver driver){
        this.driver = driver;
    }

    private WebDriver driver;
}
