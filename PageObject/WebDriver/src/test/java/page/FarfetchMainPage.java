package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FarfetchMainPage {

    private static final String HOMEPAGE_URL = "https://www.farfetch.com/by/shopping/men/items.aspx";
    private WebDriver driver;

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

    public FarfetchMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FarfetchMainPage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public FarfetchMainPage logInAccount(String email, String password){
        new WebDriverWait(driver, 10)
        .until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(loginField));
        loginField.sendKeys(email);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(submitDataForLoginButton));
        submitDataForLoginButton.click();

        return this;
    }

    public FarfetchSearchResultPage searchGoods(String goodModel){
        new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//span[text()='Maxim']")));

        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(goodModel);

        new WebDriverWait(driver, 40)
                .until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        return new FarfetchSearchResultPage(driver);
    }

}
