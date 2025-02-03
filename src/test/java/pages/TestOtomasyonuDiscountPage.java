package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestOtomasyonuDiscountPage {

    public TestOtomasyonuDiscountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//iframe)[1]")
    public WebElement iframe1;

    @FindBy(xpath = "(//iframe)[2]")
    public WebElement iframe2;

    @FindBy(xpath = "//*[text()='Electronics Products']")
    public WebElement electronicsProductsYazisi;

    @FindBy(xpath = "//*[text()='DELL Core I3 11th Gen ']")
    public WebElement dellBilgisayarUrunu;

    @FindBy(xpath = "//*[@id='priceproduct']")
    public WebElement dellUrunFiyati;

    @FindBy(xpath = "//*[text()='Fashion']")
    public WebElement fashionYazisi;
}
