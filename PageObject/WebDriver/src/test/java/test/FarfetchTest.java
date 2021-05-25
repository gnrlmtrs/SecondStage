package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.*;

public class FarfetchTest {
    public static WebDriver driver;
    public static FarfetchMainPage mainPage;
    public static FarfetchSearchResultPage searchResultPage;
    public static FarfetchCartPage cartPage;
    public static FarfetchFavouritePage favouritePage;
    public final String expectedSneakersNumber = "16114583";
    public final String expectedSneakerName = "кроссовки Yeezy Boost 'Onyx' 380";

    @BeforeEach
    public void browserSetUp(){
       System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
       driver = new ChromeDriver();


        driver.manage().window().maximize();
    }

    @Test
    public void addToBagTest(){
            mainPage = new FarfetchMainPage(driver)
                .openPage()
                .logInAccount("maxim.pernach@mail.ru", "123maxi321");
            searchResultPage = mainPage.searchGoods("FZ1270")
                    .addSneakersToCart();
            cartPage = searchResultPage.goToCart();
            Assertions.assertEquals(expectedSneakersNumber, cartPage.getSneakerNumber());
    }


    @Test
    public void addGoodsToFavourite() throws InterruptedException {
            mainPage = new FarfetchMainPage(driver)
                .openPage()
                .logInAccount("maxim.pernach@mail.ru", "123maxi321");
            searchResultPage = mainPage.searchGoods("FZ1270")
                .addToFavourite();
            favouritePage = searchResultPage.goToFavouritePage();
            Assertions.assertEquals(expectedSneakerName, favouritePage.getSneakerName());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
        driver = null;
    }


}
