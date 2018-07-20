package pages.mediaPages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShould;
import helpers.GenerateData;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import pages.dashboardPages.MainDashboardPage;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 06/04/2018.
 */
public class CreateNewClipPage {

    public String testTemplateName = "FAMAS Plattegrond";

    public SelenideElement
            searchField = $(By.xpath("//*[@id=\"template-name-search\"]/input")),
            categoriesSelect = $(By.xpath("//*[@id=\"template-categories-select\"]/form/div/div/span")),
            orientationSelect = $(By.xpath("//*[@id=\"template-orientation-select\"]/form/div/div/span")),
            portraitOrientation = $(By.xpath("//*[@id=\"template-orientation-select\"]/form/div/div/div/div[2]/span[1]")),

            newClipButton = $(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div/div/div[1]/div[1]/ul/li/div/a")),
            nextButton = $(By.cssSelector("#simplemodal-data > div.wizard-modal-footer > div > button.btn.wizard-next.btn-blue.ng-scope")),
            templateTestNameField = $(By.id("fragmentname")),
            templateSummaryTab = $(By.xpath("//a[@data-info=\"summary\"]")),
            templateExistedPlaylistField = $(By.xpath("//li[@class=\"select2-search-field\"]/input")),
            firstExistedPlaylist = $(By.xpath("//div[@ng-bind-html=\"playlist.name | highlight: $select.search\"]")),
            templateTestDurationField = $(By.xpath("//input[@name=\"duration1\"]")),
            templateChooseFileButton = $(By.xpath("//label[@class=\"btn btn-default ng-scope\"]")),
            templateUseImgLibrTab = $(".nav.nav-tabs.nav-tabs-left>li:nth-child(2)>a"),
            templateLibrImgSectionSelector = $("#backgroundImage_thumb_sectionsel"),
            templateAddImgFromLibrBtn = $(By.xpath("//button[@ng-click=\"ok()\"]")),

            saveClipButton = $(By.xpath("//*[@id=\"simplemodal-data\"]/div[4]/div/span[2]/button[3]")),
            saveAndAskApprovalBtn = $("div.wizard-modal-footer > div > span:nth-child(4) > button:nth-child(5)"),
            category = $(By.xpath("//div[@class=\"scroller-content\"]/span[2]")),
            nameOfActualCategory = $(By.xpath("//div[@class=\"row-fluid box-tour\"]/div/h3")),
            portraitTemplate = $(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div[1]/div/div[1]/div[1]/ul/li/div/img")),
            templateClipCategory = $(By.xpath("//select[@name=\"clipcategory\"]")),
            tepmlateNewPlaylistField = $(By.xpath("//*[@name=\"new_playlist\"]")),
            storeIntheMediaLibraryCheckbox = $("#content_backgroundImage_thumb input[type=\"checkbox\"]"),
            templateUploadedImgCategoriesSelect = $(By.xpath("//select[@name=\"backgroundImage_thumb_category\"]")),
            templateUploadedImgNameField = $(By.xpath("//input[@name=\"backgroundImage_thumb_libraryname\"]")),

            //Share Clip page
            shareClipWithSubUser1 = $("#dataTables>table>tbody>tr:nth-child(2)>td>div"),
            shareClipWithSubUser2 = $("#dataTables>table>tbody>tr:nth-child(3)>td>div"),
            shareClipSaveButton = $(".form-actions>button");






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
