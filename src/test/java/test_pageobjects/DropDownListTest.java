package test_pageobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageobjects.page.DropDownListPage;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DropDownListTest extends BaseTest {



    // Параметры для теста - ID кнопки и ожидаемый текст панели
    private final String headingId;
    private final String panelId;
    private final String expectedText;

    // Конструктор, который будет принимать параметры для каждого запуска теста
    public DropDownListTest(String headingId, String panelId, String expectedText) {
        this.headingId = headingId;
        this.panelId = panelId;
        this.expectedText = expectedText;
        PageFactory.initElements(driver,this);
    }

    // Метод, который возвращает набор параметров для теста
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"accordion__heading-0", "accordion__panel-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"accordion__heading-1", "accordion__panel-1","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"accordion__heading-2", "accordion__panel-2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"accordion__heading-3", "accordion__panel-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"accordion__heading-4", "accordion__panel-4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"accordion__heading-5", "accordion__panel-5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"accordion__heading-6", "accordion__panel-6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"accordion__heading-7", "accordion__panel-7", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }



    @Test
    public void testAccordionOpensAndDisplaysCorrectText() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        DropDownListPage dropDownListPage = new DropDownListPage();
        dropDownListPage.questionsAboutImportant();
        // Ищем элемент кнопки по id и кликаем по нему
        WebElement heading = driver.findElement(By.id(headingId));
        heading.click();

        // Ищем элемент панели, текст которого нужно проверить
        WebElement panel = driver.findElement(By.id(panelId));
        // Проверяем, что текст панели соответствует ожидаемому
        assertTrue("Текст не совпадает!", panel.getText().contains(expectedText));
    }


}


