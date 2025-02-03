package tests.calisma02_testNGFramework_assertions;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebDriverUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_WebUniversityTest {

    /*
        1."https://webdriveruniversity.com/" adresine gidin
        2."Login Portal" a  kadar asagi inin
        3."Login Portal" a tiklayin
        4.Diger window'a gecin
        5."username" ve  "password" kutularina deger yazdirin
        6."login" butonuna basin
        7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        8.Ok diyerek Popup'i kapatin
        9.Ilk sayfaya geri donun
        10.Ilk sayfaya donuldugunu test edin
     */

    @Test
    public void popupTest(){

        //1."https://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("https://webdriveruniversity.com/");

        WebDriverUniversityPage webDriverUniversityPage = new WebDriverUniversityPage();
        ReusableMethods.bekle(2);

        //2."Login Portal" a  kadar asagi inin

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView({block: 'center'}); ", webDriverUniversityPage.loginPortalElementi);
        ReusableMethods.bekle(2);

        //3."Login Portal" a tiklayin
        webDriverUniversityPage.loginPortalElementi
                                .click();

        //4.Diger window'a gecin
        ReusableMethods.titleIleWindowDegistir(Driver.getDriver(),"WebDriver | Login Portal");
        ReusableMethods.bekle(2);
        //5."username" ve  "password" kutularina deger yazdirin
        Faker faker = new Faker();

        webDriverUniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webDriverUniversityPage.passwordKutusu.sendKeys(faker.internet().password());

        //6."login" butonuna basin
        webDriverUniversityPage.loginButonu.click();
        ReusableMethods.bekle(2);

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedPopupYazi = "validation failed";
        String actualPopupYazi = Driver.getDriver()
                                        .switchTo()
                                        .alert()
                                        .getText();

        Assert.assertEquals(actualPopupYazi,expectedPopupYazi);

        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver().switchTo()
                            .alert()
                            .accept();


        ReusableMethods.bekle(2);

        //9.Ilk sayfaya geri donun
        ReusableMethods.urlIleWindowDegistir(Driver.getDriver(),"https://webdriveruniversity.com/");

        //10.Ilk sayfaya donuldugunu test edin

        Assert.assertTrue(webDriverUniversityPage.loginPortalElementi.isDisplayed());

        ReusableMethods.bekle(2);
        Driver.quitDriver();

    }
}
