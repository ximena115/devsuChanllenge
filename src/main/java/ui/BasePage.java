package ui;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver pDriver){
        PageFactory.initElements(pDriver,this);
        pDriver.manage().window().maximize();
        wait = new WebDriverWait(pDriver, 10);
        driver = pDriver;
    }

    public WebDriverWait getWait(){
        return wait;
    }

    protected WebDriver getDriver(){
        return driver;
    }

    public void dispose(){
        if(driver != null){
            driver.quit();
        }
    }

    private void waitElement(WebElement element) {
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement(WebElement element) {
        waitElement(element);
        element.click();
    }

    public void sendKeys(WebElement element, String sequence) {
        waitElement(element);
        element.sendKeys(sequence);
    }

    public boolean isElementAvailable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public String getText(WebElement element) {
        waitElement(element);
        return element.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void scrollToButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void selectOptionByText(WebElement element, String text) {
        waitElement(element);
        Select options = new Select(element);
        options.selectByVisibleText(text);
    }

    public void waitProductsToStar(WebElement element) {
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    element.isDisplayed();
                    return true;
                });

    }
}
