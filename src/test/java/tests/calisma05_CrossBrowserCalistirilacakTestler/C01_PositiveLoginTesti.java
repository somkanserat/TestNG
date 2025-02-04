package tests.calisma05_CrossBrowserCalistirilacakTestler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C01_PositiveLoginTesti extends TestBaseCross {
    /*
        Hem chrome'dan hem de edge üzerinden çalıştırma yapabilmek için,
        xmlDosyaları package içerisindeki  CrossBrowserCalistirma xml'in
        içerisinden run edilmesi gerekir.
    */

    @Test
    public void positiveLoginTesti(){

        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        driver.get(ConfigReader.getProperty("toUrl"));
        ReusableMethods.bekle(1);

        // 2- account linkine basin
        driver.findElement(By.xpath("(//span[.='Account'])[1]")).click();
        ReusableMethods.bekle(1);

        // 3- Kullanici email'i olarak gecerli email girin
        WebElement emailKutusu = driver.findElement(By.id("email"));
        emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        // 4- Kullanici sifresi olarak gecerli password girin
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));

        // 5- Login butonuna basarak login olun
        driver.findElement(By.id("submitlogin")).click();
        ReusableMethods.bekle(1);

        // 6- Basarili olarak giris yapilabildigini test edin
        WebElement logoutButonu = driver.findElement(By.xpath("//span[.='Logout']"));

        Assert.assertTrue(logoutButonu.isDisplayed());
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        logoutButonu.click();
    }

}
