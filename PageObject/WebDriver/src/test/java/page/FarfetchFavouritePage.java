package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FarfetchFavouritePage {
    WebDriver driver;

    public FarfetchFavouritePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='wishlistGrid']/article/div/div[2]/a[2]/div/div[2]/div[2]")
    private WebElement sneakerName;

    public String getSneakerName(){
        return sneakerName.getText();
    }
}
