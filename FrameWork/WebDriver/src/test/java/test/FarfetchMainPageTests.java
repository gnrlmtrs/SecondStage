package test;

import model.User;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import page.FarfetchMainPage;
import service.UserCreator;

public class FarfetchMainPageTests extends CommonConditions{


    @Test
    public void logInAccountTest() throws InterruptedException {
        User testUser = UserCreator.withCredentialsFromProperty();
            mainPage = new FarfetchMainPage(driver)
                    .openPage()
                    .logInAccount(testUser);
        Assertions.assertEquals(testUser.getUsername(), mainPage.getUserName());
    }


    @Test
    public void wrongAccountDataTest() throws InterruptedException {
        User testUser = UserCreator.withWrongCredentialsFromProperty();
        mainPage = new FarfetchMainPage(driver)
                .openPage()
                .logInAccount(testUser);
        Assertions.assertEquals("Введите действительный адрес электронной почты.",
                mainPage.getWrongMessageText());
    }
}
