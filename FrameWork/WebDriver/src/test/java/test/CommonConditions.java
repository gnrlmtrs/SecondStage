package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import page.*;
import util.TestListener;

@Listeners(TestListener.class)
public class CommonConditions {
    protected FarfetchMainPage mainPage;
    protected FarfetchSearchResultPage searchResultPage;
    protected FarfetchCartPage cartPage;
    protected FarfetchOrderPage orderPage;
    protected FarfetchFavouritePage favouritePage;
    protected WebDriver driver;

    @BeforeMethod
    public void init(){
        driver = DriverSingleton.getInstance();
    }



    @AfterMethod(alwaysRun = true)
    public void dispose(){
        DriverSingleton.closeDriver();
    }
}
