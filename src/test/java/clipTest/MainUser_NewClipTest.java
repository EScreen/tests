package clipTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
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
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaMainUser", "os123123");
        Configuration.timeout = 20000;
        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createNewClip() {
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.templateClipCategory).selectOption(3);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[1]/td[2]/span")).shouldBe(Condition.text(clipName));

    }

    @Test
    public void createClipWithImg() throws AWTException, IOException {
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        UploadingFiles uploadingFiles = new UploadingFiles();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateChooseFileButton).click();

        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_iphone.scpt");

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
        GenerateData genData = new GenerateData();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();


        $(dashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.templateExistedPlaylistField).click();
        //$(createNewClipPage.templateExistedPlaylistField).setValue("First");
        $(createNewClipPage.firstExistedPlaylist).click();

        String playListName = $(By.xpath("//li[@class=\"ui-select-match-item select2-search-choice ng-scope\"]/span/span")).text();

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();
        //$(managePlaylistsPage.formulaTab).click();

        $(managePlaylistsPage.searchField).setValue(playListName);
        sleep(2000);
        $(managePlaylistsPage.nameOfPlayList).click();

        $(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table/tbody")).shouldHave(Condition.text(clipName));
    }

    @Test
    public void createAndAddClipToNewPlayList(){
        MainDashboardPage dashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(dashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.tepmlateNewPlaylistField).setValue(genData.generateString(3));

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
    public void createClipAndAddImgToLibr() throws AWTException, IOException {

        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        Container container = new Container();
        GenerateData genData = new GenerateData();
        UploadingFiles uploadingFiles = new UploadingFiles();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateChooseFileButton).click();

        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_nature.scpt");

        sleep(2000);

        Selenide.executeJavaScript("arguments[0].click();",createNewClipPage.storeIntheMediaLibraryCheckbox);

        $(createNewClipPage.templateUploadedImgCategoriesSelect).selectOption(2);
        String selectedCategory = $("select[name='backgroundImage_thumb_category']>option:nth-child(3)").text();

        String nameUploadedImg = genData.generateString(3);
        $(createNewClipPage.templateUploadedImgNameField).setValue(nameUploadedImg);

        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(container.myFiles).click();
        $(myFilesPage.categorySelector).selectOptionContainingText(selectedCategory);

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[2]")).shouldHave(Condition.text(nameUploadedImg));
    }
}
