package pageobjects.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDataPage extends BasePage{

    @FindBy(xpath = ".//input[@placeholder='* Когда привезти самокат']")
    private WebElement fieldDate; // поле "* Когда привезти самокат".

    @FindBy(xpath = ".//div[@class='react-datepicker__day react-datepicker__day--005 react-datepicker__day--weekend react-datepicker__day--outside-month']")
    private WebElement valueData; //значение поля "* Когда привезти самокат".

    @FindBy(xpath = ".//div[@class='Dropdown-control']")
    private WebElement dataLeaseTerm; //поле "* Срок аренды".

    @FindBy(xpath = ".//div[text()='двое суток']")
    private WebElement valueDays; //данные срока аренды.

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private WebElement buttonOrder; //кнопка "Заказать".

    @FindBy(xpath = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM'][text()='Да']")
    private WebElement buttonYes; //кнопка "Да".

    @FindBy(xpath = "//div[@class='Order_ModalHeader__3FDaJ']")
    private WebElement orderPlaced; //заказ оформлен.

    //Конструктор инициализирующий все элементы(через PageFactory).
    public OrderDataPage(){

        PageFactory.initElements(driver,this);
    }
    //Метод возвращающий текс сообщения об успешном создании заказа.
    public String OrderPlaced(){
        return orderPlaced.getText();
    }

    //Ввод данных заказа
    public void orderDataEntry(){
        fieldDate.click();
        valueData.click();
        dataLeaseTerm.click();
        valueDays.click();
        buttonOrder.click();
        buttonYes.click();


    }



}
