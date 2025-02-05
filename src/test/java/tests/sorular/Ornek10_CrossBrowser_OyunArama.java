package tests.sorular;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class Ornek10_CrossBrowser_OyunArama extends TestBaseCross {
    /*
        Bir web sitesini farklı tarayıcılarda (Chrome, Firefox) test eden bir senaryo yazın.
     */

    @Test
    public void oyunAramaTesti(){

        // https://store.steampowered.com/ sayfasına git
        driver.get(ConfigReader.getProperty("toSteamUrl"));

        // arama kutusuna "GTA" yaz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='store_nav_search_term']"));
        aramaKutusu.sendKeys("GTA"+ Keys.ENTER);
        ReusableMethods.bekle(2);

        // 'Dile Göre Daralt' filtre panelinden 'İngilizce' butonuna tıkla
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        WebElement ingilizceDilSecenegiCheckbox = driver.findElement(By.xpath("(//*[@data-value='english'])[1]"));
        ingilizceDilSecenegiCheckbox.click();

        // "Grand Theft Auto V" oyununun görünür olduğunu kontrol et.
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(1);

        WebElement grandTheftAutoVOyunSekmesi = driver.findElement(By.xpath("(//*[text()='Grand Theft Auto V'])[1]"));
        Assert.assertTrue(grandTheftAutoVOyunSekmesi.isDisplayed());
        ReusableMethods.bekle(1);

        // "Grand Theft Auto V" oyununa tıkla
        grandTheftAutoVOyunSekmesi.click();
        ReusableMethods.bekle(1);

        // Doğum tarihini gir ve "Sayfayı Görüntüle" butonuna bas
            //gün
        WebElement gunDdm = driver.findElement(By.xpath("//*[@id='ageDay']"));
        Select selectGun = new Select(gunDdm);
        selectGun.selectByValue("24");
            //ay
        WebElement ayDdm = driver.findElement(By.xpath("//*[@id='ageMonth']"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByVisibleText("Aralık");
            //yıl
        WebElement yilDdm = driver.findElement(By.xpath("//*[@id='ageYear']"));
        Select selectYil = new Select(yilDdm);
        selectYil.selectByValue("1998");
        ReusableMethods.bekle(1);

        WebElement sayfayiGoruntuleButonu = driver.findElement(By.xpath("//*[@id='view_product_page_btn']"));
        sayfayiGoruntuleButonu.click();

        // Oyunun isminin "Grand Theft Auto: San Andreas – The Definitive Edition" olmadığını doğrulayın.
        WebElement oyunIsmi = driver.findElement(By.xpath("//*[@id='appHubAppName']"));

        String unExpectedOyunIsmi = "Grand Theft Auto: San Andreas – The Definitive Edition";
        String actualOyunIsmi = oyunIsmi.getText();

        Assert.assertNotEquals(actualOyunIsmi,unExpectedOyunIsmi);

        // Oyunun çıkış tarihini, fiyatını, türkçe dil desteği olup olmadığını yazdırın
        WebElement oyunCikisTarihi = driver.findElement(By.xpath("//*[@class='date']"));
        WebElement oyununOrjinalFiyati = driver.findElement(By.xpath("(//*[@class='discount_original_price'])[2]"));
        WebElement oyununIndirimliFiyati = driver.findElement(By.xpath("(//*[@class='discount_final_price'])[2]"));
        WebElement turkceDilDestegi = driver.findElement(By.xpath("//*[@class='notice_box_content']"));

        System.out.println(
                "Oyunun Çıkış Tarihi:"+oyunCikisTarihi.getText()
                +"\nOyunun Orjinal Fiyatı:"+oyununOrjinalFiyati.getText()
                +"\nOyunun İndirimli Fiyatı:"+oyununIndirimliFiyati.getText()
                +"\nTürkçe Dil Desteği:"+turkceDilDestegi.getText()
        );


    }
}
