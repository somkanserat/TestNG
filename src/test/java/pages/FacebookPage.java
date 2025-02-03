package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //Driver.getDriver'ı bu page'a tanıttık.

    @FindBy(xpath = "//input[ @id='email']")
    public WebElement emailKutusu;

    @FindBy(id = "pass")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[ @name='login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//*[text()='Yeni hesap oluştur']")
    public WebElement yeniHesapOlusturButonu;




}
