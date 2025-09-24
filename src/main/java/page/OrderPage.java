package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    private By authorBtnNext = By.xpath(".//button[text()='Далее']");
    private By rentBtnOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By orderPlaceOrder = By.xpath(".//button[text()='Да']");
    private By orderStatusRes = By.className("Order_ModalHeader__3FDaJ");

    public By authorName = By.xpath(".//input[@placeholder='* Имя']");
    public By authorSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    public By authorAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public By authorMetroInput = By.xpath(".//input[@class='select-search__input']");
    public By authorMetroDiv = By.xpath(".//div[@class='select-search__select']");
    public By authorPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    public By rentTime = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public By rentPeriodClick = By.className("Dropdown-placeholder");
    public String rentPeriodChoose = ".//div[text()='%s']";
    public By rentColour = By.xpath(".//label[@class='Checkbox_Label__3wxSf']");
    public By rentComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

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
