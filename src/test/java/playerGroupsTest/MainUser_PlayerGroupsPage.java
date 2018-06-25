package playerGroupsTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.GenerateData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.LoginPage;
import pages.playersPages.PlayerGroupsPage;
import pages.playlistsPages.PlaylistPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;

public class MainUser_PlayerGroupsPage {
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
    public void createPlGroup(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();
        $(playerGroupsPage.createPlayerGroupButton).click();

        String groupName = GenerateData.generateString(4);
        $(playerGroupsPage.playerGroupNameField).setValue(groupName);


    }
}
