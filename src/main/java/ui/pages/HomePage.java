package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePage;

public class HomePage extends BasePage {
    @FindBy(css = "[onclick=\"cart.add('43');\"]")
    private WebElement addMacToCart;

    @FindBy(css = "[onclick=\"cart.add('40');\"]")
    private WebElement addPhoneToCart;

    @FindBy(css = ".alert-success")
    private WebElement addedMessage;

    @FindBy(css = "[title=\"Shopping Cart\"]")
    private WebElement shoppingCart;

    public HomePage(WebDriver pDriver) {
        super(pDriver);
    }

    public void chooseProducts(){

        clickElement(addMacToCart);
        clickElement(addPhoneToCart);
    }

    public String getAddedMessage(){
        return getText(addedMessage);
    }

    public ShoppingCartPage goToShoppingCart(){
        clickElement(shoppingCart);
        return new ShoppingCartPage(getDriver());
    }

}

