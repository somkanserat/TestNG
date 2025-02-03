package tests.calisma02_testNGFramework_assertions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class C04_PositiveLoginTesti {

    @Test(groups = {"smoke","regression","E2E"})
    public void positiveLoginTesti(){
        /*
            Testlerimizi DINAMIK yapmak
            ve test datalarina KOLAY ERISMEK icin
            test datalarini configuration.properties dosyasina yazip
            ihtiyacimiz oldugunda oradan almak istiyoruz

            Java ile o bilgilere ulasmak icin
            once dosya yolunu almamiz
            sonra oradaki bilgileri okumamiz
            bilgiler icerisinde ihtiyacimiz olan "toUrl", "toGecerliEmail"
            gibi bilgileri diger bilgilerden ayirip
            alip bu test class'ina getirmemiz tek satirla olabilecek bir islem degildir

            Bu uzun islemi bizim adimiza yapip
            verdigimiz "toUrl", "toGecerliEmail" gibi key'lerin
            karsisindaki value'leri alip bize getirecek hazir bir method olusturalim(ConfigReader)
         */

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");

        // 2- account linkine basin

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                            .click();

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys("wise@gmail.com");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys("12345");

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu
                            .click();

        // 6- Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());


        // logout olun
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        testotomasyonuPage.logoutButonu
                .click();

        Driver.quitDriver();
    }


    @Test(groups = {"smoke","regression"})
    public void dinamikPositiveLoginTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));


        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki
                            .click();

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu
                            .click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

        // logout olun
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        testotomasyonuPage.logoutButonu
                            .click();

        ReusableMethods.bekle(1);
        Driver.quitDriver();

    }
}
