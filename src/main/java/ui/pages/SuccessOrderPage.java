package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePage;


public class SuccessOrderPage extends BasePage {
    @FindBy(css = "#common-success #content")
    private WebElement orderInPlaceMessage;

    public SuccessOrderPage(WebDriver pDriver) {
        super(pDriver);
    }

    public String orderInPlaceMessage(){
        return getText(orderInPlaceMessage);
    }
}
