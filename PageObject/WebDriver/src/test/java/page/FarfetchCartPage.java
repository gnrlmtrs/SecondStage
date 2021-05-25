package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FarfetchCartPage {
    WebDriver driver;

    public FarfetchCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-tstid='Div_Product_ItemID_ShoppingBag']")
    private WebElement sneakerNumber;

    public String getSneakerNumber(){
        return sneakerNumber.getText();
    }

}
