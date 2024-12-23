package test_pageobjects;

import org.junit.Assert;
import org.junit.Test;
import pageobjects.page.HomePage;
import pageobjects.page.OrderDataPage;
import pageobjects.page.UserDataPage;

public class TopButtonTest extends BaseTest {
    //Проверка по верхней кнопки.
    @Test
    public void orderWasCompletedTopButton() {
        String nameValue = "Иван";
        String lastNameValue = "Иванов";
        String addressValue = "Усачёва 3";
        String phoneValue = "89327788899";
        String actual = "Заказ оформлен";
        String unexpected = "Заказ оформлен";
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage homePage = new HomePage();
        homePage.clickOnUpperButton();
        UserDataPage userDataPage = new UserDataPage();
        userDataPage.userDataEntry(nameValue,lastNameValue,addressValue,phoneValue);
        OrderDataPage orderDataPage = new OrderDataPage();
        orderDataPage.orderDataEntry();
        Assert.assertTrue(orderDataPage.OrderPlaced().contains("Заказ оформлен"));

    }

}
