import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.*;

@RunWith(Parameterized.class)
public class OrderTests extends BaseTest{
    private final String name;
    private final String surname;
    private final String adress;
    private final String metro;
    private final String phone;

    private final String time;
    private final String nRentPeriod;
    private final int nRentColour;
    private final String comment;

    public OrderTests(String name, String surname, String adress, String metro, String phone, String time, String nRentPeriod, int nRentColour, String comment) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metro = metro;
        this.phone = phone;
        this.time = time;
        this.nRentPeriod = nRentPeriod;
        this.nRentColour = nRentColour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getQAListData() {
        return new Object[][] {
                {"Катерина","Иванова","ул.Заречная", "Бульвар Рокоссовского", "89547639876", "04.10.2025", "сутки", 0, "Курьер молодец!"},
                {"Андрей","Коновалов","ул.Гончарова", "Черкизовская", "89765489345", "30.09.2025", "двое суток", 1, "Звонить на другой номер:89765435467"},
        };
    }
    //основная часть
    //проверки через кнопку сверху страницы
    @Test
    public void orderScooterTopBtn() {
        mainPage.openPage();
        mainPage.clickOrderScooterTopBtn();
        orderPage.acceptCookies();
        orderPageSteps.autorization(name, surname, adress, metro, phone);
        orderPage.clickBtnNext();
        orderPageSteps.aboutRent(time, nRentPeriod, nRentColour, comment);
        orderPage.clickBtnOrder();
        orderPage.clickPlaceOrder();
        MatcherAssert.assertThat("Что-то пошло не так. Заказ не оформлен", orderPage.getOrderStatus(), startsWith("Заказ оформлен"));
    }

    //проверка через кнопку внизу страницы
    @Test
    public void orderScooterBottomBtn() {
        mainPage.openPage();
        mainPage.scrollToBottomOrderBtn();
        mainPage.clickOrderScooterBottomBtn();
        orderPage.acceptCookies();
        orderPageSteps.autorization(name, surname, adress, metro, phone);
        orderPage.clickBtnNext();
        orderPageSteps.aboutRent(time, nRentPeriod, nRentColour, comment);
        orderPage.clickBtnOrder();
        orderPage.clickPlaceOrder();
        MatcherAssert.assertThat("Что-то пошло не так. Заказ не оформлен", orderPage.getOrderStatus(), startsWith("Заказ оформлен"));
    }
}
