package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AutomationExercisePage {

    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()=' Products']")
    public WebElement productsButonu;

    @FindBy(xpath = "//*[@id='search_product']")
    public WebElement searchKutusu;

    @FindBy(xpath = "//*[@id='submit_search']")
    public WebElement searchButonu;

    @FindBy(xpath = "//*[text()='Searched Products']")
    public WebElement searchedProductsYazisi;

    @FindBy(xpath = "//*[@class='col-sm-4']")
    public List<WebElement> urunlerList;

    @FindBy(xpath = "//*[text()=' Contact us']")
    public WebElement contactUsButonu;

    @FindBy(xpath = "//*[text()='Get In Touch']")
    public WebElement getInTouchYazisi;

    @FindBy(xpath = "//*[@placeholder='Name']")
    public WebElement contactNameKutusu;

    @FindBy(xpath = "//*[@name='upload_file']")
    public WebElement dosyaSecButonu;

    @FindBy(xpath = "//*[@data-qa='submit-button']")
    public WebElement submitButonu;

    @FindBy(xpath = "//*[text()='Success! Your details have been submitted successfully.']")
    public WebElement successYazisi;

    @FindBy(xpath = "//*[text()=' Home']")
    public WebElement homeButonu;

    @FindBy(xpath = "//*[text()=' Signup / Login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignupYazisi;

    @FindBy(xpath = "//*[@placeholder='Name']")
    public WebElement loginNameKutusu;

    @FindBy(xpath = "(//*[@placeholder='Email Address'])[2]")
    public WebElement loginEmailKutusu;

    @FindBy(xpath = "//*[@data-qa='signup-button']")
    public WebElement loginSignUpButonu;

    @FindBy(xpath = "//*[text()='Enter Account Information']")
    public WebElement signUpEnterAccountInformationYazisi;

    @FindBy(xpath = "//*[@id='id_gender1']")
    public WebElement signUpCinsiyetMrButonu;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement signUpPasswordKutusu;

    @FindBy(xpath = "//*[@id='days']")
    public WebElement signUpDayDdm;

    @FindBy(xpath = "//*[@id='months']")
    public WebElement signUpMonthDdm;

    @FindBy(xpath = "//*[@id='years']")
    public WebElement signUpYearDdm;

    @FindBy(xpath = "//*[@id='first_name']")
    public WebElement signUpFirstNameKutusu;

    @FindBy(xpath = "//*[@id='last_name']")
    public WebElement signUpLastNameKutusu;

    @FindBy(xpath = "//*[@id='company']")
    public WebElement signUpCompanyKutusu;

    @FindBy(xpath = "//*[@id='address1']")
    public WebElement signUpAdress1Kutusu;

    @FindBy(xpath = "//*[@id='country']")
    public WebElement signUpCountryDdm;

    @FindBy(xpath = "//*[@id='state']")
    public WebElement signUpStateKutusu;

    @FindBy(xpath = "//*[@id='city']")
    public WebElement signUpCityKutusu;

    @FindBy(xpath = "//*[@id='zipcode']")
    public WebElement signUpZipcodeKutusu;

    @FindBy(xpath = "//*[@id='mobile_number']")
    public WebElement signUpMobileNumberKutusu;

    @FindBy(xpath = "//*[text()='Create Account']")
    public WebElement signUpCreateAccountButonu;

    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement signUpAccountCreatedYazisi;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement continueButonu;

    @FindBy(xpath = "//a[text()=' Logged in as ']")
    public WebElement loggedInAsYazisi;

    @FindBy(xpath = "//*[@href='/delete_account']")
    public WebElement deleteAccountButonu;

    @FindBy(xpath = "//*[@data-qa='continue-button']")
    public WebElement accountDeletedYazisi;

}
