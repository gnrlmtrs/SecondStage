package test;

import driver.DriverSingleton;
import model.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import service.UserCreator;
import util.ConfigManager;
import util.TestListener;

@Listeners(TestListener.class)
public class CommonConditions {

    protected WebDriver driver;
    protected User testUser;
    protected User userWithWrongCredentials;

    @BeforeMethod
    public void init(){
        driver = DriverSingleton.getInstance(ConfigManager.getProperty("browser.type"));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void dispose(){
        DriverSingleton.closeDriver();
    }

    @BeforeSuite
    public void preparingData(){
        testUser = UserCreator.withCredentialsFromProperty();
        userWithWrongCredentials = UserCreator.withWrongCredentialsFromProperty();
    }
}
