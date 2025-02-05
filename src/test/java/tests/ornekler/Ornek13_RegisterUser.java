package tests.ornekler;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Ornek13_RegisterUser {

    /*
        1. Tarayıcıyı başlatın
        2. 'http://automationexercise.com' adresine gidin
        3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        5. 'New User Signup!'nın görünür olduğunu doğrulayın
        6. Adınızı ve e-posta adresinizi girin
        7. 'Signup' düğmesine tıklayın
        8. 'ENTER ACCOUNT INFORMATION'in görünür olduğunu doğrulayın
        9. Ayrıntıları doldurun: Ünvan, Ad, E-posta, Parola, Doğum tarihi
        10. 'Sign up for our newsletter!' onay kutusunu seçin
        11. 'Receive special offers from our partners!' onay kutusunu seçin
        12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Telefonu Numarası
        13. 'Create Account button' düğmesine tıklayın
        14. 'ACCOUNT CREATED!' görünürlülüğünü doğrulayın
        15. 'Continue' düğmesine tıklayın
        16. 'Logged in as username' ifadesinin görünür olduğunu doğrulayın
        17. 'Delete Account' düğmesine tıklayın
        18. 'ACCOUNT DELETED!' ifadesinin görünür olduğunu doğrulayın ve 'Devam' düğmesine tıklayın
     */

    @Test
    public void test01(){

        // 2. 'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toAutomationExerciseUrl"));
        AutomationExercisePage automationExercisePage = new AutomationExercisePage();

        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String expectedSayfaBaslik = "Automation Exercise";
        String actualSayfaBaslik = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSayfaBaslik,expectedSayfaBaslik);

        // 4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        automationExercisePage.loginButonu.click();

        // 5. 'New User Signup!'nın görünür olduğunu doğrulayın
        softAssert.assertTrue(automationExercisePage.newUserSignupYazisi.isDisplayed());

        // 6. Adınızı ve e-posta adresinizi girin
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        automationExercisePage.loginNameKutusu.sendKeys(firstName);

        String email = faker.internet().emailAddress();
        automationExercisePage.loginEmailKutusu.sendKeys(email);

        //7. 'Signup' düğmesine tıklayın
        automationExercisePage.loginSignUpButonu.click();

        //8. 'ENTER ACCOUNT INFORMATION'in görünür olduğunu doğrulayın
        softAssert.assertTrue(automationExercisePage.signUpEnterAccountInformationYazisi.isDisplayed());

        //9. Ayrıntıları doldurun: Ünvan, Ad, E-posta, Parola, Doğum tarihi
        automationExercisePage.signUpCinsiyetMrButonu.click();
        automationExercisePage.signUpPasswordKutusu.sendKeys(faker.internet().password());
            //day
        Select selectDay = new Select(automationExercisePage.signUpDayDdm);
        selectDay.selectByValue("20");
            //month
        Select selectMonth = new Select(automationExercisePage.signUpMonthDdm);
        selectMonth.selectByVisibleText("December");
            //year
        Select selectYear = new Select(automationExercisePage.signUpYearDdm);
        selectYear.selectByValue("1998");
        ReusableMethods.bekle(1);

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        automationExercisePage.signUpFirstNameKutusu.sendKeys(firstName);
        automationExercisePage.signUpLastNameKutusu.sendKeys(faker.name().lastName());
        automationExercisePage.signUpCompanyKutusu.sendKeys(faker.company().name());
        automationExercisePage.signUpAdress1Kutusu.sendKeys(faker.address().fullAddress());

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        Select selectCountry = new Select(automationExercisePage.signUpCountryDdm);
        selectCountry.selectByValue("United States");

        automationExercisePage.signUpStateKutusu.sendKeys(faker.address().state());
        automationExercisePage.signUpCityKutusu.sendKeys(faker.address().city());
        automationExercisePage.signUpZipcodeKutusu.sendKeys(faker.address().zipCode());
        automationExercisePage.signUpMobileNumberKutusu.sendKeys(faker.phoneNumber().phoneNumber());

        //13. 'Create Account button' düğmesine tıklayın
        automationExercisePage.signUpCreateAccountButonu.click();
        ReusableMethods.bekle(1);

        //14. 'ACCOUNT CREATED!' görünürlülüğünü doğrulayın
        String expectedAccountCreatedYazisi = "ACCOUNT CREATED!";
        String actualAccountCreatedYazisi = automationExercisePage.signUpAccountCreatedYazisi.getText();

        softAssert.assertEquals(actualAccountCreatedYazisi,expectedAccountCreatedYazisi);
        ReusableMethods.bekle(1);

        // 15. 'Continue' düğmesine tıklayın
        automationExercisePage.continueButonu.click();
        ReusableMethods.bekle(1);

        // 16. 'Logged in as username' ifadesinin görünür olduğunu doğrulayın
        String expectedLoggedInAsYazisi = "Logged in as ";
        String actualLoggedInYazisi = automationExercisePage.loggedInAsYazisi.getText();

        softAssert.assertEquals(actualLoggedInYazisi,expectedLoggedInAsYazisi);
        ReusableMethods.bekle(1);

        // 17. 'Delete Account' düğmesine tıklayın
        automationExercisePage.deleteAccountButonu.click();
        ReusableMethods.bekle(1);

        // 18. 'ACCOUNT DELETED!' ifadesinin görünür olduğunu doğrulayın ve 'Devam' düğmesine tıklayın
        softAssert.assertTrue(automationExercisePage.accountDeletedYazisi.isDisplayed());
        ReusableMethods.bekle(2);

        Driver.quitDriver();


    }
}
