package pageobjects.page;

import org.openqa.selenium.WebDriver;

abstract public class BasePage {

    protected static WebDriver driver;
    //Метод присваивающий WebDriver,который проинициализирован в тестовом(настроичном) классе.
    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;


    }
}