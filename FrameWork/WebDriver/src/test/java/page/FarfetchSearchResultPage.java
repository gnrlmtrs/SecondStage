package page;

import elements.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FarfetchSearchResultPage extends AbstractPage{

    private WebDriver driver;
    private static final Text uniqueElement = new Text(By.xpath("//div[contains(@data-test, 'search_panel')]"), "Unique element from Search Result page");
    private static Text sneakersModel = new Text(By.xpath("//h1/a[contains(@class, 'Heading')]"), "Sneakers model");

    @Deprecated
    @FindBy(xpath = "//button[@data-tstid='addToWishlist']")
    private WebElement addToFavouriteButton;

    @Deprecated
    @FindBy(xpath = "//a[@data-tstid='Go_Wishlist']")
    private WebElement goToFavouriteButton;

    @Deprecated
    @FindBy(xpath = "//a[@data-tstid='cardInfo-title']")
    private WebElement sneakersName;

    @Deprecated
    @FindBy(xpath = "//div[@id='sizesDropdownTrigger']")
    private WebElement sizeMenu;

    @Deprecated
    @FindBy(xpath = "//div[@data-value='20']")
    private WebElement chooseSize;

    @Deprecated
    @FindBy(xpath = "//button[@data-tstid='addToBag']")
    private WebElement addToBag;

    @Deprecated
    @FindBy(xpath = "//a[@data-tstid='Go_Bag']")
    private WebElement goToBag;

    public FarfetchSearchResultPage(WebDriver driver){
        super(uniqueElement, "Title From Main Page");
        this.driver = driver;
    }

    public String getSneakersName(){
        return sneakersModel.getTextFromElement();
    }

    @Deprecated
    public FarfetchSearchResultPage addSneakersToCart(){
        sizeMenu.click();
        chooseSize.click();
        addToBag.click();
        return this;
    }

    @Deprecated
    public FarfetchSearchResultPage addToFavourite(){
        sizeMenu.click();
        chooseSize.click();
        addToFavouriteButton.click();
        return this;
    }
    @Deprecated
    public FarfetchFavouritePage goToFavouritePage(){
        goToFavouriteButton.click();
        return new FarfetchFavouritePage(driver);
    }
    @Deprecated
    public FarfetchCartPage goToCart(){
        goToBag.click();
        return new FarfetchCartPage(driver);
    }
}
