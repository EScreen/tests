package playlistTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import happeningTest.MainUser_HappeningTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_PowerBlockTest extends MainUser_PowerBlockTest {

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaSubUser1", "os123123");
        Configuration.timeout = 20000;
        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }
    @After
    public void afterTest(){
        close();
    }

    @Override
    @Test
    public void createNewPowerBlock_landscape() {
        super.createNewPowerBlock_landscape();
    }

    @Override
    @Test
    public void createNewPowerBlock_portrait() {
        super.createNewPowerBlock_portrait();
    }

    @Override
    @Test
    public void previewDisplaysEntirely() {
        super.previewDisplaysEntirely();
    }

    @Override
    @Test
    public void deletePowerBl() {
        super.deletePowerBl();
    }

    @Override
    @Test
    public void activatePowerBl() {
        super.activatePowerBl();
    }

    @Override
    @Test
    public void activatePowerBl_SeveralPlayers() {
        super.activatePowerBl_SeveralPlayers();
    }

    @Override
    @Test
    public void searchPowerBl() {
        super.searchPowerBl();
    }

    @Override
    @Test
    public void createNewPowerBl_withFormula() {
        super.createNewPowerBl_withFormula();
    }

    @Override
    @Test
    public void createNewPowerBl_withNewsRoom() {
        super.createNewPowerBl_withNewsRoom();
    }

    @Override
    @Test
    public void createNewPowerBl_withMyFiles() {
        super.createNewPowerBl_withMyFiles();
    }

    @Override
    @Test
    public void createNewPowerBl_withOther() {
        super.createNewPowerBl_withOther();
    }

    @Override
    @Test
    public void canDeleteAddedClipFromPowerBl() {
        super.canDeleteAddedClipFromPowerBl();
    }

    @Override
    @Test
    public void setUpClipVolume() {
        super.setUpClipVolume();
    }

}
