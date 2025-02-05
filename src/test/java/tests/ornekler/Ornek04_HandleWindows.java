package tests.ornekler;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Ornek04_HandleWindows {

    /*
            ● testotomasyonu anasayfa adresine gidin.
            ● Sayfa’nin window handle degerini String bir degiskene atayin
            ● Sayfa title’nin “Otomasyon” icerdigini test edin
            ● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
            ● Sayfa title’nin “Wise Quarter” icerdigini test edin
            ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
            ● Sayfa title’nin “Walmart” icerdigini test edin
            ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
            ● Tüm sayfaları kapatın
         */
    @Test
    public void handleWindowsTesti(){

        //● testotomasyonu anasayfa adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
            // testotomasyonuPAge objesi oluşturup, locate ettiğimiz Webelement'lere obje ile ulaşırız
            // ve gerekli işlemler için kullanırız

        // ● Sayfa’nin window handle degerini String bir degiskene atayin
        String testotomasyonuWhd = Driver.getDriver().getWindowHandle();

        //● Sayfa title’nin “Otomasyon” icerdigini test edin
        String expectedTestotomasyonSayfaTitle = "Otomasyon";
        String actualTestotomasyonSayfaTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTestotomasyonSayfaTitle.contains(expectedTestotomasyonSayfaTitle));

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("toWisequarterUrl"));

        //● Sayfa title’nin “Wise Quarter” icerdigini test edin
        String expectedWisequarterSayfaTitle = "Wise Quarter";
        String actualWisequarterSayfaTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualWisequarterSayfaTitle.contains(expectedWisequarterSayfaTitle));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        Driver.getDriver().get(ConfigReader.getProperty("toWalmartUrl"));


        //● Sayfa title’nin “Walmart” icerdigini test edin
        String expectedWalmartSayfaTitle = "Walmart";
        String actualWalmartSayfaTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualWalmartSayfaTitle.contains(expectedWalmartSayfaTitle));

        //● Ilk acilan sayfaya donun ve testotomasyonu sayfasina dondugunuzu test edin
        Driver.getDriver().switchTo().window(testotomasyonuWhd);

        //expectedTestotomasyonSayfaTitle = "Otomasyon";
        //actualTestotomasyonSayfaTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTestotomasyonSayfaTitle.contains(expectedTestotomasyonSayfaTitle));

        //● Tüm sayfaları kapatın
        Driver.quitDriver();

    }
}
