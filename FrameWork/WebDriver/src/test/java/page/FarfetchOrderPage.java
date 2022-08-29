package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Deprecated
public class FarfetchOrderPage extends AbstractPage{

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='Phone']")
    private WebElement inputPhone;

    @FindBy(xpath = "//*[@id='PostalCode']")
    private WebElement inputPostalCode;

    @FindBy(xpath = " //*[@id='mod-addressForm']/form/div[1]/div/div[7]/div[2]/div/span[2]")
    private WebElement wrongMessage;

    public String getWrongNumber(){
        inputPhone.sendKeys("1");
        inputPostalCode.sendKeys("225792");
        return wrongMessage.getText();
    }

    public FarfetchOrderPage(WebDriver driver){
        super();
        PageFactory.initElements(this.driver, this);
    }
}
