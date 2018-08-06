package playlistTest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import helpers.GenerateData;
import helpers.Precondition;
import helpers.UI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.dashboardPages.MainDashboardPage;
import pages.playlistsPages.ManagePlaylistsPage;
import pages.playlistsPages.PlaylistPage;

import javax.naming.ldap.PagedResultsControl;

import static com.codeborne.selenide.Selenide.*;

public class NewPlaylistTest_SingleUser {
    NewPlaylistTest_MainUser newPlaylistTest_mainUser = new NewPlaylistTest_MainUser();

    @Before
    public void beforeTests(){
        Precondition.beforeSingleUserTests();
    }

    @After
    public void afterTests(){
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

        $(managePlaylistsPage.dateModified).click();
        sleep(1000);
        $(managePlaylistsPage.dateModified).click();

        sleep(3000);
        $(managePlaylistsPage.nameOfPlayListSU).click();
        sleep(6000);

        $$(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//span[@class=\"ng-binding\"]"))
                .shouldHave(CollectionCondition.size(3));
    }
}
