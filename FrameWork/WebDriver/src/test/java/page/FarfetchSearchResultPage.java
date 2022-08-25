package page;

import elements.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FarfetchSearchResultPage extends AbstractPage{

    private WebDriver driver;
    private static final Text uniqueElement = new Text(By.xpath("//div[contains(@data-test, 'search_panel')]"), "Unique element from Search Result page");
    private static Text sneakersModel = new Text(By.xpath("//h1/a[contains(@class, 'Heading')]"), "Sneakers model");

//    @FindBy(xpath = "//button[@data-tstid='addToWishlist']")
//    private WebElement addToFavouriteButton;
//
//    @FindBy(xpath = "//a[@data-tstid='Go_Wishlist']")
//    private WebElement goToFavouriteButton;
//
//    @FindBy(xpath = "//a[@data-tstid='cardInfo-title']")
//    private WebElement sneakersName;
//
//    @FindBy(xpath = "//div[@id='sizesDropdownTrigger']")
//    private WebElement sizeMenu;
//
//    @FindBy(xpath = "//div[@data-value='20']")
//    private WebElement chooseSize;
//
//    @FindBy(xpath = "//button[@data-tstid='addToBag']")
//    private WebElement addToBag;
//
//    @FindBy(xpath = "//a[@data-tstid='Go_Bag']")
//    private WebElement goToBag;

    public FarfetchSearchResultPage(WebDriver driver){
        super(uniqueElement, "Title From Main Page");
        this.driver = driver;
    }

    public String getSneakersName(){
        return sneakersModel.getTextFromElement();
    }
//    public FarfetchSearchResultPage addSneakersToCart() throws InterruptedException {
//        waitUntilVisibilityOf(sizeMenu);
//        sizeMenu.click();
//
//        waitUntilVisibilityOf(chooseSize);
//        chooseSize.click();
//
//        Thread.sleep(3000);
//
//        waitUntilVisibilityOf(addToBag);
//        addToBag.click();
//
//        return this;
//    }
//
//    public FarfetchSearchResultPage addToFavourite() throws InterruptedException {
//        waitUntilVisibilityOf(sizeMenu);
//        sizeMenu.click();
//
//        waitUntilVisibilityOf(chooseSize);
//        chooseSize.click();
//
//        Thread.sleep(3000);
//
//        waitUntilVisibilityOf(addToFavouriteButton);
//        addToFavouriteButton.click();
//        return this;
//    }
//
//    public FarfetchFavouritePage goToFavouritePage() throws InterruptedException {
//        Thread.sleep(3000);
//        waitUntilVisibilityOf(goToFavouriteButton);
//        goToFavouriteButton.click();
//        return new FarfetchFavouritePage(driver);
//    }
//
//    public FarfetchCartPage goToCart(){
//        waitUntilElementIsClickable(goToBag);
//        goToBag.click();
//        return new FarfetchCartPage(driver);
//    }
}
