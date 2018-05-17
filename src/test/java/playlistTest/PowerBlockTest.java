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
import pages.playlistsPages.PowerBlockPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by qwerty on 5/3/18.
 */
public class PowerBlockTest {
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

        $(powerBlockPage.powerBlocksNames).click();
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
        $(powerBlockPage.powerBlocksNames).click();

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


}
