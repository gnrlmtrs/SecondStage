package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Deprecated
public class FarfetchCartPage extends AbstractPage {

    private WebDriver driver;
    public FarfetchCartPage(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='bagWrapper']/div/div[1]/article/div[2]/div[2]/h3/a")
    private WebElement sneakerNumber;

    @FindBy(xpath = "//span[@data-tstid='removeProduct']")
    private WebElement cross;

    @FindBy(xpath = "//*[@id='basketWrapper']/div/section[1]/div/div/div/div[1]/h1")
    private WebElement emptyBasket;

    @FindBy(xpath = "//*[@id='BasketGoToCheckout']")
    private WebElement goToOrderPage;

    @FindBy(xpath = " //*[@id='bagWrapper']/div/div[1]/article/div[2]/div[4]/div[1]/p[1]/a")
    private WebElement changeButton;

    @FindBy(xpath = "//*[@id='form0']/div/a")
    private WebElement chooseNewSize;

    @FindBy(xpath = "//*[@id='form0']/div/div/ul/li[2]")
    private WebElement newSize;

    @FindBy(xpath = "//*[@id='bagWrapper']/div/div[1]/article/div[2]/div[4]/div[1]/span")
    private WebElement theNewestSize;

    public String getSneakerNumber(){
        return sneakerNumber.getText();
    }

    public FarfetchCartPage deleteGoodsFromCart(){
        cross.click();
        return this;
    }

    public String checkedOnEmptyBasket(){
        return emptyBasket.getText();
    }

    public FarfetchOrderPage goToOrderPage(){
        goToOrderPage.click();
        return new FarfetchOrderPage(driver);
    }

    public String changeSizeOfSneakers(){
        changeButton.click();
        chooseNewSize.click();
        newSize.click();

        return theNewestSize.getText();
    }
}
