package tests.ornekler;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Ornek12_ContactUsFrom_Faker_WaitClass {

    /*
        1. 'http://automationexercise.com' adresine gidin
        2. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        3. 'Contact Us' butonuna tıklayın
        4. 'GET IN TOUCH' ifadesinin görünür olduğunu doğrulayın
        5. Adınızı, e-postanızı, konunuzu ve mesajınızı girin
        6. Dosyayı yükleyin
        7. 'Submit' butonuna tıklayın
        8. OK butonuna tıklayın
        9. Başarı mesajının 'Success! Your details have been submitted successfully.' görünürlülüğünü test edin
        10. 'HOME' düğmesine tıklayın ve ana sayfaya başarıyla ulaştığınızı doğrulayın.
    */

    @Test
    public void test01(){
        // 1. 'http://automationexercise.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("toAutomationExerciseUrl"));
        AutomationExercisePage automationExercisePage = new AutomationExercisePage();

        // 2. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String expectedSayfaBaslik = "Automation Exercise";
        String actualSayfaBaslik = Driver.getDriver().getTitle();

        Assert.assertEquals(actualSayfaBaslik,expectedSayfaBaslik);

        // 3. 'Contact Us' butonuna tıklayın
        automationExercisePage.contactUsButonu.click();
        ReusableMethods.bekle(1);

        // 4. 'GET IN TOUCH' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(automationExercisePage.getInTouchYazisi.isDisplayed());

        // 5. Adınızı, e-postanızı, konunuzu ve mesajınızı girin
        Faker faker = new Faker();
        automationExercisePage.contactNameKutusu.sendKeys(
                faker.name().firstName()
                +Keys.TAB +faker.internet().emailAddress()
                +Keys.TAB +faker.university().name()
                +Keys.TAB +faker.address().fullAddress()
        );

        // 6. Dosyayı yükleyin
        String dosyaYolu = "C:/Users/Serat/Desktop/images.jpg";
        automationExercisePage.dosyaSecButonu.sendKeys(dosyaYolu);
        ReusableMethods.bekle(1);

        // 7. 'Submit' butonuna tıklayın
        automationExercisePage.submitButonu.click();
        ReusableMethods.bekle(1);

        // 8. OK butonuna tıklayın
        Driver.getDriver().switchTo().alert().accept();

        // 9. Başarı mesajının 'Success! Your details have been submitted successfully.' görünürlülüğünü test edin
        ReusableMethods.bekle(1);
        Assert.assertTrue(automationExercisePage.successYazisi.isDisplayed());

        // 10. 'HOME' düğmesine tıklayın ve ana sayfaya başarıyla ulaştığınızı doğrulayın.
        automationExercisePage.homeButonu.click();
        Assert.assertEquals(actualSayfaBaslik,expectedSayfaBaslik);

    }
}
