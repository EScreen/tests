package playlistTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.CreateNewClipPage;
import pages.playlistsPages.ManagePlaylistsPage;
import pages.playlistsPages.PlaylistPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by qwerty on 5/3/18.
 */
public class NewPlaylistTest {
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
    public void createNewPlaylist_landscape(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        PlaylistPage playlistPage = new PlaylistPage();
        GenerateData gendata = new GenerateData();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(mainDashboardPage.createPlaylistButton).click();

        String playlistName = gendata.generateString(3);
        $(playlistPage.playlistNameField).sendKeys(playlistName);

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(3).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(4).click();

        $(playlistPage.savePlButton).click();

        $(playlistPage.successAlert).shouldBe(Condition.appear);

        $(managePlaylistsPage.nameOfPlayList).click();

        $$(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//span[@class=\"ng-binding\"]"))
                .shouldHave(CollectionCondition.size(3));
    }

    @Test
    public void createNewPlaylist_portrait() {
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        PlaylistPage playlistPage = new PlaylistPage();
        GenerateData gendata = new GenerateData();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(mainDashboardPage.createPlaylistButton).click();
        $(playlistPage.orientationSwitch).click();

        String playlistName = gendata.generateString(3);
        $(playlistPage.playlistNameField).sendKeys(playlistName);
        $(playlistPage.clipLibrOther).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(3).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(4).click();

        $(playlistPage.savePlButton).click();

        $(playlistPage.successAlert).shouldBe(Condition.appear);

        $(managePlaylistsPage.nameOfPlayList).click();

        $$(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//span[@class=\"ng-binding\"]"))
                .shouldHave(CollectionCondition.size(3));

    }

    @Test
    public void createNewPlaylist_WithMyFiles(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        PlaylistPage playlistPage = new PlaylistPage();
        GenerateData gendata = new GenerateData();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(mainDashboardPage.createPlaylistButton).click();

        String playlistName = gendata.generateString(3);
        $(playlistPage.playlistNameField).sendKeys(playlistName);
        $(playlistPage.clipLibrMyFiles).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(1).click();

        $(createNewClipPage.nextButton).click();
        $(By.xpath("//input[@name=\"duration\"]")).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(playlistPage.savePlButton).click();
        $(playlistPage.successAlert).shouldBe(Condition.appear);
    }

    @Test
    public void createNewPlaylist_WithNewsRoom(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        PlaylistPage playlistPage = new PlaylistPage();
        GenerateData gendata = new GenerateData();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(mainDashboardPage.createPlaylistButton).click();

        String playlistName = gendata.generateString(3);
        $(playlistPage.playlistNameField).sendKeys(playlistName);
        $(playlistPage.clipLibrNewsRoom).click();
        $(playlistPage.newsRoomCategory).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(1).click();

        $(createNewClipPage.nextButton).click();
        $(By.xpath("//select[@ng-model=\"data.fieldsvalue[field.flashname]\"]")).selectOption(1);
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(playlistPage.savePlButton).click();
        $(playlistPage.successAlert).shouldBe(Condition.appear);
    }




}

