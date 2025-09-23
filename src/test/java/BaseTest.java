import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.MainPage;
import page.OrderPage;
import steps.OrderPageSteps;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;
    OrderPageSteps orderPageSteps;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser","chrome"); // "chrome" - начение по умолчанию
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if(browser.equals("firefox")) {
            startBrowserFirefox();
        }
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        orderPageSteps = new OrderPageSteps(driver);
    }
    public void startBrowserFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    public void startBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
