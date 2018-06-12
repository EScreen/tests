package playlistTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
import org.junit.After;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by qwerty on 5/3/18.
 */
public class MainUser_PowerBlockTest {
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
    public void createNewPowerBlock_landscape(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();
        GenerateData gendata = new GenerateData();


        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String playlistName = gendata.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(playlistName);

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
        GenerateData gendata = new GenerateData();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String playlistName = gendata.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(playlistName);
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
    public void activatePowerBl(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();

        $(container.playlists).click();
        $(container.managePowerBlocks).click();

        sleep(2000);

        int numberScheduledPowerBlBefore = $$("#powerblocks-scheduled > tbody > tr").size();
        int numberActivePowerBlBefore = $$("#active_pb > tbody > tr").size();

        $(powerBlockPage.notActivePowerBl).click();
        powerBlockPage.selectPlayer();

        $(powerBlockPage.playBackDuration).setValue("10");

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        $("#start_on > input").sendKeys(date1);

        $("#start_at > span").click();
        $(By.xpath("//a[@data-action=\"decrementHours\"]")).click();
        $(powerBlockPage.saveButton).click();

        $$("#powerblocks-scheduled > tbody > tr").shouldHaveSize(numberScheduledPowerBlBefore + 1);
        $$("#active_pb > tbody > tr").shouldHaveSize(numberActivePowerBlBefore + 1);
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
        GenerateData gendata = new GenerateData();
        PowerBlockPage powerBlockPage = new PowerBlockPage();
        Container container = new Container();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String name = gendata.generateString(3);
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
        GenerateData gendata = new GenerateData();
        PowerBlockPage powerBlockPage = new PowerBlockPage();
        Container container = new Container();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String name = gendata.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(name);

        $(powerBlockPage.clipLibrNewsRoom).click();
        $(powerBlockPage.newsRoomCategory).click();

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(1).click();

        $(createNewClipPage.nextButton).click();
        $(By.xpath("//select[@ng-model=\"data.fieldsvalue[field.flashname]\"]")).selectOption(1);
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(powerBlockPage.savePowerBlockButton).click();
        $(powerBlockPage.successAlert).shouldBe(Condition.appear);
    }

    @Test
    public void createNewPowerBl_withMyFiles(){
        GenerateData gendata = new GenerateData();
        PowerBlockPage powerBlockPage = new PowerBlockPage();
        Container container = new Container();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String name = gendata.generateString(3);
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
        GenerateData gendata = new GenerateData();
        PowerBlockPage powerBlockPage = new PowerBlockPage();
        Container container = new Container();

        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String name = gendata.generateString(3);
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
        GenerateData gendata = new GenerateData();


        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String playlistName = gendata.generateString(3);
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
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();
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
