package test_pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.page.BasePage;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    protected WebDriver driver;
    protected String browser;

    @Before
    public void setUp() {

        //Метод,который получает значение системного свойства browser.
        browser = System.getProperty("browser", "chrome");

        //Это блок условий, который проверяет, какое значение хранится в переменной
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();//Открывается нормальная(полноэкранная) версия браузера
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);//ТаймаутЗагрузкиСтраницы
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//ВремяОжиданияЭлементовНаСтранице
        BasePage.setDriver(driver);//Инициализируем WebDriver в базовом классе страниц
    }

    @After
    public void tearDown() {
        driver.quit();//Закрывае Браузер.

    }
}
