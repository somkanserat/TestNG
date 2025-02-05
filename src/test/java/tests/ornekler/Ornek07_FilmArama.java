package tests.ornekler;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.GooglePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Ornek07_FilmArama {

    /*
            https://www.google.com.tr sayafısna gidin
                "12 kızgın adam"
                "er ryan'ı kurtarmak"
                "vizontele"

            filmlerini aratarak arama sonuç sayılarını yazıdırınız

     */

    @Test
    public void filmArama01(){
        Driver.getDriver().get(ConfigReader.getProperty("toGoogleUrl"));

        GooglePage googlePage = new GooglePage();

        googlePage.aramaKutusu.sendKeys("12 kızgın adam"+ Keys.ENTER);
        googlePage.araclarTabButonu.click();

        System.out.println("'12 kızgın adam' arama sonuç sayısı: "+googlePage.aramaSonucYazisi.getText());
        Driver.quitDriver();
    }

    @Test
    public void filmArama02(){
        Driver.getDriver().get(ConfigReader.getProperty("toGoogleUrl"));

        GooglePage googlePage = new GooglePage();

        googlePage.aramaKutusu.sendKeys("er ryan'ı kurtarmak"+ Keys.ENTER);
        googlePage.araclarTabButonu.click();

        System.out.println("'er ryan'ı kurtarmak' arama sonuç sayısı: "+googlePage.aramaSonucYazisi.getText());
        Driver.quitDriver();
    }

    @Test
    public void filmArama03(){
        Driver.getDriver().get(ConfigReader.getProperty("toGoogleUrl"));

        GooglePage googlePage = new GooglePage();

        googlePage.aramaKutusu.sendKeys("vizontele"+ Keys.ENTER);
        googlePage.araclarTabButonu.click();

        System.out.println("'vizontele' arama sonuç sayısı: "+googlePage.aramaSonucYazisi.getText());
        Driver.quitDriver();
    }
}
