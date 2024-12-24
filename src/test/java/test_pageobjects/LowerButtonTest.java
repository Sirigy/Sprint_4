package test_pageobjects;

import org.junit.Assert;
import org.junit.Test;
import pageobjects.page.HomePage;
import pageobjects.page.OrderDataPage;
import pageobjects.page.UserDataPage;

public class LowerButtonTest extends BaseTest {
    //Проверка по нижней кнопки.
    @Test
    public void orderWasCompletedLowerButton() {

        String nameValue = "Сидор";
        String lastNameValue = "Сидоров";
        String addressValue = "Синежская 16";
        String phoneValue = "89337755599";
        String actual = "Заказ оформлен";
        String unexpected = "Заказ оформлен";
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage homePage = new HomePage();
        homePage.jumpToLowerButton();
        homePage.clickOnLowerButton();
        UserDataPage userDataPage = new UserDataPage();
        userDataPage.userDataEntry(nameValue,lastNameValue,addressValue,phoneValue);
        OrderDataPage orderDataPage = new OrderDataPage();
        orderDataPage.orderDataEntry();
        Assert.assertTrue(orderDataPage.OrderPlaced().contains("Заказ оформлен"));

    }
}
