package page;

import elements.Button;
import elements.ModalWindow;
import elements.Text;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    private static Text searchField = new Text(By.xpath("//input[@id='search']"), "Search field");
    private static Text incorrectEmailOrPasswordError = new Text(By.xpath("//div[contains(@data-component, 'AlertError')]//p"), "Incorrect data error");
    private static Button searchButton = new Button(By.xpath("//form//button[contains(@aria-label, 'Search')]"), "Search button");

    public FarfetchMainPage(WebDriver driver){
        super(title, "Title From Main Page");
        this.driver = driver;
    }

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
        try {
            return incorrectEmailOrPasswordError.getTextFromElement();
        }
        catch(Exception ex){
            Log.error("Username and password are correct.");
            return null;
        }
    }

    public String getUserName(){
        return userName.getTextFromElement();
    }

    public void enterDataIntoSearchField(String goodModel){
        searchField.sendText(goodModel);
    }

    public void clickSearchButton(){
        searchButton.click();
    }
}
