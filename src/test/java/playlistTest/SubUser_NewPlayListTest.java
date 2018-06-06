package playlistTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_NewPlayListTest extends MainUser_NewPlaylistTest {

    @Before
    public void beforeTest() {
        WebDriverRunner.setWebDriver(new ChromeDriver());
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaSubUser1", "os123123");
        Configuration.timeout = 20000;
    }

    @After
    public void afterTest() {
        close();
    }

    @Test
    public void sU_createNewPlaylist_landscape(){
        super.mU_createNewPlaylist_landscape();
    }

    @Test
    public void sU_createNewPlaylist_portrait(){
        super.mU_createNewPlaylist_portrait();
    }

    @Test
    public void sU_createNewPlaylist_withFormula(){
        super.mU_createNewPlaylist_withFormula();
    }

    @Test
    public void sU_createNewPlaylist_withOther(){
        super.mU_createNewPlaylist_withOther();
    }

    @Test
    public void sU_createNewPlaylist_WithMyFiles(){
        super.mU_createNewPlaylist_WithMyFiles();
    }

    @Test
    public void sU_createNewPlaylist_WithNewsRoom(){
        super.mU_createNewPlaylist_WithNewsRoom();
    }

    @Test
    public void sU_canDeleteAddedClipFromPL(){
        super.mU_canDeleteAddedClipFromPL();
    }

    @Test
    public void sU_setUpClipVolume(){
        super.mU_setUpClipVolume();
    }

    @Test
    public void sU_setClipColor(){
        super.mU_setClipColor();
    }
}
