package elements;

import driver.DriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ConfigManager;
import util.Log;
import waiter.Waiter;

public abstract class BaseElement {

    private By locator;
    private String name;
    protected WebElement webElement;

    public BaseElement(By locator, String name){
        this.locator = locator;
        this.name = name;
    }

    public By getLocator(){
        return locator;
    }

    public BaseElement(WebElement webElement){
        this.webElement = webElement;
    }

    public String getTextFromElement(){
        return findElement().getText();
    }


    public boolean isDisplayed(){
        Log.info("Element displayed: " + name);
        return findElement().isDisplayed();
    }

    private WebElement findElement(){
        Log.info("Find element: " + name);
        webElement = DriverSingleton.getInstance(ConfigManager.getProperty("browser.type")).findElement(locator);
        return webElement;
    }

    public void sendText(String text){
        findElement().sendKeys(text);
    }

    public String getAttribute(String attribute){
        Log.info("Getting attribute of: " + name);
        return findElement().getAttribute(attribute);
    }

    public void moveMouseToElement(WebDriver driver){
        Log.info("Move mouse to: " + name);
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement()).perform();
    }

    public void setValueWithJSE(WebDriver driver, double randomValue){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + randomValue + "';", findElement());
    }

    public void setNewFontSizeWithJSE(WebDriver driver, String fontSize){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style='font-size: " + fontSize + "';", findElement());
    }

    public String waitAndGetText(){
        Log.info("Wait until element is clickable: " + name);
        return Waiter.getDriverWait().until(ExpectedConditions.visibilityOf(findElement())).getText();
    }

    public void waitForVisibility(){
        Log.info("Wait until element is visible: " + name);
        Waiter.getDriverWait().until(ExpectedConditions.visibilityOf(findElement()));
    }

    public void waitForClickable(){
        Log.info("Wait until element is clickable: " + name);
        Waiter.getDriverWait(). until(ExpectedConditions.elementToBeClickable(findElement()));
    }

    public void click(){
        Log.info("Click on the button: " + name);
        findElement().click();
    }
}
