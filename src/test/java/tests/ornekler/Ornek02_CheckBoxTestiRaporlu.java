package tests.ornekler;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckboxesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Ornek02_CheckBoxTestiRaporlu extends TestBaseRapor {

    /*
        a. Verilen web sayfasına gidin. https://the-internet.herokuapp.com/checkboxes
        b. Checkbox1 ve checkbox2 elementlerini locate edin.
        c. Checkbox1 seçili değilse onay kutusunu tıklayın.
        d. Checkbox2 seçili değilse onay kutusunu tıklayın.
        e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin.

           Testin Raporunu hazırlayın.
     */

    @Test
    public void checkboxTesti(){
        extentTest = extentReports.createTest("CheckBox Testi","Checkbox'ların hepsi seçili olmalı");

        //a. Verilen web sayfasına gidin. https://the-internet.herokuapp.com/checkboxes
        Driver.getDriver().get(ConfigReader.getProperty("checkboxUrl"));
        extentTest.info("Kullanıcı 'https://the-internet.herokuapp.com/checkboxes' url'sine gider.");

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        CheckboxesPage checkboxesPage = new CheckboxesPage();

        // c. Checkbox1 seçili değilse onay kutusunu tıklayın

        if (! checkboxesPage.checkbox1.isSelected()){
            checkboxesPage.checkbox1.click();
        }
        extentTest.info("Checkbox1 kontrol edilir ve seçili değilse seçilir.");

        // d. Checkbox2 seçili değilse onay kutusunu tıklayın

        if (! checkboxesPage.checkbox2.isSelected()){
            checkboxesPage.checkbox2.click();
        }
        extentTest.info("Checkbox2 kontrol edilir ve seçili değilse seçilir.");

        // e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(checkboxesPage.checkbox1.isSelected());
        softAssert.assertTrue(checkboxesPage.checkbox2.isSelected());
        extentTest.pass("Tüm checkbox'ların seçili olduğunu test eder.");

        ReusableMethods.bekle(1);
        extentTest.info("Sayfa kapanır.");




    }




}
