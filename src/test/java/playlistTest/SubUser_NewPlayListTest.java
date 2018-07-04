package playlistTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_NewPlayListTest {
    MainUser_NewPlaylistTest mainUserNewPlaylistTest = new MainUser_NewPlaylistTest();

    @Before
    public void beforeTest() {
        Precondition.beforeSubUser1Tests();
    }

    @After
    public void afterTest() {
        close();
    }

    @Test
    public void createNewPlaylist_landscape() {
        mainUserNewPlaylistTest.createNewPlaylist_landscape();
    }

    @Test
    public void setRandomOrder(){
        mainUserNewPlaylistTest.setRandomOrder();
    }

    @Test
    public void createNewPlaylist_withFormula() {
        mainUserNewPlaylistTest.createNewPlaylist_withFormula();
    }

    @Test
    public void createNewPlaylist_withOther() {
        mainUserNewPlaylistTest.createNewPlaylist_withOther();
    }

    @Test
    public void createNewPlaylist_portrait() {
        mainUserNewPlaylistTest.createNewPlaylist_portrait();
    }

    @Test
    public void createNewPlaylist_WithMyFiles() {
        mainUserNewPlaylistTest.createNewPlaylist_WithMyFiles();
    }

    @Test
    public void createNewPlaylist_WithNewsRoom() {
        mainUserNewPlaylistTest.createNewPlaylist_WithNewsRoom();
    }

    @Test
    public void canDeleteAddedClipFromPL() {
        mainUserNewPlaylistTest.canDeleteAddedClipFromPL();
    }

    @Test
    public void setUpClipVolume() {
        mainUserNewPlaylistTest.setUpClipVolume();
    }

    @Test
    public void setClipColor() {
        mainUserNewPlaylistTest.setClipColor();
    }

}
