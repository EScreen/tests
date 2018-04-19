package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 06/04/2018.
 */
public class CreateNewClipPage {
    public SelenideElement searchField = $(By.xpath("//*[@id=\"template-name-search\"]/input"));
    public SelenideElement categoriesSelect = $(By.xpath("//*[@id=\"template-categories-select\"]/form/div/div/span"));
    public SelenideElement orientationSelect = $(By.xpath("//*[@id=\"template-orientation-select\"]/form/div/div/span"));
    public SelenideElement portraitOrientation = $(By.xpath("//*[@id=\"template-orientation-select\"]/form/div/div/div/div[2]/span[1]"));
    public SelenideElement templateforTest = $(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div[3]/div/div[1]/div[1]/ul/li[1]/div/a"));
    public SelenideElement nextButton = $(By.cssSelector("#simplemodal-data > div.wizard-modal-footer > div > button.btn.wizard-next.btn-blue.ng-scope"));
    public SelenideElement templateTestNameField = $(By.id("fragmentname"));
    public SelenideElement templateSummaryTab = $(By.xpath("//a[@data-info=\"summary\"]"));
    public SelenideElement templateAvailableforAllUsers = $(By.xpath("//ins[@class=\"iCheck-helper\"]"));
    public SelenideElement templateExistedPlaylistField = $(By.xpath("//li[@class=\"select2-search-field\"]/input"));
    public SelenideElement firstExistedPlaylist = $(By.xpath("//div[@ng-bind-html=\"playlist.name | highlight: $select.search\"]"));
    public SelenideElement templateTestDurationField = $(By.xpath("//input[@name=\"duration1\"]"));
    public SelenideElement saveClipButton = $(By.xpath("//*[@id=\"simplemodal-data\"]/div[4]/div/span[2]/button[3]"));
    public SelenideElement category = $(By.xpath("//div[@class=\"scroller-content\"]/span[2]"));
    public SelenideElement nameOfActualCategory = $(By.xpath("//div[@class=\"row-fluid box-tour\"]/div/h3"));
    public SelenideElement portraitTemplate = $(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div[1]/div/div[1]/div[1]/ul/li/div/img"));
    public SelenideElement nameOfClip = $(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div/div/div[1]/div[1]/ul/li/div/a"));




    public void checkAvailableForUsers(){
        try{
            $(By.xpath("//*[@class=\"icheckbox_flat-aero")).click();
        }catch (Exception e){
        }
    }

    public void unCheckAvailableForUsers(){
        try{
            $(By.xpath("//*[@class=\"icheckbox_flat-aero checked\"]")).click();
        }catch (Exception e){
        }
    }

}
