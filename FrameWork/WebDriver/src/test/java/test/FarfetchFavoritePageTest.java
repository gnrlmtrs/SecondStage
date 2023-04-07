package test;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import page.FarfetchFavouritePage;
import page.FarfetchMainPage;
import page.FarfetchSearchResultPage;
import util.ConfigManager;
import util.DriverUtils;

@Ignore
@Deprecated
public class FarfetchFavoritePageTest extends CommonConditions{

    private static final String EMPTY_FAVOURITES = "Save your favourite items to start building your wishlist";

    @Test
    public void addGoodsToFavourite(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        mainPage.enterDataIntoSearchField(sneakersData.getModel());
        mainPage.clickSearchButton();
        FarfetchSearchResultPage searchResultPage = new FarfetchSearchResultPage(driver);
        searchResultPage.addToFavourite();
        FarfetchFavouritePage favouritePage = searchResultPage.goToFavouritePage();
        Assert.assertEquals(sneakersData.getName(), favouritePage.getSneakerName());
    }

    @Test
    public void deleteGoodsFromFavourite(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        mainPage.enterDataIntoSearchField(sneakersData.getModel());
        mainPage.clickSearchButton();
        FarfetchSearchResultPage searchResultPage = new FarfetchSearchResultPage(driver);
        searchResultPage.addToFavourite();
        FarfetchFavouritePage favouritePage = searchResultPage.goToFavouritePage();
        Assert.assertEquals(EMPTY_FAVOURITES,
                favouritePage.favouriteIsEmpty());
    }
}
