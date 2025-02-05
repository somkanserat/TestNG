package tests.ornekler;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuappPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Ornek05_Actions {

    /*
            1- https://the-internet.herokuapp.com/context_menu sitesine gidin
            2- Cizili alan uzerinde sag click yapin
            3- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
            4- Tamam diyerek alert’i kapatalim
            5- Elemental Selenium linkine tiklayalim
            6- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
            7- Sayfaları kapat
    */

    @Test
    public void actionTesti(){

        //1- https://the-internet.herokuapp.com/context_menu sitesine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toHerokuappUrl"));

        HerokuappPage herokuappPage = new HerokuappPage();

        //2- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(herokuappPage.ciziliAlanElementi).perform();

        //3- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();
        String expectedAlertYazisi = "You selected a context menu";

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //4- Tamam diyerek alert’i kapatalim
        Driver.getDriver().switchTo().alert().accept();

        //5- Elemental Selenium linkine tiklayalim
        actions.click(herokuappPage.elementalSeleniumButonu).perform();

        //6- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        ReusableMethods.urlIleWindowDegistir(Driver.getDriver(),"https://elementalselenium.com/");

        String actualYeniSayfah1TagYazisi = herokuappPage.h1TagName.getText();
        String expectedYeniSayfah1TagYazisi = "Elemental Selenium";

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //7- Sayfaları kapat
        Driver.quitDriver();
    }
}
