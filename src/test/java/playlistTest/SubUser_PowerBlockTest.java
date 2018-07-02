package playlistTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import happeningTest.MainUser_HappeningTest;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_PowerBlockTest {
    MainUser_PowerBlockTest mainUserPowerBlockTest = new MainUser_PowerBlockTest();

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }
    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createNewPowerBlock_landscape() {
        mainUserPowerBlockTest.createNewPowerBlock_landscape();
    }

    @Test
    public void createNewPowerBlock_portrait() {
        mainUserPowerBlockTest.createNewPowerBlock_portrait();
    }

    @Test
    public void previewDisplaysEntirely() {
        mainUserPowerBlockTest.previewDisplaysEntirely();
    }

    @Test
    public void deletePowerBl() {
        mainUserPowerBlockTest.deletePowerBl();
    }

    @Test
    public void activatePowerBl() {
        mainUserPowerBlockTest.activatePowerBl();
    }

    @Test
    public void activatePowerBl_SeveralPlayers() {
        mainUserPowerBlockTest.activatePowerBl_SeveralPlayers();
    }

    @Test
    public void searchPowerBl() {
        mainUserPowerBlockTest.searchPowerBl();
    }

    @Test
    public void createNewPowerBl_withFormula() {
        mainUserPowerBlockTest.createNewPowerBl_withFormula();
    }

    @Test
    public void createNewPowerBl_withNewsRoom() {
        mainUserPowerBlockTest.createNewPowerBl_withNewsRoom();
    }

    @Test
    public void createNewPowerBl_withMyFiles() {
        mainUserPowerBlockTest.createNewPowerBl_withMyFiles();
    }

    @Test
    public void createNewPowerBl_withOther() {
        mainUserPowerBlockTest.createNewPowerBl_withOther();
    }

    @Test
    public void canDeleteAddedClipFromPowerBl() {
        mainUserPowerBlockTest.canDeleteAddedClipFromPowerBl();
    }

    @Test
    public void setUpClipVolume() {
        mainUserPowerBlockTest.setUpClipVolume();
    }

}
