package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.FarfetchMainPage;
import util.ConfigManager;
import util.DriverUtils;

public class FarfetchMainPageTests extends CommonConditions{

    private static final String ERROR_DATA_MESSAGE = "Incorrect email or password";

    @Test
    public void logInAccountTest(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        Assert.assertTrue(mainPage.pageIsDisplayed(), "Main page is not displayed");
        mainPage.clickLoginButton();
        mainPage.enterUserCredentials(testUser);
        mainPage.clickSubmitLogInButton();
        Assert.assertEquals(testUser.getUsername(), mainPage.getUserName(), "Username is not as expected");
    }

    @Test
    public void wrongAccountDataTest(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        Assert.assertTrue(mainPage.pageIsDisplayed(), "Page is not displayed");
        mainPage.clickLoginButton();
        mainPage.enterUserCredentials(userWithWrongCredentials);
        mainPage.clickSubmitLogInButton();
        Assert.assertEquals(mainPage.getWrongMessageText(), ERROR_DATA_MESSAGE, "Error message is not shown");
    }
}
