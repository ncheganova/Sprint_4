package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPageSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    private By authorName = By.xpath(".//input[@placeholder='* Имя']");
    private By authorSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private By authorAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By authorMetroInput = By.xpath(".//input[@class='select-search__input']");
    private By authorMetroDiv = By.xpath(".//div[@class='select-search__select']");
    private By authorPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    private By rentTime = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentPeriodClick = By.className("Dropdown-placeholder");
    private String rentPeriodChoose = ".//div[text()='%s']";
    private By rentColour = By.xpath(".//label[@class='Checkbox_Label__3wxSf']");
    private By rentComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    public OrderPageSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void autorization(String name, String surname, String adress, String metro, String phone){
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(authorName));
        input.sendKeys(name);
        driver.findElement(authorSurname).sendKeys(surname);
        driver.findElement(authorAdress).sendKeys(adress);
        driver.findElement(authorMetroInput).sendKeys(metro);
        driver.findElement(authorMetroDiv).click();
        driver.findElement(authorPhone).sendKeys(phone);
    }

    public void aboutRent(String time, String nRentPeriod, int nRentColour, String comment) {
        driver.findElement(rentTime).sendKeys(time);
        driver.findElement(By.className("Order_Header__BZXOb")).click();
        driver.findElement(rentPeriodClick).click();
        driver.findElement(By.xpath(String.format(rentPeriodChoose, nRentPeriod))).click();
        driver.findElements(rentColour).get(nRentColour).click();
        driver.findElement(rentComment).sendKeys(comment);
    }
}
