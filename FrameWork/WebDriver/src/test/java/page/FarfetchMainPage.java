package page;

import elements.Button;
import elements.ModalWindow;
import elements.Text;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Log;

public class FarfetchMainPage extends AbstractPage{

    WebDriver driver;
    private static Text title = new Text(By.xpath("//div[contains(@class, '')]/a[contains(@title, 'homepage')]"), "Title From Main Page");
    private static Button logInButton = new Button(By.xpath("//button[@data-test='go-to-login-desktop'][contains(@title, 'Login')]"), "LogIn button");
    private static Text loginField = new Text(By.xpath("//input[@name='email' and @type='email'][contains(@data-testid, 'email-input')]"), "Email Field");
    private static Text passwordField = new Text(By.xpath("//input[@name='password']"), "Password field");
    private static Text userName = new Text(By.xpath("//button[contains(@aria-label,'account')]//span[not (@class)]"), "Username");
    private static ModalWindow loginModalWindow = new ModalWindow(By.xpath("//div[contains(@data-component, 'Modal')][contains(@aria-label, 'LoginModal')]"), "LogIn ModalWindow");
    private static Button submitDataForLoginButton = new Button(By.xpath("//button[contains(@data-testid, 'login-sign-in-button')]"), "Submit login button");

    public FarfetchMainPage(WebDriver driver){
        super(title, "Title From Main Page");
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@data-tstid='Go_Search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-tags='gtm_19']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='ff-drawer-account']/div/div/div[1]/ul/h2")
    private WebElement userAccount;

    @FindBy(xpath = "//*[@id='tabs--6--panel--0']/form/div[1]")
    private WebElement wrongMessage;

    public void clickLoginButton(){
        logInButton.waitForClickable();
        logInButton.click();
    }

    public void enterUserCredentials(User user){
        if(loginModalWindow.isDisplayed()){
            if(loginField.isDisplayed()) {
                loginField.sendText(user.getEmail());
                passwordField.sendText(user.getPassword());
            }
        }
        else{
            Log.error("Modal window is not displayed");
        }
    }

    public void clickSubmitLogInButton(){
        submitDataForLoginButton.click();
    }

    public String getWrongMessageText(){
        return wrongMessage.getText();
    }

    public String getUserName(){
        return userName.getTextFromElement();
    }

//    public FarfetchSearchResultPage searchGoods(String goodModel) throws InterruptedException {
//        Thread.sleep(5000);
//
//        waitUntilVisibilityOf(searchField);
//        searchField.sendKeys(goodModel);
//
//        waitUntilElementIsClickable(searchButton);
//        searchButton.click();
//
//        return new FarfetchSearchResultPage(driver);
//    }
}
