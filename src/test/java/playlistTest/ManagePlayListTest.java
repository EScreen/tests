package playlistTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.LoginPage;
import pages.playlistsPages.ManagePlaylistsPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by Anna on 08/05/2018.
 */
public class ManagePlayListTest {

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
    public void playListsSorting()
    {
        Container container = new Container();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();
        $(managePlaylistsPage.statusPlaylistSelector).selectOptionContainingText("Show all active playlists");

        //String status = $(By.xpath("//span[@class=\"badge badge-green ng-scope\"]")).getAttribute("tooltip-html-unsafe")


        $(By.xpath("//span[@class=\"badge badge-green ng-scope\"]")).shouldHave(Condition.attribute("tooltip-html-unsafe", "On air"));

    }

    @Test
    public void playListsSearching(){
        Container container = new Container();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();

        String playlistName = $(managePlaylistsPage.lastPlaylistName).text();
        $(managePlaylistsPage.searchField).setValue(playlistName);
        sleep(2000);
        $(managePlaylistsPage.firstPlaylistName).shouldHave(Condition.text(playlistName));
    }

}
