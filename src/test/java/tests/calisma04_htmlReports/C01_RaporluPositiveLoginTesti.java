package tests.calisma04_htmlReports;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_RaporluPositiveLoginTesti extends TestBaseRapor {
    /*
        TestNG kendisi HTML rapor olusturamaz

        HTML rapor oluşturabılmek icin farkli dependency'ler kullanılabilir.
        biz aventstack dependency kullandık

         aventstack raporlama icin 3 objeye ihtiyac duyar
         Bu objeleri her class'da olusturmak ve gerekli islemleri yapmak yerine
         bu isslemleri bizim adimiza yapacak bir TestBaseRapor oluşturduk.

         oluşturulmasi gereken 3 obje TestBaseRapor'da olusturuldu
         bu objeleri ve yapilan ayarlari kullanmanin
         en kisa yolu extends keyword ile TestBaseRapor'u parent edinmektir

         TestBaseRapor'da olusturulan 3 objeden
         extentReports ve extentHtmlReporter'a deger atamasi yapildi
         extentTest'e deger atamasi her test method'unda yapilmalidir

         HTML raporda gorunmesini istedigimiz test adimlarini
         extentTest objesi ile rapora işleyebiliriz
     */

    @Test
    public void raporluPositiveLoginTesti(){
        extentTest = extentReports.createTest("Positive Login Testi","Gecerli bilgilerle sisteme giris yapilabilmeli");

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici testotomasyonu anasayfaya gider");

        ReusableMethods.bekle(1);
        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();
        extentTest.info("account linkine basar");

        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        extentTest.info("Kullanici email'i olarak gecerli email girer");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        extentTest.info("Kullanici sifresi olarak gecerli password girer");
        ReusableMethods.bekle(1);

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu.click();
        extentTest.info("Login butonuna basarak login olur");

        // 6- Basarili olarak giris yapilabildigini test edin
        ReusableMethods.bekle(1);
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());
        extentTest.pass("Basarili olarak giris yapilabildigini test eder");

        ReusableMethods.bekle(1);

        // logout olun
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        testotomasyonuPage.logoutButonu.click();
        extentTest.info("Logout butonuna basarak cikis yapar");
        //Driver.quitDriver(); --> Rapor sayfasında kapatma var.
        extentTest.info("sayfayi kapatir");
    }
}
