package playlistTest;

import com.codeborne.selenide.*;
import com.sun.tools.javac.jvm.Gen;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.Container;
import pages.LoginPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.CreateNewClipPage;
import pages.playlistsPages.ManagePlaylistsPage;
import pages.playlistsPages.PlaylistPage;

import java.awt.*;
import java.awt.event.InputEvent;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by qwerty on 5/3/18.
 */
public class NewPlaylistTest_MainUser {


    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }
    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createNewPlaylist_landscape(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        PlaylistPage playlistPage = new PlaylistPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(mainDashboardPage.createPlaylistButton).click();

        String playlistName = GenerateData.generateString(3);
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
    public void setRandomOrder(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        PlaylistPage playlistPage = new PlaylistPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(mainDashboardPage.createPlaylistButton).click();
        String playlistName = GenerateData.generateString(3);
        $(playlistPage.playlistNameField).sendKeys(playlistName);

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $(".ibutton-handle").click();

        $(playlistPage.savePlButton).click();
        $(playlistPage.successAlert).shouldBe(Condition.appear);
        $(managePlaylistsPage.nameOfPlayList).click();

        $("div.box-header > ul > li:nth-child(1) > div > div.ibutton-label-on > span[style='margin-left: 0px;']").shouldBe(Condition.visible);

    }

    @Test
    public void createNewPlaylist_withFormula(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        PlaylistPage playlistPage = new PlaylistPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(mainDashboardPage.createPlaylistButton).click();

        String playlistName = GenerateData.generateString(3);
        $(playlistPage.playlistNameField).sendKeys(playlistName);

        $(playlistPage.clipLibrFormula).click();

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
    public void createNewPlaylist_withOther(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        PlaylistPage playlistPage = new PlaylistPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(mainDashboardPage.createPlaylistButton).click();

        String playlistName = GenerateData.generateString(3);
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
    public void createNewPlaylist_portrait() {
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        PlaylistPage playlistPage = new PlaylistPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(mainDashboardPage.createPlaylistButton).click();
        $(playlistPage.orientationSwitch).click();

        String playlistName = GenerateData.generateString(3);
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
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(mainDashboardPage.createPlaylistButton).click();

        String playlistName = GenerateData.generateString(3);
        $(playlistPage.playlistNameField).sendKeys(playlistName);
        $(playlistPage.clipLibrMyFiles).click();

        $(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).click();

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
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(mainDashboardPage.createPlaylistButton).click();

        String playlistName = GenerateData.generateString(3);
        $(playlistPage.playlistNameField).sendKeys(playlistName);
        $(playlistPage.clipLibrNewsRoom).click();
        $(playlistPage.newsRoomCategory).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(1).click();
        sleep(3000);

        $(createNewClipPage.nextButton).click();
        $(By.xpath("//select[@ng-model=\"data.fieldsvalue[field.flashname]\"]")).selectOption(1);
        $("div.wizard-card.steps.ng-scope > div > div:nth-child(3) > form > div > div > input").setValue("1");

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(playlistPage.savePlButton).click();
        $(playlistPage.successAlert).shouldBe(Condition.appear);
    }

    @Test
    public void canDeleteAddedClipFromPL(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        PlaylistPage playlistPage = new PlaylistPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(mainDashboardPage.createPlaylistButton).click();

        String playlistName = GenerateData.generateString(3);
        $(playlistPage.playlistNameField).sendKeys(playlistName);

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(3).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(4).click();

        $(playlistPage.savePlButton).click();

        $(playlistPage.successAlert).shouldBe(Condition.appear);

        $(managePlaylistsPage.nameOfPlayList).click();
        $(playlistPage.clipSettingsButton).click();
        $(playlistPage.deleteClipButton).click();

        $$(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//span[@class=\"ng-binding\"]"))
                .shouldHave(CollectionCondition.size(2));
    }

    @Test
    public void setUpClipVolume(){
        PlaylistPage playlistPage = new PlaylistPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();
        Container container = new Container();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();
        $(managePlaylistsPage.nameOfPlayList).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();

        $(playlistPage.clipSettingsButton).click();
        $(playlistPage.setVolumeButton).click();

        playlistPage.setVolume(50);
        $("span[ng-bind='params.volume']").shouldHave(Condition.exactText("50"));

        $(playlistPage.saveVolumeButton).click();
        $(playlistPage.saveEditingPlButton).click();

        $(managePlaylistsPage.nameOfPlayList).click();
        $(playlistPage.clipSettingsButton).click();
        $(playlistPage.setVolumeButton).click();

        $("span[ng-bind='params.volume']").shouldHave(Condition.exactText("50"));
    }

    @Test
    public void setClipColor(){
        PlaylistPage playlistPage = new PlaylistPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();
        Container container = new Container();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();
        $(managePlaylistsPage.nameOfPlayList).click();

        String css1 = $(".colorpickerWrapper>div").getCssValue("background-color");
        $(".colorpickerWrapper").click();

        Selenide.actions().dragAndDropBy(playlistPage.colorPoint, 10, -50).build().perform();

        String css2 = $(".colorpickerWrapper>div").getCssValue("background-color");

        Assert.assertNotEquals(css1, css2);
    }

    }

