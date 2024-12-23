package pageobjects.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownListPage extends BasePage {

    @FindBy(xpath = ".//div[text()='Вопросы о важном']")
    private WebElement questionsAboutImportant;// Элемент до которого нужно прокрутить страницу.

    @FindBy(id = "accordion__heading-0")
    private WebElement accordionHeading_0; // первая кнопка "Сколько это стоит? И как оплатить?".
    @FindBy(id = "accordion__panel-0")
    private WebElement accordionPanel_0; // панель:"Сутки — 400 рублей. Оплата курьеру — наличными или картой.".

    @FindBy(id = "accordion__heading-1")
    private WebElement accordionHeading_1; // вторая кнопк "Хочу сразу несколько самокатов! Так можно?".
    @FindBy(id = "accordion__panel-1")
    private WebElement accordionPanel_1; // панель: "Пока что у нас так: один заказ — один самокат.... ".

    @FindBy(id = "accordion__heading-2")
    private WebElement accordionHeading_2; // третья кнопка "Как рассчитывается время аренды?".
    @FindBy(id = "accordion__panel-2")
    private WebElement accordionPanel_2; // панель "Допустим, вы оформляете заказ на 8 мая..... ".

    @FindBy(id = "accordion__heading-3")
    private WebElement accordionHeading_3; // четвёртая кнопка "Можно ли заказать самокат прямо на сегодня?".
    @FindBy(id = "accordion__panel-3")
    private WebElement accordionPanel_3; // панель: "Только начиная с завтрашнего дня. Но скоро станем расторопнее.".

    @FindBy(id = "accordion__heading-4")
    private WebElement accordionHeading_4; // пятая кнопка "Можно ли продлить заказ или вернуть самокат раньше?".
    @FindBy(id = "accordion__panel-4")
    private WebElement accordionPanel_4; // панель: "Пока что нет!...".

    @FindBy(id = "accordion__heading-5")
    private WebElement accordionHeading_5; // шестая кнопка "Вы привозите зарядку вместе с самокатом?".
    @FindBy(id = "accordion__panel-5")
    private WebElement accordionPanel_5; // панель: "Самокат приезжает к вам с полной зарядкой....".

    @FindBy(id = "accordion__heading-6")
    private WebElement accordionHeading_6; // седьмая кнопка "Можно ли отменить заказ?".
    @FindBy(id = "accordion__panel-6")
    private WebElement accordionPanel_6; // панель: "Да, пока самокат не привезли....".

    @FindBy(id = "accordion__heading-7")
    private WebElement accordionHeading_7; // восьмая кнопка "Я жизу за МКАДом, привезёте?".
    @FindBy(id = "accordion__panel-7")
    private WebElement accordionPanel_7; // панель: "Да, обязательно. Всем самокатов!... ".

    //Конструктор инициализирующий все элементы(через PageFactory).
    public DropDownListPage() {
        PageFactory.initElements(driver, this);
    }
    //Метод прокручивающий страницу до вопросов.
    public void questionsAboutImportant(){
        WebElement element = questionsAboutImportant;
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}