package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GooglePage {

    public GooglePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@role='combobox']")
    public WebElement aramaKutusu;

    @FindBy (xpath = "//*[text()='Araçlar']")
    public WebElement araclarTabButonu;

    @FindBy (xpath = "//*[@id='result-stats']")
    public WebElement aramaSonucYazisi;

}
