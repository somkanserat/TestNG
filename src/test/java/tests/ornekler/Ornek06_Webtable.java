package tests.ornekler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Ornek06_Webtable {

    /*
            1. “https://demoqa.com/webtables” sayfasina gidin
            2. Headers da bulunan basliklari yazdirin
            3. 3.sutunun basligini yazdirin
            4. Tablodaki tum datalari yazdirin
            5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
            6. Tablodaki satir sayisini yazdirin
            7. Tablodaki sutun sayisini yazdirin
            8. Tablodaki 3.kolonu yazdirin
            9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
            10. Method olusturun, Test sayfasindan satir ve sutun
            sayisini girdigimde bana datayi yazdirsin
    */

    @Test
    public void webtableTesti(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("todemoqaUrl"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        DemoqaPage demoqaPage = new DemoqaPage();

        //2. Headers da bulunan basliklari yazdirin
        System.out.println("Başlıklar Listesi:"+ReusableMethods.stringListeyeDonustur(demoqaPage.headersList));

        //3. 3.sutunun basligini yazdirin
        System.out.println("3.Sütunun Başlığı:"+demoqaPage.headersList.get(2).getText());

        //4. Tablodaki tum datalari yazdirin
        System.out.println("Tüm datalar:"+ReusableMethods.stringListeyeDonustur(demoqaPage.datalarList));

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        int bosOlmayanData = 0;
        String unExpectedData = "";

        for (WebElement eachDataElement : demoqaPage.datalarList){
            //1.ADIM: Dataların içerisindeki boşluk değerlerini, hüçlik ile değiştirdik.
            //2.ADIM: Data değerlerini, beklenmeyenData(hiçlik) değeri ile karşılaştırdık
            if ( ! (eachDataElement.getText().replaceAll("\\s","").equals(unExpectedData)) ){
                bosOlmayanData++;
                //3.ADIM: EĞER value değerleri, unExpectedData'ya eşit değilse (Value değeri, hiçlik değilse)
                //        boşOlmayanData değerini arttırdık
            }
        }
        System.out.println("Boş Olmayan Data Sayısı:"+bosOlmayanData);

        //6. Tablodaki satir sayisini yazdirin
        System.out.println("Webtable Satır Sayısı:"+demoqaPage.satirList.size());

        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("Webtable Sütun Sayısı:"+demoqaPage.headersList.size());

        //8. Tablodaki 3.kolonu yazdirin
        System.out.println("Webtable 3.Sütun Elementleri:");
        for (WebElement eachElement : demoqaPage.ucuncuSutunElementiList){
            System.out.println(eachElement.getText());
        }

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        for (int i=0; i<demoqaPage.datalarList.size(); i++){
            String isim = demoqaPage.datalarList.get(i).getText();
            if (isim.equals("Kierra")){
                System.out.println("Kierranın Maaşı:"+demoqaPage.datalarList.get(i+4).getText());
            }
        }

        //10. Method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        System.out.println(getHucreData(2, 2));
        System.out.println(getHucreData(3, 4));
        System.out.println(getHucreData(7, 5));


    }
    //10.Adım için oluşturulan metot.
    public String getHucreData(int satirNo,int sutunNo){

        String dinamikXpath = "(//div[@role='row'])["+(satirNo+1)+"]/div[@role='gridcell']["+sutunNo+"]";
        WebElement hedefData = Driver.getDriver().findElement(By.xpath(dinamikXpath));
        return hedefData.getText();
    }
}
