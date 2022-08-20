package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.Log;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getInstance(String browserName) {
        if (null == driver){
            switch (browserName){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                default: {
                    Log.error("Incorrect browser name");
                    throw new IllegalArgumentException();
                }
            }
        }
        return driver;
    }

    public static void deleteAllCookies(){
        driver.manage().deleteAllCookies();
    }

    public static void closeDriver() {
        if(driver !=null) {
            driver.quit();
            driver = null;
        }
    }
}
