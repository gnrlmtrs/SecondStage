package test;

import model.User;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.FarfetchMainPage;
import service.UserCreator;
import util.ConfigManager;
import util.DriverUtils;

public class FarfetchMainPageTests extends CommonConditions{

    protected User testUser;
    protected User userWithWrongCredentials;

    @BeforeTest
    public void preparingData(){
        testUser = UserCreator.withCredentialsFromProperty();
        userWithWrongCredentials = UserCreator.withWrongCredentialsFromProperty();
    }

    @Test
    public void logInAccountTest(){
        DriverUtils.goToPage(ConfigManager.getProperty("mainPageUrl"));
        System.out.println(testUser.toString());
        System.out.println(userWithWrongCredentials.toString());
        FarfetchMainPage mainPage = new FarfetchMainPage(driver);
        Assertions.assertTrue(mainPage.pageIsDisplayed(), "Page is displayed");
        mainPage.clickLoginButton();
//        mainPage.enterUserCredentials(testUser);
//        mainPage.clickSubmitLogInButton();
//        Assertions.assertEquals(testUser.getUsername(), mainPage.getUserName(), "Compare actual data with expected");
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
