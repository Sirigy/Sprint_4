package pageobjects.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g']")
    private WebElement upperButton; // Верхняя кнопка "Заказать".

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement lowerButton; // Нижняя кнопка "Заказать".

    //Конструктор инициализирующий все элементы(через PageFactory).
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    //Метод кликающий по верхней кнопки "Заказать".
    public void clickOnUpperButton(){
        upperButton.click();
    }

    //Метод кликающий по нижней кнопки "Заказать".
    public void clickOnLowerButton(){
        lowerButton.click();
    }

    //Метод прокручивающий страницу до нижней кнопки "Закзать".
    public void jumpToLowerButton(){
        WebElement element = lowerButton;
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void getPageUrl(){
        driver.get(PAGE_URL);
    }
}

