package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FarfetchSearchResultPage extends AbstractPage{


    @FindBy(xpath = "//button[@data-tstid='addToWishlist']")
    private WebElement addToFavouriteButton;

    @FindBy(xpath = "//a[@data-tstid='Go_Wishlist']")
    private WebElement goToFavouriteButton;

    @FindBy(xpath = "//a[@data-tstid='cardInfo-title']")
    private WebElement sneakersName;

    @FindBy(xpath = "//div[@id='sizesDropdownTrigger']")
    private WebElement sizeMenu;

    @FindBy(xpath = "//div[@data-value='20']")
    private WebElement chooseSize;

    @FindBy(xpath = "//button[@data-tstid='addToBag']")
    private WebElement addToBag;

    @FindBy(xpath = "//a[@data-tstid='Go_Bag']")
    private WebElement goToBag;

    @Override
    public FarfetchSearchResultPage openPage(){
        return this;
    }

    public FarfetchSearchResultPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSneakersName() throws InterruptedException {
        Thread.sleep(3000);
        return sneakersName.getText();
    }

    public FarfetchSearchResultPage addSneakersToCart() throws InterruptedException {
        waitUntilVisibilityOf(sizeMenu);
        sizeMenu.click();

        waitUntilVisibilityOf(chooseSize);
        chooseSize.click();

        Thread.sleep(3000);

        waitUntilVisibilityOf(addToBag);
        addToBag.click();

        return this;
    }

    public FarfetchSearchResultPage addToFavourite() throws InterruptedException {
        waitUntilVisibilityOf(sizeMenu);
        sizeMenu.click();

        waitUntilVisibilityOf(chooseSize);
        chooseSize.click();

        Thread.sleep(3000);

        waitUntilVisibilityOf(addToFavouriteButton);
        addToFavouriteButton.click();
        return this;
    }

    public FarfetchFavouritePage goToFavouritePage() throws InterruptedException {
        Thread.sleep(3000);
        waitUntilVisibilityOf(goToFavouriteButton);
        goToFavouriteButton.click();
        return new FarfetchFavouritePage(driver);
    }

    public FarfetchCartPage goToCart(){
        waitUntilElementIsClickable(goToBag);
        goToBag.click();
        return new FarfetchCartPage(driver);
    }
}
