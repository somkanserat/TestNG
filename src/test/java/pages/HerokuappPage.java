package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerokuappPage {

    public HerokuappPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='hot-spot']")
    public WebElement ciziliAlanElementi;

    @FindBy(xpath = "//*[text()='Elemental Selenium']")
    public WebElement elementalSeleniumButonu;

    @FindBy(tagName = "h1")
    public WebElement h1TagName;
}
