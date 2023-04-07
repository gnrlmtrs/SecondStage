package test;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import page.FarfetchCartPage;
import page.FarfetchFavouritePage;
import page.FarfetchMainPage;
import page.FarfetchSearchResultPage;
import util.ConfigManager;
import util.DriverUtils;

@Ignore
@Deprecated
public class FarfetchCartPageTest extends CommonConditions {

    private static final String EMPTY_BASKET_MESSAGE = "BASKET IS EMPTY";
    @Test
    public void addGoodsToCart(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        mainPage.enterDataIntoSearchField(sneakersData.getModel());
        mainPage.clickSearchButton();
        FarfetchSearchResultPage searchResultPage = new FarfetchSearchResultPage(driver);
        searchResultPage.addSneakersToCart();
        FarfetchCartPage cartPage = new FarfetchCartPage(driver);
        cartPage = searchResultPage.goToCart();
        Assert.assertEquals(sneakersData.getName(), cartPage.getSneakerNumber());
    }

    @Test
    public void deleteGoodsFromCart(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        mainPage.enterDataIntoSearchField(sneakersData.getModel());
        mainPage.clickSearchButton();
        FarfetchSearchResultPage searchResultPage = new FarfetchSearchResultPage(driver);
        searchResultPage.addSneakersToCart();
        FarfetchCartPage cartPage = new FarfetchCartPage(driver);
        cartPage = searchResultPage.goToCart()
                .deleteGoodsFromCart();
        Assert.assertEquals(EMPTY_BASKET_MESSAGE, cartPage.checkedOnEmptyBasket());
    }

    @Test
    public void changeSizeOfSneakers(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        mainPage.enterDataIntoSearchField(sneakersData.getModel());
        mainPage.clickSearchButton();
        FarfetchSearchResultPage searchResultPage = new FarfetchSearchResultPage(driver);
        searchResultPage.addSneakersToCart();
        FarfetchCartPage cartPage = new FarfetchCartPage(driver);
        cartPage = searchResultPage.goToCart();
        Assert.assertEquals(sneakersData.getSize(), cartPage.changeSizeOfSneakers());
    }

    @Test
    public void addGoodsToCartFromFavourite(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        mainPage.enterDataIntoSearchField(sneakersData.getModel());
        mainPage.clickSearchButton();
        FarfetchSearchResultPage searchResultPage = new FarfetchSearchResultPage(driver);
        searchResultPage.addToFavourite();
        FarfetchFavouritePage favouritePage = searchResultPage.goToFavouritePage();
        favouritePage = searchResultPage.goToFavouritePage();
        FarfetchCartPage cartPage = new FarfetchCartPage(driver);
        cartPage = favouritePage.goToCartPage();
        Assert.assertEquals(sneakersData.getName(), cartPage.getSneakerNumber());
    }
}
