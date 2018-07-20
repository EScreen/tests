package playlistTest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Container;
import pages.playlistsPages.ManagePlaylistsPage;

import static com.codeborne.selenide.Selenide.*;

public class ManagePlayListTest_SingleUser {
    ManagePlayListTest_MainUser managePlayListTest_mainUser = new ManagePlayListTest_MainUser();

    @Before
    public void beforeTest(){
        Precondition.beforeSingleUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void playListsSorting(){
        Container container = new Container();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();
        sleep(1000);
        $(By.xpath("//select[@ng-change=\"changeActiveFilter()\"]/option[2]")).click();
        $$("table>tbody>tr>td:nth-child(6)>span").shouldHave(CollectionCondition.texts("On air"));
    }

    @Test
    public void playListsSearching(){
        Container container = new Container();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();

        String playlistName = $("tr.ng-scope:last-child > td:nth-child(3) > a> span").text();
        $(managePlaylistsPage.searchField).setValue(playlistName);
        sleep(2000);
        $("tr.ng-scope:first-child > td:nth-child(3) > a> span").shouldHave(Condition.text(playlistName));
    }
}
