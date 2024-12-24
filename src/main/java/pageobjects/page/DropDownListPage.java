package pageobjects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DropDownListPage extends BasePage {

    // Локаторы Вопросов и ответов.
    private static By questionButton(int questionIndex) {
        return By.id("accordion__heading-" + questionIndex);
    }

    private static By answerLocator(int questionIndex) {
        return By.id("accordion__panel-" + questionIndex);
    }

    // Массив вопросов
    public static final String[] QUESTIONS = {
            "Сколько это стоит? И как оплатить?",
            "Хочу сразу несколько самокатов! Так можно?",
            "Как рассчитывается время аренды?",
            "Можно ли заказать самокат прямо на сегодня?",
            "Можно ли продлить заказ или вернуть самокат раньше?",
            "Вы привозите зарядку вместе с самокатом?",
            "Можно ли отменить заказ?",
            "Я жизу за МКАДом, привезёте?"
    };

    // Массив ожидаемых текстов ответов
    public static final String[] EXPECTED_ANSWER = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    //Конструктор инициализирующий все элементы(через PageFactory).
    public DropDownListPage() {
        PageFactory.initElements(driver, this);
    }

    //Метод прокрутки веб-страницы к конкретному элементу.
    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    // Прокрутка к элементу.Ожидание элемента.Поиск и клик на элемент
    public void clickOnElement(By locator) {
        scrollToElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    //Методы принимает номер вопроса, находит соответствующую кнопку и инициирует действие щелчка на этой кнопке.
    public void clickButtonQuestion(int questionNumber) {
        clickOnElement(questionButton(questionNumber));
    }

    //Метод служит для динамического извлечения текста вопроса
    public String getTextQuestion(int questionNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(questionButton(questionNumber)));
        return driver.findElement(questionButton(questionNumber)).getText();
    }
    //Метод предназначен для получения текста ответа на вопрос
    public String getAnswerText(int questionNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator(questionNumber)));
        return driver.findElement(answerLocator(questionNumber)).getText();
    }

}