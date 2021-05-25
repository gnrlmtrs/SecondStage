package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 100;
    protected final String BASE_URL = "https://www.farfetch.com/by/shopping/men/items.aspx";


    @FindBy(xpath = "//*[@data-test='go-to-login-desktop']")
    private WebElement logInButton;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@data-tstid='slice-login-sign-in-button']")
    private WebElement submitDataForLoginButton;


    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public FarfetchMainPage logInAccount(User user){
        waitUntilElementIsClickable(logInButton);
        logInButton.click();

        waitUntilVisibilityOf(loginField);
        loginField.sendKeys(user.getEmail());

        waitUntilVisibilityOf(passwordField);
        passwordField.sendKeys(user.getPassword());

        waitUntilElementIsClickable(submitDataForLoginButton);
        submitDataForLoginButton.click();
        return new FarfetchMainPage(driver);
    }


    public WebElement waitUntilPresenceOfElement(By location){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(location));
    }





    public WebElement waitUntilVisibilityOf(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilElementIsClickable(By location){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(location));
    }

    public WebElement waitUntilElementIsClickable(WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }



}
