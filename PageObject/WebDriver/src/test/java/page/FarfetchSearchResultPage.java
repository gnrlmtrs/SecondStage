package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FarfetchSearchResultPage {
    WebDriver driver;

    @FindBy(xpath = "//button[@data-tstid='addToWishlist']")
    private WebElement addToFavouriteButton;

    @FindBy(xpath = "//a[@data-tstid='Go_Wishlist']")
    private WebElement goToFavouriteButton;

    @FindBy(xpath = "//div[@id='sizesDropdownTrigger']")
    private WebElement sizeMenu;

    @FindBy(xpath = "//div[@data-value='23']")
    private WebElement chooseSize;

    @FindBy(xpath = "//button[@data-tstid='addToBag']")
    private WebElement addToBag;

    @FindBy(xpath = "//a[@data-tstid='Go_Bag']")
    private WebElement goToBag;



    public FarfetchSearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FarfetchSearchResultPage addSneakersToCart(){
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.visibilityOf(sizeMenu));
        sizeMenu.click();

        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(chooseSize));
        chooseSize.click();

        new WebDriverWait(driver, 70).until(ExpectedConditions.presenceOfElementLocated(By
              .xpath("//span[text()='выбран']")));

        new WebDriverWait(driver, 80)
                .until(ExpectedConditions.visibilityOf(addToBag));
        addToBag.click();

        return this;
    }

    public FarfetchSearchResultPage addToFavourite(){
        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.visibilityOf(addToFavouriteButton));
        addToFavouriteButton.click();

        return this;
    }

    public FarfetchFavouritePage goToFavouritePage() throws InterruptedException {
        Thread.sleep(3000);
        new WebDriverWait(driver, 50)
                .until(ExpectedConditions.visibilityOf(goToFavouriteButton));
        goToFavouriteButton.click();
        return new FarfetchFavouritePage(driver);
    }

    public FarfetchCartPage goToCart(){

        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(goToBag));
        goToBag.click();
        return new FarfetchCartPage(driver);
    }





}
