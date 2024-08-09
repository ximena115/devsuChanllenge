package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.BasePage;


public class CheckoutPage extends BasePage {
    @FindBy(css = "[type=\"radio\"][value=\"guest\"]")
    private WebElement checkoutAsAGuest;

    @FindBy(css = "#button-account")
    private WebElement continueButton;

    @FindBy(css = "[type=\"text\"][name=\"firstname\"]")
    private WebElement firstName;

    @FindBy(css = "[type=\"text\"][name=\"lastname\"]")
    private WebElement lastname;

    @FindBy(css = "#input-payment-email")
    private WebElement email;

    @FindBy(css = "[type=\"text\"][name=\"telephone\"]")
    private WebElement telephone;

    @FindBy(css = "[type=\"text\"][name=\"address_1\"]")
    private WebElement address;

    @FindBy(css = "[type=\"text\"][name=\"city\"]")
    private WebElement city;

    @FindBy(css = "#input-payment-postcode")
    private WebElement postCode;

    @FindBy(css = "#input-payment-country")
    private WebElement country;

    @FindBy(css = "#input-payment-zone")
    private WebElement region;

    @FindBy(css = "#button-guest")
    private WebElement continueToDelivery;

    @FindBy(css = "#button-shipping-method")
    private WebElement continueToPayment;

    @FindBy(css = "#button-payment-method")
    private WebElement continueToComfirm;

    @FindBy(css = "[type=\"checkbox\"][name=\"shipping_address\"]")
    private WebElement deliveryAddress;

    @FindBy(css = "[type=\"checkbox\"][name=\"agree\"]")
    private WebElement termsAndConditions;

    @FindBy(css = "#button-confirm")
    private WebElement confirmOrder;

    public CheckoutPage(WebDriver pDriver) {
        super(pDriver);
    }

    public void selectGuestOption(){
        clickElement(checkoutAsAGuest);
        clickElement(continueButton);
    }

    public void fillRequiredDetails(){
        sendKeys(firstName,"Ximena");
        sendKeys(lastname,"salazar");
        sendKeys(email,"xsalazar123@gmail.com");
        sendKeys(telephone,"123456789");
        selectOptionByText(country,"Colombia");
        sendKeys(address,"Carrera 13 # 1-12");
        sendKeys(city,"Medellin");
        sendKeys(postCode,"0987665");
        selectOptionByText(region,"Antioquia");
        clickElement(continueToDelivery);
        clickElement(continueToPayment);
        clickElement(termsAndConditions);
        clickElement(continueToComfirm);
    }

    public SuccessOrderPage confirmOrder(){
        clickElement(confirmOrder);
        return new SuccessOrderPage(getDriver());
    }
}
