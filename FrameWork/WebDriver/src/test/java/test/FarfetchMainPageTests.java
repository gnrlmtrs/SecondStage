package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.FarfetchMainPage;
import util.ConfigManager;
import util.DriverUtils;

public class FarfetchMainPageTests extends CommonConditions{

    @Test
    public void logInAccountTest(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        System.out.println(testUser.toString());
        System.out.println(userWithWrongCredentials.toString());
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        Assert.assertTrue(mainPage.pageIsDisplayed(), "Page is displayed");
        mainPage.clickLoginButton();
//        mainPage.enterUserCredentials(testUser);
//        mainPage.clickSubmitLogInButton();
//        Assert.assertEquals(testUser.getUsername(), mainPage.getUserName(), "Compare actual data with expected");
    }

//    @Test
//    public void wrongAccountDataTest() throws InterruptedException {
//        User testUser = UserCreator.withWrongCredentialsFromProperty();
//        mainPage = new FarfetchMainPage(driver)
//                .openPage()
//                .logInAccount(testUser);
//        Assertions.assertEquals("Введите действительный адрес электронной почты.",
//                mainPage.getWrongMessageText());
//    }
}
