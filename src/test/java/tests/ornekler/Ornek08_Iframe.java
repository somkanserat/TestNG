package tests.ornekler;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuDiscountPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Ornek08_Iframe {

    /*
        1-https://testotomasyonu.com/discount adresine gidin
        2- Elektronics Products yazisinin gorunur oldugunu test edin
        3- Dell bilgisayar urun isminin 'DELL Core I3 11th Gen' oldugunu test edin
        4- Dell bilgisayar'a tiklayip acilan sayfada urun fiyatinin $399.00 oldugunu test edin.
        5- Ilk window'a donun ve Fashion yazisinin gorunur oldugunu test edin
        6- Sayfayi kapatin
     */

    @Test
    public void test01(){

        //1-https://testotomasyonu.com/discount adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toTestOtomasyonuDiscountUrl"));

        TestOtomasyonuDiscountPage testOtomasyonuDiscountPage = new TestOtomasyonuDiscountPage();

        //2- Elektronics Products yazisinin gorunur oldugunu test edin
        Driver.getDriver().switchTo().frame(testOtomasyonuDiscountPage.iframe1);

        System.out.println(testOtomasyonuDiscountPage.electronicsProductsYazisi.getText());
        Assert.assertTrue(testOtomasyonuDiscountPage.electronicsProductsYazisi.isDisplayed());

        //3- Dell bilgisayar urun isminin 'DELL Core I3 11th Gen' oldugunu test edin

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = testOtomasyonuDiscountPage.dellBilgisayarUrunu.getText();

        Assert.assertEquals(actualUrunIsmi, expectedUrunIsmi);

        //4- Dell bilgisayar'a tiklayip acilan sayfada urun fiyatinin $399.00 oldugunu test edin.
        testOtomasyonuDiscountPage.dellBilgisayarUrunu.click();
        ReusableMethods.urlIleWindowDegistir(Driver.getDriver(),"toHedefUrl");

        String expectedUrunFiyati = "$399.00";
        String actualUrunFiyati = testOtomasyonuDiscountPage.dellUrunFiyati.getText();

        Assert.assertEquals(actualUrunFiyati,expectedUrunFiyati);

        //5- Ilk window'a donun ve Fashion yazisinin gorunur oldugunu test edin
        ReusableMethods.urlIleWindowDegistir(Driver.getDriver(),"https://testotomasyonu.com/discount");
        Driver.getDriver().switchTo().frame(testOtomasyonuDiscountPage.iframe2);

        Assert.assertTrue(testOtomasyonuDiscountPage.fashionYazisi.isDisplayed());

        //6- Sayfayi kapatin
        Driver.quitDriver();

    }
}
