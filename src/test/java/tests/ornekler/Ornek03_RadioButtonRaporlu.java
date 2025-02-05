package tests.ornekler;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.FacebookHesapOlusturPage;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Ornek03_RadioButtonRaporlu extends TestBaseRapor {

    /*
        a. Verilen web sayfasına gidin. https://facebook.com
        b. Cookies’i kabul edin
        c. Create an account buton’una basin
        d. Tüm bilgileri doldurun
        e. Raporlayın
    */

    @Test
    public void radioButtonTest(){

        extentTest = extentReports.createTest("Facebook'a Kaydolma Testi");

        // a. Verilen web sayfasına gidin. https://facebook.com
        Driver.getDriver().get(ConfigReader.getProperty("tofacebookUrl"));
        extentTest.info("Facebook Anasayfasına gider.");

        FacebookPage facebookPage = new FacebookPage();

        // b. Cookies’i kabul edin

        // c. Create an account buton’una basin
        facebookPage.yeniHesapOlusturButonu.click();
        extentTest.info("Facebook 'Yeni Hesap Oluştur Sayfasına' gider.");

        // d. Tüm bilgileri doldurun
        FacebookHesapOlusturPage facebookHesapOlusturPage = new FacebookHesapOlusturPage();

        Faker faker = new Faker();

        ReusableMethods.bekle(1);

        facebookHesapOlusturPage.adinKutusu.sendKeys(faker.name().firstName());
        facebookHesapOlusturPage.soyadinKutusu.sendKeys(faker.name().lastName());
        extentTest.info("İsim & Soyisim dolduruldu.");

        Select selectgunDdm = new Select(facebookHesapOlusturPage.gunDdm);
        selectgunDdm.selectByValue("25");

        Select selectayDdm = new Select(facebookHesapOlusturPage.ayDdm);
        selectayDdm.selectByVisibleText("May");

        Select selectyilDdm = new Select(facebookHesapOlusturPage.yilDdm);
        selectyilDdm.selectByVisibleText("2000");
        extentTest.info("Doğum günü girer.");

        facebookHesapOlusturPage.cinsiyetErkekRadioButton.click();
        extentTest.info("Cinsiyet girer.");

        facebookHesapOlusturPage.cepNoVeyaEpostaKutusu.sendKeys(faker.phoneNumber().cellPhone());
        facebookHesapOlusturPage.yeniSifreKutusu.sendKeys(faker.internet().password());

        extentTest.info("Telefon Numarası & Şifre girilir.");

        ReusableMethods.bekle(5);
    }
}
