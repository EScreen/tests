package clipTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.GenerateData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.LoginPage;
import pages.playlistsPages.ManagePowerBlocksPage;
import pages.playlistsPages.PlaylistPage;
import pages.playlistsPages.PowerBlockPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

/**
 * Created by qwerty on 5/3/18.
 */
public class NewPowerBlockTest {
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
        ManagePowerBlocksPage managePowerBlocksPage = new ManagePowerBlocksPage();


        $(container.playlists).click();
        $(container.createNewPowerBlock).click();

        String playlistName = gendata.generateString(3);
        $(powerBlockPage.powerBlockNameField).sendKeys(playlistName);

        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(2).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(3).click();
        $$(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).get(4).click();

        $(powerBlockPage.savePowerBlockButton).click();
        $(powerBlockPage.successAlert).shouldBe(Condition.visible);

        $(managePowerBlocksPage.powerBlocksNames).click();
        $$(By.xpath("//div[@id=\"playlist-block\"]//span[@class=\"ng-binding\"]")).shouldHaveSize(3);

    }

    @Test
    public void createNewPowerBlock_portrait(){
        Container container = new Container();
        PowerBlockPage powerBlockPage = new PowerBlockPage();
        GenerateData gendata = new GenerateData();
        ManagePowerBlocksPage managePowerBlocksPage = new ManagePowerBlocksPage();

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
        $(managePowerBlocksPage.powerBlocksNames).click();

        $$(By.xpath("//div[@id=\"playlist-block\"]//span[@class=\"ng-binding\"]")).shouldHaveSize(3);
    }

    @Test
    public void activatePowerBl(){

    }

}
