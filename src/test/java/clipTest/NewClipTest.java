package clipTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
import helpers.UploadingFiles;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import pages.Container;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.MyFilesPage;
import pages.playlistsPages.ManagePlaylistsPage;
import pages.playlistsPages.PlaylistPage;

import java.awt.*;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Anna on 18/04/2018.
 */
public class NewClipTest {

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaMainUser", "os123123");
        Configuration.timeout = 20000;
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void mU_CreateNewClip() {
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
    public void createClipWithImg() throws AWTException {
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

        uploadingFiles.uploadFile("/Users/olgakuznetsova/projects/EScreen/src/main/resources/iphone.jpg");

        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();
        $(By.xpath("//*[@class=\"wizard-nav-link ng-binding\"]")).click();

        $(By.xpath("//img[@crossorigin=\"anonymous\"]")).shouldBe(Condition.visible);
    }

    @Test
    public void mU_CreateAndAddClipToExistedPlayList() throws InterruptedException {
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
        $(createNewClipPage.templateExistedPlaylistField).setValue("First");
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

        $(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table/tbody")).shouldHave(Condition.text(clipName));
    }

    @Test
    public void mU_CreateAndAddClipToNewPlayList(){
        MainDashboardPage dashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        Container container = new Container();
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
    public void createClipAndAddImgToLibr() throws AWTException {
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

        uploadingFiles.uploadFile("/Users/olgakuznetsova/projects/EScreen/src/main/resources/nature.jpg");

        sleep(2000);

        $(createNewClipPage.storeIntheMediaLibraryCheckbox).click();
        $(createNewClipPage.templateUploadedImgCategoriesSelect).selectOptionByValue("1273");
        String selectedCategory = $(By.xpath("//option[@value=\"1273\"]")).text();

        String nameUploadedImg = genData.generateString(3);
        $(createNewClipPage.templateUploadedImgNameField).setValue(nameUploadedImg);

        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(container.myFiles).click();
        $(myFilesPage.categorySelector).selectOptionContainingText(selectedCategory);

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[2]")).shouldHave(Condition.text(nameUploadedImg));


    }

    @Test
    public void sU_CreateNewClip(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();

        container.goToSubUser1();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.templateClipCategory).selectOption(3);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[1]/td[2]/span")).shouldBe(Condition.text(clipName));
    }

    @Test
    public void sU_CreateAndAddClipToExistedPlayList(){
        MainDashboardPage dashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        Container container = new Container();
        GenerateData genData = new GenerateData();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        container.goToSubUser1();
        $(dashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.templateExistedPlaylistField).setValue("Test");
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

        $(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table/tbody")).shouldHave(Condition.text(clipName));
    }

    @Test
    public void sU_CreateAndAddClipToNewPlayList(){
        MainDashboardPage dashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        Container container = new Container();

        container.goToSubUser1();
        $(dashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.tepmlateNewPlaylistField).setValue(genData.generateString(4));

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("4");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $$(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table/tbody/tr/td[3]/span")).shouldHave(CollectionCondition.texts(clipName));
    }

    @Test
    public void sortByCategories() throws InterruptedException {
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
    public void templateSearch() throws InterruptedException {
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();

        $(mainDashboardPage.createClipButton).click();

        String searchInput = "Praktijkcollege Het Plein";

        $(createNewClipPage.searchField).setValue(searchInput);
        Thread.sleep(3000);

        $$(By.xpath("//div[@class=\"template-item ng-scope\"]")).shouldBe(CollectionCondition.size(4));
    }
}
