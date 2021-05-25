package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FarfetchOrderPage extends  AbstractPage{

    @FindBy(xpath = "//*[@id='Phone']")
    private WebElement inputPhone;

    @FindBy(xpath = "//*[@id='PostalCode']")
    private WebElement inputPostalCode;

    @FindBy(xpath = " //*[@id='mod-addressForm']/form/div[1]/div/div[7]/div[2]/div/span[2]")
    private WebElement wrongMessage;

    public String getWrongNumber(){
        waitUntilVisibilityOf(inputPhone);
        inputPhone.sendKeys("1");
        waitUntilVisibilityOf(inputPostalCode);
        inputPostalCode.sendKeys("225792");
        waitUntilVisibilityOf(wrongMessage);
        return wrongMessage.getText();
    }

    @Override
    public FarfetchOrderPage openPage(){
        return this;
    }



    public FarfetchOrderPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }



}
