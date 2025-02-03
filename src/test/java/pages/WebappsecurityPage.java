package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WebappsecurityPage {

    public WebappsecurityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='signin_button']")
    public WebElement anasayfaSignInButton;

    @FindBy(xpath = "//*[@value='Sign in']")
    public WebElement loginSayfasiSignInButton;

    @FindBy(xpath = "//*[@id='user_login']")
    public WebElement loginKutusu;

    @FindBy(xpath = "//*[@id='user_password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "(//*[@class='dropdown-toggle'])[2]")
    public WebElement usernameDdm;

    @FindBy(xpath = "//*[@id='logout_link']")
    public WebElement logoutButonu;

    @FindBy(xpath = "//*[@id='onlineBankingMenu']")
    public WebElement onlineBankingMenu;

    @FindBy(xpath = "//*[@id='account_summary_link']")
    public WebElement accountSummaryLinki;

    @FindBy(xpath = "((//tbody)//tr)[4]//td")
    public List<WebElement> checkingSatiriList;

    @FindBy(xpath = "//*[@id='pay_bills_tab']")
    public WebElement tabMenusuPayBillsSekmesi;

    @FindBy(xpath = "//*[text()='Add New Payee']")
    public WebElement addNewPayeeTabButonu;

    @FindBy(xpath = "//*[@id='np_new_payee_name']")
    public WebElement payeeNameKutusu;

    @FindBy(xpath = "//*[@id='np_new_payee_address']")
    public WebElement payeeAdresKutusu;

    @FindBy(xpath = "//*[@id='np_new_payee_account']")
    public WebElement payeeAccountKutusu;

    @FindBy(xpath = "//*[@id='np_new_payee_details']")
    public WebElement payeePayeeDetailsKutusu;

    @FindBy(xpath = "//*[@id='add_new_payee']")
    public WebElement addButonu;

    @FindBy(xpath = "//*[@id='alert_content']")
    public WebElement gonderildiYazisiElementi;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyTabButonu;

    @FindBy(xpath = "//*[@id='pc_currency']")
    public WebElement currencyDdm;





}
