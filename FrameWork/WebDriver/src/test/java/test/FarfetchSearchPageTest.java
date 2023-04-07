package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.FarfetchMainPage;
import page.FarfetchSearchResultPage;
import util.ConfigManager;
import util.DriverUtils;

public class FarfetchSearchPageTest extends CommonConditions {

    @Test
    public void searchGoodsTest(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
            Assert.assertTrue(mainPage.pageIsDisplayed(), "Main page is not shown");
            mainPage.enterDataIntoSearchField(sneakersData.getModel());
            mainPage.clickSearchButton();

        FarfetchSearchResultPage farfetchSearchResultPage = new FarfetchSearchResultPage(driver);
            Assert.assertTrue(farfetchSearchResultPage.pageIsDisplayed(), "Search result page is not shown");
            Assert.assertEquals(farfetchSearchResultPage.getSneakersName(), sneakersData.getName(), "Name of sneakers are not equals");
    }
}
