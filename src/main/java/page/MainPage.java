package page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private static final String IDQUESTION = "accordion__heading-";
    private static final String IDANSWER = "accordion__panel-";

    private By listQA = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div");
    private By orderScooterTopBtn = By.className("Button_Button__ra12g");
    private By orderScooterBottomBtn = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    private By cookiesBtn = By.className("App_CookieButton__3cvqF");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }
    public void scrollToQAList() {
        WebElement element = driver.findElement(listQA);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                element);
    }
    public void clickQuestion(int n) {
        driver.findElement(By.id(IDQUESTION +n)).click();
    }
    public String getAnswer(int n) {return driver.findElement(By.id(IDANSWER+n)).getText();}
    public String getQuestion(int n) {return driver.findElement(By.id(IDQUESTION+n)).getText();}
    public void clickOrderScooterTopBtn() {driver.findElement(orderScooterTopBtn).click();}
    public void acceptCookies() {
        driver.findElement(cookiesBtn).click();
    }
    public void scrollToBottomOrderBtn() {
        WebElement element = driver.findElement(orderScooterBottomBtn);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                element);
    }
    public void clickOrderScooterBottomBtn() {driver.findElement(orderScooterBottomBtn).click();}
}
