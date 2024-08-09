package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePage;
import ui.pages.CheckoutPage;

public class ShoppingCartPage extends BasePage {
    @FindBy(css = ".clearfix .pull-right")
    private WebElement checkout;

    public ShoppingCartPage(WebDriver pDriver) {
        super(pDriver);
    }

    public CheckoutPage goToCheckoutPage(){
        scrollToButton();
        clickElement(checkout);
        return new CheckoutPage(getDriver());
    }
}
