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
        WebDriverRunner.getWebDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaSubUser1", "os123123");
        Configuration.timeout = 20000;
        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

    @After
    public void afterTest() {
        close();
    }

    @Override
    @Test
    public void createNewPlaylist_landscape() {
        super.createNewPlaylist_landscape();
    }

    @Override
    @Test
    public void createNewPlaylist_withFormula() {
        super.createNewPlaylist_withFormula();
    }

    @Override
    @Test
    public void createNewPlaylist_withOther() {
        super.createNewPlaylist_withOther();
    }

    @Override
    @Test
    public void createNewPlaylist_portrait() {
        super.createNewPlaylist_portrait();
    }

    @Override
    @Test
    public void createNewPlaylist_WithMyFiles() {
        super.createNewPlaylist_WithMyFiles();
    }

    @Override
    @Test
    public void createNewPlaylist_WithNewsRoom() {
        super.createNewPlaylist_WithNewsRoom();
    }

    @Override
    @Test
    public void canDeleteAddedClipFromPL() {
        super.canDeleteAddedClipFromPL();
    }

    @Override
    @Test
    public void setUpClipVolume() {
        super.setUpClipVolume();
    }

    @Override
    @Test
    public void setClipColor() {
        super.setClipColor();
    }

}
