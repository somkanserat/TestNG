package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookHesapOlusturPage {

    public FacebookHesapOlusturPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@aria-label='Adın']")
    public WebElement adinKutusu;

    @FindBy(xpath = "//*[@aria-label='Soyadın']")
    public WebElement soyadinKutusu;

    @FindBy(xpath = "//*[@id='day']")
    public WebElement gunDdm;

    @FindBy(xpath = "//*[@id='month']")
    public WebElement ayDdm;

    @FindBy(xpath = "//*[@id='year']")
    public WebElement yilDdm;

    @FindBy(xpath = "(//*[@id='sex'])[1]")
    public WebElement cinsiyetKadinRadioButton;

    @FindBy(xpath = "(//*[@id='sex'])[2]")
    public WebElement cinsiyetErkekRadioButton;

    @FindBy(xpath = "(//*[@id='sex'])[3]")
    public WebElement cinsiyetOzelRadioButton;

    @FindBy(xpath = "//*[@aria-label='Cep telefonu numarası veya e-posta']")
    public WebElement cepNoVeyaEpostaKutusu;

    @FindBy(xpath = "//*[@aria-label='Yeni şifre']")
    public WebElement yeniSifreKutusu;


}
