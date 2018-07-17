package playlistTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PowerBlockTest_SubUser {
    PowerBlockTest_MainUser mainUserPowerBlockTest = new PowerBlockTest_MainUser();

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
