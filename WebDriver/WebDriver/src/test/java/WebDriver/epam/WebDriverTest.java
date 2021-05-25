package WebDriver.epam;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverTest {
    WebDriver driver;



    @BeforeEach()
    public void browserSetUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addProductToCartTest() throws InterruptedException {
        driver.get("https://www.farfetch.com/by/shopping/men/items.aspx");

        WebElement signIn = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.elementToBeClickable(By
            .xpath("//*[@data-test='go-to-login-desktop']")));
        signIn.click();


        WebElement loginField = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.visibilityOfElementLocated(By
            .xpath("//input[@name='email']")));
        loginField.sendKeys("maxim.pernach@mail.ru");

        WebElement passwordField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//input[@name='password']")));
        passwordField.sendKeys("123maxi321");

        WebElement signInButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//button[@data-tstid='slice-login-sign-in-button']")));
        signInButton.click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By
                                                    .xpath("//span[text()='Maxim']")));


        WebElement searchField = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//input[@data-tstid='Go_Search']")));
        searchField.sendKeys("FZ1270");


        WebElement searchButton = (new WebDriverWait(driver, 40))
                .until(ExpectedConditions.elementToBeClickable(By
                        .xpath("//button[@data-tags='gtm_19']")));
        searchButton.click();

        WebElement sizeMenu = (new WebDriverWait(driver, 50))
                .until(ExpectedConditions.elementToBeClickable(By
                .xpath("//div[@id='sizesDropdownTrigger']")));
        sizeMenu.click();

        WebElement chooseSize = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[@data-value='29']")));
        chooseSize.click();

        new WebDriverWait(driver, 70).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//span[text()='выбран']")));

        WebElement addToBag = (new WebDriverWait(driver, 80))
                .until(ExpectedConditions.elementToBeClickable(By
                .xpath("//button[@data-tstid='addToBag']")));
        addToBag.click();

        WebElement goBag = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By
                .xpath("//a[@data-tstid='Go_Bag']")));
        goBag.click();

        Assertions.assertEquals("16114583", driver.findElement(By
           .xpath("//span[@data-tstid='Div_Product_ItemID_ShoppingBag']")).getText());



    }

    @AfterEach
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
