package tests.calisma04_htmlReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_TopluNegativeLoginTesti {


    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    //3- asagidaki listede verilen email ve sifreleri yazin
    //4- Login butonuna basarak login olmayi deneyin
    //5- Basarili olarak giris yapilamadigini test edin
    //   anil@hotmail.com  13579

    @DataProvider
    public static Object[][] emailPasswordProvider() {

        String[][] emailPasswordArr = { // iki katlı olmasının avantajı. Tek katlı olsaydı
                                        //{"serat@hotmail.com","1234","anil@hotmail.com", "13579"} hangisinin email
                                        //hangisinin password olacağını bilemeyeckti
                                        {"anil@hotmail.com", "13579"},
                                        {"ceren@gmail.com", "24680"},
                                        {"cansu@yahoo.com","asdfgh"}
                                        // 2 katlı olmasının avantajı budur.
                                        // burada tek süslü parantez içerisine 2 değer,tek eleman olur
                                        };

        return emailPasswordArr;
    }


    @Test(dataProvider = "emailPasswordProvider")
    public void negatifLoginTesti(String verilenEmail , String verilenSifre){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.accountLinki.click();

        //3- parametre olarak verilen email ve sifreleri yazin
        testotomasyonuPage.emailKutusu.sendKeys(verilenEmail);
        testotomasyonuPage.passwordKutusu.sendKeys(verilenSifre);

        //4- Login butonuna basarak login olmayi deneyin
        testotomasyonuPage.loginButonu.click();

        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.emailKutusu.isDisplayed());

        Driver.quitDriver();

    }
}
