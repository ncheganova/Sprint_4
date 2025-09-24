package steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.OrderPage;

import java.time.Duration;

public class OrderPageSteps  {
    private WebDriver driver;
    private WebDriverWait wait;
    OrderPage orderPage;

    public OrderPageSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.orderPage = new OrderPage(driver);
    }

    public void autorization(String name, String surname, String adress, String metro, String phone){
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(orderPage.authorName));
        input.sendKeys(name);
        driver.findElement(orderPage.authorSurname).sendKeys(surname);
        driver.findElement(orderPage.authorAdress).sendKeys(adress);
        driver.findElement(orderPage.authorMetroInput).sendKeys(metro);
        driver.findElement(orderPage.authorMetroDiv).click();
        driver.findElement(orderPage.authorPhone).sendKeys(phone);
    }

    public void aboutRent(String time, String nRentPeriod, int nRentColour, String comment) {
        driver.findElement(orderPage.rentTime).sendKeys(time);
        driver.findElement(By.className("Order_Header__BZXOb")).click();
        driver.findElement(orderPage.rentPeriodClick).click();
        driver.findElement(By.xpath(String.format(orderPage.rentPeriodChoose, nRentPeriod))).click();
        driver.findElements(orderPage.rentColour).get(nRentColour).click();
        driver.findElement(orderPage.rentComment).sendKeys(comment);
    }
}
