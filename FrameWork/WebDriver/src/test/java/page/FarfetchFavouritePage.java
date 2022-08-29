package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Deprecated
public class FarfetchFavouritePage extends AbstractPage {

    private WebDriver driver;
    public FarfetchFavouritePage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='wishlistGrid']/article[1]/div/div[2]/a[2]/div/div[2]/div[1]")
    private WebElement sneakerName;

    @FindBy(xpath = "//*[@id='wishlistGrid']/article/div/div[1]/button")
    private WebElement cross;

    @FindBy(xpath = "//*[@id='slice-wishlist']/div[1]/div[1]/div/div/p")
    private WebElement favouriteIsEmpty;

    @FindBy(xpath = "//*[@id='wishlistGrid']/article/div/div[3]/div[2]/button")
    private WebElement addingToCart;

    @FindBy(xpath = " //*[@id='ff-details']/li[4]/a")
    private WebElement goToCartButton;


    public String getSneakerName(){
        return sneakerName.getText();
    }

    public FarfetchFavouritePage deleteGoodsFromFavourite(){
        cross.click();
        return this;
    }

    public String favouriteIsEmpty(){
        return favouriteIsEmpty.getText();
    }

    public FarfetchCartPage goToCartPage(){
        addingToCart.click();
        goToCartButton.click();
        return new FarfetchCartPage(driver);
    }
}
