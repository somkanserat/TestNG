package tests.ornekler;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class Ornek11_UrunArama {

    /*
            1. 'http://automationexercise.com' url'sine gidin
            2. Ana sayfanın başarıyla görünür olduğunu doğrulayın
            3. 'Ürünler' düğmesine tıklayın
            4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
            5. Arama girişine ürün adını girin ve arama düğmesine tıklayın
            6. 'SEARCHED PRODUCTS'in görünür olduğunu doğrulayın
            7. Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın
    */

    @Test
    public void urunArama(){
        // 1. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toAutomationExerciseUrl"));

        AutomationExercisePage automationExercisePage = new AutomationExercisePage();

        // 2. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String expectedSayfaBaslik = "Automation Exercise";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            //Belirli bir süre, bir olayın gerçekleşmesini beklemek için WebDriverWait class'ından nesne oluştururuz.

        wait.until(ExpectedConditions.titleIs(expectedSayfaBaslik));
            //burda da oluşturduğumuz wait nesnesi için işlemler yaparız.
            // ExpectedConditions... = Beklenilen koşulu ifade ederiz.
            // titleIs --> eşitlik kontrolü
        ReusableMethods.bekle(1);

        // 3. 'Ürünler' düğmesine tıklayın
        automationExercisePage.productsButonu.click();

        // 4. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        wait.until(ExpectedConditions.elementToBeClickable(automationExercisePage.searchKutusu));

        // 5. Arama girişine ürün adını girin ve arama düğmesine tıklayın
        automationExercisePage.searchKutusu.sendKeys("Jeans");
        automationExercisePage.searchButonu.click();

        // 6. 'SEARCHED PRODUCTS'in görünür olduğunu doğrulayın
        wait.until(ExpectedConditions.visibilityOf(automationExercisePage.searchedProductsYazisi));

        // 7. Aramayla ilgili tüm ürünlerin görünür olduğunu doğrulayın
        wait.until(ExpectedConditions.visibilityOfAllElements(automationExercisePage.urunlerList));

        Driver.quitDriver();
    }
}
