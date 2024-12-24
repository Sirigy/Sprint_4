package pageobjects.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDataPage extends BasePage {

    @FindBy(xpath = ".//input[@placeholder='* Имя']")
    private WebElement fieldName; // поле "Имя".

    @FindBy(xpath = ".//input[@placeholder='* Фамилия']")
    private WebElement fieldLastName; // поле "Фамилия".

    @FindBy(xpath = ".//input[@placeholder='* Адрес: куда привезти заказ']")
    private WebElement fieldAddress; // поле "Адрес".

    @FindBy(xpath = ".//input[@placeholder='* Станция метро']")
    private WebElement fieldMetroStation; // поле "Станция метро".

    @FindBy(xpath = ".//input[@placeholder='* Телефон: на него позвонит курьер']")
    private WebElement fieldPhone; // поле "Телефон".

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement buttonNext; // кнопка "Далее".

    //Конструктор инициализирующий все элементы(через PageFactory).
    public UserDataPage(){
        PageFactory.initElements(driver,this);
    }

    //Ввод данных пользователя
    public void userDataEntry(String nameValue,String lastNameValue,String addressValue,String phoneValue){
        fieldName.sendKeys(nameValue);
        fieldLastName.sendKeys(lastNameValue);
        fieldAddress.sendKeys(addressValue);
        fieldMetroStation.sendKeys("Тверская", Keys.ARROW_DOWN,Keys.ENTER);//переход к нужному элементу с помощью стрелки вниз и нажатии enter.
        fieldPhone.sendKeys(phoneValue);
        buttonNext.click();



    }


}
