package tests.ornekler;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebappsecurityPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class Ornek01_Webappsecurity {

    /*
        1. “http://zero.webappsecurity.com/” adresine gidin
        2. Ana sayfanın doğru yüklendiğini doğrulayın
        3. Sign in butonuna tıklayın
        4. Kullanıcı adı alanına “username” yazın
        5. Şifre alanına “password” yazın
        6. Sign in butonuna tıklayın
        7. Başarılı giriş yapıldığını doğrulayın
        8. Online Banking menüsüne tıklayın
        9. “Account Summary” sayfasını açın
        10. Checking Account detaylarını görüntüleyin
        11. Pay Bills sekmesine gidin
        12. “Add New Payee” formunu doldurun (Ad, Adres, Hesap No, Detaylar)
        13. “Add” butonuna basın
        14. Yeni ödeme alıcısının başarıyla eklendiğini doğrulayın
        15. Purchase Foreign Currency sekmesine gidin
        16. “Currency” dropdown menüsünü açın
        17. Dropdown menüsünden “Eurozone” seçeneğini seçin
        18. “Eurozone (euro)” seçildiğini doğrulayın
        19. Dropdown menüsünde toplamda 16 seçenek olduğunu doğrulayın
        20. Dropdown menüsünde "Australia (dollar)" seçeneğinin bulunduğunu doğrulayın
        21. Logout yaparak hesabınızdan çıkış yapın
        22. Sayfayı kapatın
     */

    @Test
    public void webappsecurityTest(){

        //1. “http://zero.webappsecurity.com/” adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

        WebappsecurityPage webappsecurityPage = new WebappsecurityPage();

        //2. Ana sayfanın doğru yüklendiğini doğrulayın
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "http://zero.webappsecurity.com/";

        Assert.assertEquals(actualUrl,expectedUrl);

        //3. Sign in butonuna tıklayın
        webappsecurityPage.anasayfaSignInButton.click();

        //4. Kullanıcı adı alanına “username” yazın
        webappsecurityPage.loginKutusu.sendKeys(ConfigReader.getProperty("toDefaultKullaniciAdi"));

        //5. Şifre alanına “password” yazın
        webappsecurityPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toDefaultPassword"));

        //6. Sign in butonuna tıklayın
        webappsecurityPage.loginSayfasiSignInButton.click();
        ReusableMethods.bekle(2);

        //7. Sayfada geri gelip, başarılı giriş yapıldığını doğrulayın
        Driver.getDriver().navigate().back();
        Assert.assertTrue(webappsecurityPage.usernameDdm.isDisplayed());

        //8. Online Banking menüsüne tıklayın
        webappsecurityPage.onlineBankingMenu.click();

        //9. “Account Summary” sayfasını açın
        webappsecurityPage.accountSummaryLinki.click();

        //10. Checking Account detaylarını görüntüleyin
        System.out.println("Checking Credit Card:"+webappsecurityPage.checkingSatiriList.get(1).getText());
        System.out.println("Checking Balance:"+webappsecurityPage.checkingSatiriList.get(2).getText());

        //11. Pay Bills sekmesine gidin
        webappsecurityPage.tabMenusuPayBillsSekmesi.click();

        //12. “Add New Payee” formunu doldurun (Ad, Adres, Hesap No, Detaylar)
        Faker faker = new Faker();
        webappsecurityPage.addNewPayeeTabButonu.click();

        webappsecurityPage.payeeNameKutusu.sendKeys(faker.name().fullName());
        webappsecurityPage.payeeAdresKutusu.sendKeys(faker.address().fullAddress());
        webappsecurityPage.payeeAccountKutusu.sendKeys(faker.finance().iban());
        webappsecurityPage.payeePayeeDetailsKutusu.sendKeys(faker.phoneNumber().cellPhone());
        ReusableMethods.bekle(1);

        //13. “Add” butonuna basın
        webappsecurityPage.addButonu.click();

        //14. Yeni ödeme alıcısının başarıyla eklendiğini doğrulayın
        Assert.assertTrue(webappsecurityPage.gonderildiYazisiElementi.isDisplayed());

        //15. Purchase Foreign Currency sekmesine gidin
        webappsecurityPage.purchaseForeignCurrencyTabButonu.click();

        //16. “Currency” dropdown menüsünü açın
        //17. Dropdown menüsünden “Eurozone” seçeneğini seçin
        Select selectDdm = new Select(webappsecurityPage.currencyDdm);
        selectDdm.selectByValue("EUR");

        //18. “Eurozone (euro)” seçildiğini doğrulayın
        String expectedEurozoneYazisi = "Eurozone (euro)";
        String actualEurozoneYazisi = selectDdm.getFirstSelectedOption().getText();

        Assert.assertEquals(actualEurozoneYazisi,expectedEurozoneYazisi);

        //19. Dropdown menüsünde toplamda 16 seçenek olduğunu doğrulayın
        int actualToplamSecenekSayisi = selectDdm.getOptions().size();
        int expectedToplamSecenekSayisi = 16;

        Assert.assertEquals(actualToplamSecenekSayisi,expectedToplamSecenekSayisi);

        //20. Dropdown menüsünde "Australia (dollar)" seçeneğinin bulunduğunu doğrulayın
        List<WebElement> currencyDdmList = selectDdm.getOptions();
        List<String> currenctStringList = ReusableMethods.stringListeyeDonustur(currencyDdmList);
        String expectedOption = "Australia (dollar)";

        Assert.assertTrue(currenctStringList.contains(expectedOption));

        //21. Logout yaparak hesabınızdan çıkış yapın
        webappsecurityPage.usernameDdm.click();
        webappsecurityPage.logoutButonu.click();

        //22. Sayfayı kapatın
        Driver.quitDriver();


    }
}
