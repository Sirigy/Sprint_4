package test_pageobjects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.page.HomePage;
import pageobjects.page.OrderDataPage;
import pageobjects.page.UserDataPage;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ButtonTest extends BaseTest {

    private final String buttonType;
    private final String nameValue;
    private final String lastNameValue;
    private final String addressValue;
    private final String phoneValue;

    public ButtonTest(String buttonType, String nameValue, String lastNameValue, String addressValue, String phoneValue) {
        this.buttonType = buttonType;
        this.nameValue = nameValue;
        this.lastNameValue = lastNameValue;
        this.addressValue = addressValue;
        this.phoneValue = phoneValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> dataOrder() {
        return Arrays.asList(new Object[][]{
                {"lower", "Сидор", "Сидоров", "Синежская 16", "89337755599"},
                {"upper", "Иван", "Иванов", "Усачёва 3", "89327788899"}
        });
    }

    @Test
    public void orderWasCompleted() {
        HomePage homePage = new HomePage();
        homePage.getPageUrl();

        if ("lower".equals(buttonType)) {
            homePage.jumpToLowerButton();
            homePage.clickOnLowerButton();
        } else if ("upper".equals(buttonType)) {
            homePage.clickOnUpperButton();
        }

        UserDataPage userDataPage = new UserDataPage();
        userDataPage.userDataEntry(nameValue, lastNameValue, addressValue, phoneValue);

        OrderDataPage orderDataPage = new OrderDataPage();
        orderDataPage.orderDataEntry();

        // Ожидаем, что появится сообщение "Заказ оформлен"
        Assert.assertTrue(orderDataPage.OrderPlaced().contains("Заказ оформлен"));
    }
}


