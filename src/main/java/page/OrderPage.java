package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    private By authorBtnNext = By.xpath(".//button[text()='Далее']");
    private By rentBtnOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By orderPlaceOrder = By.xpath(".//button[text()='Да']");
    private By orderStatusRes = By.className("Order_ModalHeader__3FDaJ");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
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
