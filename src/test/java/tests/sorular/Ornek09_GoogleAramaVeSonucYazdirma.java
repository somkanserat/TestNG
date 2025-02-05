package tests.sorular;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Ornek09_GoogleAramaVeSonucYazdirma {

    /*
        Google'da bir arama yapın ve sonuçların doğru olduğunu kontrol edin.
     */

    @Test
    public void googleArama(){

        //google'a git
        Driver.getDriver().get(ConfigReader.getProperty("toGoogleUrl"));

        GooglePage googlePage = new GooglePage();

        //arama kutusuna "trendyol" yaz ve ara
        googlePage.aramaKutusu.sendKeys("trendyol"+ Keys.ENTER);

        //Arama sonuç yazısını yazdırın
        googlePage.araclarTabButonu.click();

        System.out.println("Trendyol Arama Sonucu: "+googlePage.aramaSonucYazisi.getText());

        //Sayfayı kapat
        Driver.quitDriver();

    }
}
