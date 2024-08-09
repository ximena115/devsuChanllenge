import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import ui.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseUItest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp (){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver2.exe");
        driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }
}
