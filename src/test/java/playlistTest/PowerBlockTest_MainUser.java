package playlistTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
import helpers.Precondition;
import org.jbehave.core.reporters.TemplateableViewGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.LoginPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.CreateNewClipPage;
import pages.playlistsPages.ManagePlaylistsPage;
import pages.playlistsPages.PlaylistPage;
import pages.playlistsPages.PowerBlockPage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by qwerty on 5/3/18.
 */
public class PowerBlockTest_MainUser {
    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }
    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createNewPowerBlock_landscape(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();


        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String powerBlName = GenerateData.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(powerBlName);

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(3).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(4).click();

        $(powerBlockPage.savePowerBlockButton).click();
        $(powerBlockPage.successAlert).shouldBe(Condition.visible);

        $(powerBlockPage.powerBlockName).click();
        $$(By.xpath("//div[@id=\"playlist-block\"]//span[@class=\"ng-binding\"]")).shouldHaveSize(3);

    }

    @Test
    public void createNewPowerBlock_portrait(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String powerBlName = GenerateData.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(powerBlName);
        $(powerBlockPage.orientationSwitch).click();
        $(powerBlockPage.clipLibrOther).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(3).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(4).click();

        $(powerBlockPage.savePowerBlockButton).click();
        $(powerBlockPage.successAlert).shouldBe(Condition.appear);
        $(powerBlockPage.powerBlockName).click();

        $$(By.xpath("//div[@id=\"playlist-block\"]//span[@class=\"ng-binding\"]")).shouldHaveSize(3);
    }

    @Test
    public void previewDisplaysEntirely(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String powerBlName = GenerateData.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(powerBlName);

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(3).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(4).click();

        $(powerBlockPage.savePowerBlockButton).click();
        $(powerBlockPage.successAlert).shouldBe(Condition.visible);
        sleep(4000);
        $(powerBlockPage.searchField).setValue(powerBlName);
        $("#powerblocks-table>tbody>tr>td:nth-child(7)>div>a>i").click();
        $$("#video-preview-playlist>li").shouldHave(CollectionCondition.size(3));

    }

    @Test
    public void deletePowerBl(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();

        $(container.playlists).click();
        $(container.managePowerBlocks).click();

        String powerBlName = powerBlockPage.getPowerBlockName($("#powerblocks-table>tbody>tr>td:nth-child(2) span"));
        $(powerBlockPage.deletePowerBl).click();
        sleep(2000);
        $(powerBlockPage.yesDelete).click();

        $(powerBlockPage.successAlert).should(Condition.appear);

        $(powerBlockPage.searchField).setValue(powerBlName);
        sleep(1000);
        $("#powerblocks-table>tbody>tr>td>center").shouldHave(Condition.exactText("This search returned no results"));

    }

    @Test
    public void activatePowerBl(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();

        $(container.playlists).click();
        $(container.managePowerBlocks).click();

        sleep(2000);

        int numberScheduledPowerBlBefore = $$("#powerblocks-scheduled > tbody > tr[ng-repeat]").size();
        int numberActivePowerBlBefore = $$("#active_pb > tbody > tr[ng-repeat]").size();

        $(powerBlockPage.notActivePowerBl).click();
        powerBlockPage.selectPlayer();

        $(powerBlockPage.playBackDuration).setValue("10");
        powerBlockPage.setDateAndTime();

        $(powerBlockPage.saveButton).click();

        $$("#powerblocks-scheduled > tbody > tr").shouldHaveSize(numberScheduledPowerBlBefore + 1);
        $$("#active_pb > tbody > tr").shouldHaveSize(numberActivePowerBlBefore + 1);

        String clipName = $("#powerblocks-scheduled>tbody>tr>td>span").text();
        $(powerBlockPage.searchField).setValue(clipName);
        sleep(1000);

        $("#powerblocks-table>tbody>tr>td>center>a>span").shouldHave(Condition.attribute("tooltip-html-unsafe", "On air"));
        $("#powerblocks-table>tbody>tr>td:nth-child(2)>a>span").shouldHave(Condition.exactText(clipName));

    }

    @Test
    public void activatePowerBl_SeveralPlayers(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();

        $(container.playlists).click();
        $(container.managePowerBlocks).click();

        sleep(2000);

        int numberScheduledPowerBlBefore = $$("#powerblocks-scheduled > tbody > tr[ng-repeat]").size();
        int numberActivePowerBlBefore = $$("#active_pb > tbody > tr[ng-repeat]").size();

        $(powerBlockPage.notActivePowerBl).click();
        powerBlockPage.selectPlayer();
        powerBlockPage.selectPlayer();

        $(powerBlockPage.playBackDuration).setValue("2");

        powerBlockPage.setDateAndTime();
        $(powerBlockPage.saveButton).click();

        $$("#powerblocks-scheduled > tbody > tr").shouldHave(CollectionCondition.size(numberScheduledPowerBlBefore + 1));
        $$("#active_pb > tbody > tr").shouldHave(CollectionCondition.size(numberActivePowerBlBefore + 2));

        /*int numberScheduledPowerBlAfter = $$("#powerblocks-scheduled > tbody > tr").size();

        Assert.assertTrue(numberScheduledPowerBlBefore + 1 == numberScheduledPowerBlAfter);

        int numberActivePowerBlAfter = $$("#active_pb > tbody > tr").size();
        Assert.assertTrue(numberActivePowerBlBefore + 2 == numberActivePowerBlAfter);*/

        String clipName = $("#powerblocks-scheduled>tbody>tr>td>span").text();
        $(powerBlockPage.searchField).setValue(clipName);
        sleep(1000);

        $("#powerblocks-table>tbody>tr>td>center>a>span").shouldHave(Condition.attribute("tooltip-html-unsafe", "On air"));
        $("#powerblocks-table>tbody>tr>td:nth-child(2)>a>span").shouldHave(Condition.exactText(clipName));
    }

    @Test
    public void activatePowerBl_PlayerGroup(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();

        $(container.playlists).click();
        $(container.managePowerBlocks).click();
        sleep(2000);

        int numberScheduledPowerBlBefore = $$("#powerblocks-scheduled > tbody > tr[ng-repeat]").size();
        int numberActivePowerBlBefore = $$("#active_pb > tbody > tr[ng-repeat]").size();

        $(powerBlockPage.notActivePowerBl).click();
        $(powerBlockPage.selectPlayerGroup).click();
        $(By.xpath("//div[@class=\"ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active\"]//*[@class=\"ng-binding ng-scope\"][contains(text(),'zzz')]"))
                .waitUntil(Condition.appear,10000).click();
        Selenide.executeJavaScript("arguments[0].click();", $(".controls.checkbox-table i.fa.fa-square"));

        $(powerBlockPage.playBackDuration).setValue("10");
        powerBlockPage.setDateAndTime();

        $(powerBlockPage.saveButton).click();

        $$("#powerblocks-scheduled > tbody > tr").shouldHaveSize(numberScheduledPowerBlBefore + 1);
        $$("#active_pb > tbody > tr").shouldHaveSize(numberActivePowerBlBefore + 2);

        String clipName = $("#powerblocks-scheduled>tbody>tr>td>span").text();
        $(powerBlockPage.searchField).setValue(clipName);
        sleep(1000);

        $("#powerblocks-table>tbody>tr>td>center>a>span").shouldHave(Condition.attribute("tooltip-html-unsafe", "On air"));
        $("#powerblocks-table>tbody>tr>td:nth-child(2)>a>span").shouldHave(Condition.exactText(clipName));
    }

    @Test
    public void searchPowerBl(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();

        $(container.playlists).click();
        $(container.managePowerBlocks).click();
        String powerBlockName = powerBlockPage.getPowerBlockName($(".box.pwb-list #powerblocks-table > tbody > tr:last-child > td:nth-child(2) > a > span"));

        $(powerBlockPage.searchField).setValue(powerBlockName);

        $(".box.pwb-list #powerblocks-table > tbody > tr:first-child > td:nth-child(2) > a > span")
                .shouldHave(Condition.text(powerBlockName));
    }

    @Test
    public void createNewPowerBl_withFormula(){
        PowerBlockPage powerBlockPage = new PowerBlockPage();
        Container container = new Container();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String name = GenerateData.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(name);

        $(powerBlockPage.clipLibrFormula).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(3).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(4).click();

        $(powerBlockPage.savePowerBlockButton).click();
        $(powerBlockPage.successAlert).shouldBe(Condition.appear);
        $(powerBlockPage.powerBlockName).click();

        $$(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//span[@class=\"ng-binding\"]"))
                .shouldHave(CollectionCondition.size(3));
    }

    @Test
    public void createNewPowerBl_withNewsRoom(){
        PowerBlockPage powerBlockPage = new PowerBlockPage();
        Container container = new Container();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String name = GenerateData.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(name);

        $(powerBlockPage.clipLibrNewsRoom).click();
        $(powerBlockPage.newsRoomCategory).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(1).click();

        $(createNewClipPage.nextButton).click();
        $(By.xpath("//select[@ng-model=\"data.fieldsvalue[field.flashname]\"]")).selectOption(1);
        $("div.wizard-card.steps.ng-scope > div > div:nth-child(3) > form > div > div > input").setValue("1");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(powerBlockPage.savePowerBlockButton).click();
        $(powerBlockPage.successAlert).shouldBe(Condition.appear);
    }

    @Test
    public void createNewPowerBl_withMyFiles(){
        PowerBlockPage powerBlockPage = new PowerBlockPage();
        Container container = new Container();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String name = GenerateData.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(name);

        $(powerBlockPage.clipLibrMyFiles).click();

        $(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).click();

        $(createNewClipPage.nextButton).click();
        $(By.xpath("//input[@name=\"duration\"]")).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(powerBlockPage.savePowerBlockButton).click();
        $(powerBlockPage.successAlert).shouldBe(Condition.appear);
    }

    @Test
    public void createNewPowerBl_withOther(){
        PowerBlockPage powerBlockPage = new PowerBlockPage();
        Container container = new Container();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String name = GenerateData.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(name);

        $(powerBlockPage.clipLibrOther).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(3).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(4).click();

        $(powerBlockPage.savePowerBlockButton).click();
        $(powerBlockPage.successAlert).shouldBe(Condition.appear);
        $(powerBlockPage.powerBlockName).click();

        $$(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//span[@class=\"ng-binding\"]"))
                .shouldHave(CollectionCondition.size(3));
    }

    @Test
    public void canDeleteAddedClipFromPowerBl(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();


        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String playlistName = GenerateData.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(playlistName);

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(3).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(4).click();

        $(powerBlockPage.savePowerBlockButton).click();
        $(powerBlockPage.successAlert).shouldBe(Condition.visible);

        $(powerBlockPage.powerBlockName).click();
        $(powerBlockPage.clipSettingsButton).click();
        $(powerBlockPage.deleteClipButton).click();

        $$(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//span[@class=\"ng-binding\"]"))
                .shouldHave(CollectionCondition.size(2));
    }

    @Test
    public void setUpClipVolume(){
        PlaylistPage playlistPage = new PlaylistPage();
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();

        $(container.playlists).click();
        $(container.managePowerBlocks).click();
        $(powerBlockPage.powerBlockName).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();

        $(powerBlockPage.clipSettingsButton).click();
        $(powerBlockPage.setVolumeButton).click();
        playlistPage.setVolume(60);
        $(powerBlockPage.saveVolumeButton).click();
        $(powerBlockPage.saveEditingPowerBl).click();

        sleep(2000);

        $(powerBlockPage.powerBlockName).click();
        $(powerBlockPage.clipSettingsButton).click();
        $(powerBlockPage.setVolumeButton).click();

        $("span[ng-bind='params.volume']").shouldHave(Condition.exactText("60"));
    }




}
