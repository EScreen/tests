package clipTest;

import com.codeborne.selenide.Condition;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Container;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.CreateNewClipPage;
import pages.playlistsPages.ManagePlaylistsPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;

public class NewClipTest_SingleUser {
    NewClipTest_MainUser newClipTest_mainUser = new NewClipTest_MainUser();

    @Before
    public void beforeTest(){
        Precondition.beforeSingleUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createNewClip(){
        newClipTest_mainUser.createNewClip();
    }

    @Test
    public void createClipWithImg() throws IOException {
        newClipTest_mainUser.createClipWithImg();
    }

    @Test
    public void createAndAddClipToExistedPlayList(){
        MainDashboardPage dashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        Container container = new Container();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();


        $(dashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        sleep(1000);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.templateExistedPlaylistField).click();
        $(createNewClipPage.firstExistedPlaylist).click();

        String playListName = $(By.xpath("//li[@class=\"ui-select-match-item select2-search-choice ng-scope\"]/span/span")).text();

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();

        $(managePlaylistsPage.searchField).setValue(playListName);
        sleep(2000);
        $(managePlaylistsPage.nameOfPlayListSU).click();

        $("#playlist-block>div:nth-child(2) tr>td:nth-child(3)").shouldHave(Condition.text(clipName));
    }

    @Test
    public void createAndAddClipToNewPlayList(){
        newClipTest_mainUser.createAndAddClipToNewPlayList();
    }

    @Test
    public void sortByCategories(){
        newClipTest_mainUser.sortByCategories();
    }

    @Test
    public void sortTemplatesByOrientation(){
        newClipTest_mainUser.sortTemplatesByOrientation();
    }

    @Test
    public void createClipAndAddImgToLibr() throws IOException {
        newClipTest_mainUser.createClipAndAddImgToLibr();
    }




}
