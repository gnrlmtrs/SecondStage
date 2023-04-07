package util;

import driver.DriverSingleton;

public class DriverUtils {

    public static String getCurrentUrl(){
        return DriverSingleton.getInstance(ConfigManager.getProperty("browser.type")).getCurrentUrl();
    }

    public static void goToPage(String pageName){
        DriverSingleton.getInstance(ConfigManager.getProperty("browser.type")).navigate().to(pageName);
    }

    public static void goBack(){
        DriverSingleton.getInstance(ConfigManager.getProperty("browser.type")).navigate().back();
    }

    public static void goForward(){
        DriverSingleton.getInstance(ConfigManager.getProperty("browser.type")).navigate().forward();
    }

    public static void refreshPage(){
        DriverSingleton.getInstance(ConfigManager.getProperty("browser.type")).navigate().refresh();
    }
}
