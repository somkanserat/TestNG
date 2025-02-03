package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DemoqaPage {

    public DemoqaPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@role='row']/div[@role='columnheader']")
    public List<WebElement> headersList;

    @FindBy(xpath = "//*[@role='row']//*[@role='gridcell']")
    public List<WebElement> datalarList;

    @FindBy(xpath = "//*[@role='rowgroup']//*[@role='gridcell'][3]")
    public List<WebElement> ucuncuSutunElementiList;

    @FindBy(xpath = "//*[@role='rowgroup']")
    public List<WebElement> satirList;


}
