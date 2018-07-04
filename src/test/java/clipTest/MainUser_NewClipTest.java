package clipTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
import helpers.Precondition;
import helpers.UploadingFiles;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import pages.Container;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.MyFilesPage;
import pages.playlistsPages.ManagePlaylistsPage;
import pages.playlistsPages.PlaylistPage;

import java.awt.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Anna on 18/04/2018.
 */
public class MainUser_NewClipTest {

    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createNewClip() {
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        sleep(1000);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.templateClipCategory).selectOption(3);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[1]/td[2]/span")).shouldBe(Condition.text(clipName));

    }

    @Test
    public void createClipWithImg() throws IOException {
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        sleep(1000);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateChooseFileButton).click();

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_iphone.scpt");

        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();
        $(By.xpath("//*[@class=\"wizard-nav-link ng-binding\"]")).click();

        $(By.xpath("//img[@crossorigin=\"anonymous\"]")).shouldBe(Condition.visible);
    }

    @Test
    public void createAndAddClipToExistedPlayList() {
        MainDashboardPage dashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        Container container = new Container();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();


        $(dashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        sleep(1000);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.templateExistedPlaylistField).click();
        $(createNewClipPage.firstExistedPlaylist).click();

        String playListName = $(By.xpath("//li[@class=\"ui-select-match-item select2-search-choice ng-scope\"]/span/span")).text();

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();

        $(managePlaylistsPage.searchField).setValue(playListName);
        sleep(2000);
        $(managePlaylistsPage.nameOfPlayList).click();

        $("#playlist-block>div:nth-child(2) tr>td:nth-child(3)").shouldHave(Condition.text(clipName));
    }

    @Test
    public void createAndAddClipToNewPlayList(){
        MainDashboardPage dashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(dashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        sleep(1000);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.tepmlateNewPlaylistField).setValue(GenerateData.generateString(3));

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("4");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $$(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table/tbody/tr/td[3]/span")).shouldHave(CollectionCondition.texts(clipName));
    }

    @Test
    public void sortByCategories() {
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.categoriesSelect).click();

        String nameOfCategory = $(createNewClipPage.category).text();
        $(createNewClipPage.category).click();
        sleep(2000);

        $(createNewClipPage.nameOfActualCategory).shouldHave(Condition.exactText(nameOfCategory));
    }

    @Test
    public void sortTemplatesByOrientation(){
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.orientationSelect).click();
        $(createNewClipPage.portraitOrientation).click();

        $(createNewClipPage.portraitTemplate).shouldHave(Condition.attribute("height", "320"));
    }

    @Test
    public void createClipAndAddImgToLibr() throws IOException {
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        sleep(1000);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateChooseFileButton).click();

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_nature.scpt");

        Selenide.executeJavaScript("arguments[0].click();",createNewClipPage.storeIntheMediaLibraryCheckbox);

        $(createNewClipPage.templateUploadedImgCategoriesSelect).selectOption(2);
        String selectedCategory = $("select[name='backgroundImage_thumb_category']>option:nth-child(3)").text();

        String nameUploadedImg = GenerateData.generateString(3);
        $(createNewClipPage.templateUploadedImgNameField).setValue(nameUploadedImg);

        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(container.myFiles).click();
        $(myFilesPage.categorySelector).selectOptionContainingText(selectedCategory);

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[2]")).shouldHave(Condition.text(nameUploadedImg));
    }
}
