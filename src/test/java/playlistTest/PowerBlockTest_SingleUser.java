package playlistTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;

public class PowerBlockTest_SingleUser {
    PowerBlockTest_MainUser powerBlockTest_mainUser = new PowerBlockTest_MainUser();

    @Before
    public void before(){
        Precondition.beforeSingleUserTests();
    }

    @After
    public void after(){
        close();
    }

    @Test
    public void createNewPowerBlock_landscape(){
        powerBlockTest_mainUser.createNewPowerBlock_landscape();
    }

    @Test
    public void createNewPowerBlock_portrait(){
        powerBlockTest_mainUser.createNewPowerBlock_portrait();
    }

    @Test
    public void previewDisplaysEntirely(){
        powerBlockTest_mainUser.previewDisplaysEntirely();
    }

    @Test
    public void deletePowerBl(){
        powerBlockTest_mainUser.deletePowerBl();
    }

    @Test
    public void activatePowerBl(){
        powerBlockTest_mainUser.activatePowerBl();
    }

    @Test
    public void activatePowerBl_SeveralPlayers(){
        powerBlockTest_mainUser.activatePowerBl_SeveralPlayers();
    }
}
