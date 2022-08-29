package test;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import page.FarfetchCartPage;
import page.FarfetchMainPage;
import page.FarfetchOrderPage;
import page.FarfetchSearchResultPage;
import util.ConfigManager;
import util.DriverUtils;

@Ignore
@Deprecated
public class FarfetchOrderPageTest extends CommonConditions{

    private static final String INCORRECT_PHONE_NUMBER_MSG = "Please, enter the correct phone number.";

    @Test
    public void incorrectInputPhoneNumber(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        Assert.assertTrue(mainPage.pageIsDisplayed(), "Main page is not displayed");
        mainPage.clickLoginButton();
        mainPage.enterUserCredentials(testUser);
        mainPage.clickSubmitLogInButton();
        mainPage.enterDataIntoSearchField(sneakersData.getModel());
        mainPage.clickSearchButton();
        FarfetchSearchResultPage searchResultPage = new FarfetchSearchResultPage(driver);
        searchResultPage.addSneakersToCart();
        FarfetchCartPage cartPage = new FarfetchCartPage(driver);
        cartPage = searchResultPage.goToCart();
        FarfetchOrderPage orderPage = new FarfetchOrderPage(driver);
        orderPage = cartPage.goToOrderPage();
        Assert.assertEquals(INCORRECT_PHONE_NUMBER_MSG, orderPage.getWrongNumber());
    }
}
