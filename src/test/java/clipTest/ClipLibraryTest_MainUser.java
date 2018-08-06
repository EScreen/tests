package clipTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
import helpers.Precondition;
import helpers.UploadingFiles;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import pages.Container;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;

import java.awt.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Anna on 16/04/2018.
 */
public class ClipLibraryTest_MainUser {

    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }

    @After
    public void afterTest(){
        close();
    }


    //Edit name of existed clip
    @Test
    public void editCLipName() {
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.media).click();
        $(container.clipLibrary).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();

        $(createNewClipPage.templateTestNameField).clear();
        $(createNewClipPage.templateTestNameField).setValue(GenerateData.generateString(4) + " Edited");

        sleep(1000);

        createNewClipPage.checkAvailableForUsers();

        String createdName = $(createNewClipPage.templateTestNameField).attr("value");

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//td//span[@class=\"ng-binding\"]")).shouldHave(Condition.text(createdName));
    }

    @Test
    public void uploadImgToClip() throws IOException {
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();


        $(container.media).click();
        $(container.clipLibrary).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();
        $(createNewClipPage.nextButton).click();

        $(createNewClipPage.templateChooseFileButton).click();
        sleep(2000);

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_iphone.scpt");

        $(createNewClipPage.templateSummaryTab).click();
        $(createNewClipPage.saveClipButton).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();
        $(createNewClipPage.nextButton).click();

        $("div.darkroom-image-container > div > img").shouldBe(Condition.visible);



    }

    @Test
    public void uploadImgFromLibrToClip(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();


        $(container.media).click();
        $(container.clipLibrary).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();
        $(createNewClipPage.nextButton).click();

        $(createNewClipPage.templateUseImgLibrTab).click();
        $(createNewClipPage.templateLibrImgSectionSelector).selectOptionContainingText("Other");
        sleep(1000);
        int index = GenerateData.generateNumbers(1);
        $$("tbody img").get(index).click();

        $(createNewClipPage.templateAddImgFromLibrBtn).click();
        $(createNewClipPage.templateSummaryTab).click();
        $(createNewClipPage.saveClipButton).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();
        $(createNewClipPage.nextButton).click();

        $(".canvas-container>img").shouldBe(Condition.visible.because("Image from library doesn't save"));
    }

    @Test
    public void deleteClip(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        $(container.media).click();
        $(container.clipLibrary).click();

        String clipName = $(clipLibraryPage.clipName).text();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.deleteClipButton).click();
        $(clipLibraryPage.yesDeleteButton).click();
        sleep(1000);
        clipLibraryPage.deleteClipIfItUsedInPlaylist();
        sleep(2000);

        $(clipLibraryPage.clipName).shouldNotHave(Condition.exactText(clipName));
    }

    //NewClipTest_MainUser of appearance "Share clip" table after unchecking "Available for all users" checkbox.
    @Test
    public void mU_appearanceOfShareClipTable() {
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();

        createNewClipPage.unCheckAvailableForUsers();
        $(createNewClipPage.templateSummaryTab).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//span[@translate=\"FRAGMENT_SHARE_PAGE_TITLE\"]")).shouldHave(Condition.text("Share clip").because("Share table don't display"));

        $$(".dataTable.responsive>tbody>tr:nth-child(n+2)>.ng-binding").findBy(Condition.text("Anya SubUser1")
                .because("Subuser1 don't appear in the share table"))
                .shouldBe(Condition.visible);
        $$(".dataTable.responsive>tbody>tr:nth-child(n+2)>.ng-binding").findBy(Condition.text("Anya SubUser2")
                .because("Subuser2 don't appear in the share table"))
                .shouldBe(Condition.visible);
    }

    @Test
    public void clipSearch() throws InterruptedException {
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        $(container.media).click();
        $(container.clipLibrary).click();

        String searchedNameOfClip = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[5]/td[2]/span")).text();

        $(clipLibraryPage.searchField).setValue(searchedNameOfClip);
        Thread.sleep(3000);

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr/td[2]/span")).shouldHave(Condition.text(searchedNameOfClip));
    }

    //Filtering clips by category
    @Test
    public void clipFiltering (){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        $(container.media).click();
        $(container.clipLibrary).click();

        $("#dataTables>table>tbody>tr:nth-child(3)>td:nth-child(3)>select").selectOption(1);
        $(clipLibraryPage.categoryDropDawn).selectOption(2);

        String selectedCategory = $(By.xpath("//div[@class=\"box-header relative\"]//option[@selected=\"selected\"]")).text();
        System.out.println(selectedCategory);

        $(By.xpath("//div[@class=\"box-content\"]//option[@selected=\"selected\"]")).shouldHave(Condition.exactText(selectedCategory));

    }


}
