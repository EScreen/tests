package pages.mediaPages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 06/04/2018.
 */
public class CreateNewClipPage {

    public String testTemplateName = "FAMAS Plattegrond";

    public SelenideElement searchField = $(By.xpath("//*[@id=\"template-name-search\"]/input"));
    public SelenideElement categoriesSelect = $(By.xpath("//*[@id=\"template-categories-select\"]/form/div/div/span"));
    public SelenideElement orientationSelect = $(By.xpath("//*[@id=\"template-orientation-select\"]/form/div/div/span"));
    public SelenideElement portraitOrientation = $(By.xpath("//*[@id=\"template-orientation-select\"]/form/div/div/div/div[2]/span[1]"));



    public SelenideElement newClipButton = $(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div/div/div[1]/div[1]/ul/li/div/a"));
    public SelenideElement nextButton = $(By.cssSelector("#simplemodal-data > div.wizard-modal-footer > div > button.btn.wizard-next.btn-blue.ng-scope"));
    public SelenideElement templateTestNameField = $(By.id("fragmentname"));
    public SelenideElement templateSummaryTab = $(By.xpath("//a[@data-info=\"summary\"]"));
    public SelenideElement templateExistedPlaylistField = $(By.xpath("//li[@class=\"select2-search-field\"]/input"));
    public SelenideElement firstExistedPlaylist = $(By.xpath("//div[@ng-bind-html=\"playlist.name | highlight: $select.search\"]"));
    public SelenideElement templateTestDurationField = $(By.xpath("//input[@name=\"duration1\"]"));
    public SelenideElement templateChooseFileButton = $(By.xpath("//label[@class=\"btn btn-default ng-scope\"]"));
    public SelenideElement templateUseImgLibrTab = $(".nav.nav-tabs.nav-tabs-left>li:nth-child(2)>a");
    public SelenideElement templateLibrImgSectionSelector = $("#backgroundImage_thumb_sectionsel");
    public SelenideElement templateAddImgFromLibrBtn = $(By.xpath("//button[@ng-click=\"ok()\"]"));

    public SelenideElement saveClipButton = $(By.xpath("//*[@id=\"simplemodal-data\"]/div[4]/div/span[2]/button[3]"));
    public SelenideElement saveAndAskApprovalBtn = $("div.wizard-modal-footer > div > span:nth-child(4) > button:nth-child(5)");
    public SelenideElement category = $(By.xpath("//div[@class=\"scroller-content\"]/span[2]"));
    public SelenideElement nameOfActualCategory = $(By.xpath("//div[@class=\"row-fluid box-tour\"]/div/h3"));
    public SelenideElement portraitTemplate = $(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div[1]/div/div[1]/div[1]/ul/li/div/img"));
    public SelenideElement nameOfClip = $(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div/div/div[1]/div[1]/ul/li/div/a"));
    public SelenideElement templateClipCategory = $(By.xpath("//select[@name=\"clipcategory\"]"));
    public SelenideElement tepmlateNewPlaylistField = $(By.xpath("//*[@name=\"new_playlist\"]"));
    public SelenideElement storeIntheMediaLibraryCheckbox = $(By.xpath("//input[@name=\"backgroundImage_thumb_islibrary\"]"));
    public SelenideElement templateUploadedImgCategoriesSelect = $(By.xpath("//select[@name=\"backgroundImage_thumb_category\"]"));
    public SelenideElement templateUploadedImgNameField = $(By.xpath("//input[@name=\"backgroundImage_thumb_libraryname\"]"));





    public void checkAvailableForUsers(){
        try{
            $(By.xpath("//*[@class=\"icheckbox_flat-aero\"]")).click();
        }catch (ElementNotFound e){
        }
    }

    public void unCheckAvailableForUsers(){
        try{
            $(By.xpath("//*[@class=\"icheckbox_flat-aero checked\"]")).click();
        }catch (ElementNotFound e){
        }
    }


}
