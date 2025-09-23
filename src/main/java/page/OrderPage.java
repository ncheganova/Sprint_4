package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By authorBtnNext = By.xpath(".//button[text()='Далее']");
    private By rentBtnOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By orderPlaceOrder = By.xpath(".//button[text()='Да']");
    private By orderStatusRes = By.className("Order_ModalHeader__3FDaJ");
    private By cookiesBtn = By.className("App_CookieButton__3cvqF");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void acceptCookies() {
        driver.findElement(cookiesBtn).click();
    }
    public void clickBtnNext() {
        driver.findElement(authorBtnNext).click();
    }
    public void clickBtnOrder() {
        driver.findElement(rentBtnOrder).click();
    }
    public void clickPlaceOrder() {
        driver.findElement(orderPlaceOrder).click();
    }
    public String getOrderStatus() {
        return driver.findElement(orderStatusRes).getText();
    }
}
