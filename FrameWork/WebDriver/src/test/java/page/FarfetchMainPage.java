package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FarfetchMainPage extends AbstractPage{

    @FindBy(xpath = "//*[@data-test='go-to-login-desktop']")
    private WebElement logInButton;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-tstid='slice-login-sign-in-button']")
    private WebElement submitDataForLoginButton;

    @FindBy(xpath = "//input[@data-tstid='Go_Search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-tags='gtm_19']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='ff-drawer-account']/div/div/div[1]/ul/h2")
    private WebElement userAccount;

    @FindBy(xpath = "//*[@id='tabs--6--panel--0']/form/div[1]")
    private WebElement wrongMessage;

//    @FindBy(xpath = "//a[data-test='Go_SignInOrRegister']")
//    private WebElement userName;

    @FindBy(id = "ff-details-account")
    private WebElement userName;


    @Override
    public FarfetchMainPage openPage(){
        driver.navigate().to(BASE_URL);
        return this;
    }



    public FarfetchMainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getWrongMessageText() throws InterruptedException {
        Thread.sleep(2000);
        return wrongMessage.getText();
    }

    public String  getUserName() throws InterruptedException {
        Thread.sleep(10000);
        waitUntilElementIsClickable(userName);
        userName.click();
        waitUntilVisibilityOf(userAccount);
        return userAccount.getText();
    }


    public FarfetchSearchResultPage searchGoods(String goodModel) throws InterruptedException {
        Thread.sleep(5000);

        waitUntilVisibilityOf(searchField);
        searchField.sendKeys(goodModel);

        waitUntilElementIsClickable(searchButton);
        searchButton.click();

        return new FarfetchSearchResultPage(driver);
    }



}
