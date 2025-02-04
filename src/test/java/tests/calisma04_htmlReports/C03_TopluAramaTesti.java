package tests.calisma04_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_TopluAramaTesti {

    @Test
    public void topluAramaTesti(){
        /*
            1- testotomasyonu sayfasına gidin
            2- verilen ürünlerin her biri için arama yaptırıp
            3- arama sonucunda urun bulunabildiğini test edin
         */


        //phone, java, dress, baby, nutella, samsung, iphone, shirt

        List<String> aranacakUrunlerList = new ArrayList<>(Arrays.asList("phone", "java", "dress", "baby", "nutella", "samsung", "iphone", "shirt"));
        //aranacak kelimeleri list olarak kaydederiz.

        //testotomasyonu sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        SoftAssert softAssert = new SoftAssert();
        // Assert hata verse bile teste devam etmesi için, softAssert objesi oluştururuz.

        for (String eachUrun : aranacakUrunlerList){ // her bir ürün için arama yapmak için, for-each ile tüm ürünleri getirdik.
            testotomasyonuPage.aramaKutusu.sendKeys(eachUrun+ Keys.ENTER); // ürün ismini girdik ve arattık

            String unexpectedAramaSonucu = ConfigReader.getProperty("toUnexpectedSonuc"); // beklenmeyen sonucu configuration.properties olarak kaydettik
            String actualAramaSonucuYazisi = testotomasyonuPage.aramaSonucuElementi.getText();

            softAssert.assertNotEquals(actualAramaSonucuYazisi,unexpectedAramaSonucu,eachUrun+" bulunamadı");
        }

        softAssert.assertAll();
    }
}
