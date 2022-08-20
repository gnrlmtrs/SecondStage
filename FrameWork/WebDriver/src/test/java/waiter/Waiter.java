package waiter;

import driver.DriverSingleton;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigManager;

public class Waiter {

    private static WebDriverWait driverWait;

    public static WebDriverWait getDriverWait(){
        if(driverWait == null)
            driverWait = new WebDriverWait(DriverSingleton
                .getInstance(ConfigManager.getProperty("browser.type")),
                   Integer.parseInt(ConfigManager.getProperty("timeOutInSeconds")));
        return driverWait;
    }
}
