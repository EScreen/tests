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
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaSubUser1", "os123123");
        Configuration.timeout = 20000;
    }
    @After
    public void afterTest(){
        close();
    }

    @Test
    public void sU_createNewPowerBlock_landscape(){
        super.mU_createNewPowerBlock_landscape();
    }

    @Test
    public void sU_createNewPowerBlock_portrait(){
        super.mU_createNewPowerBlock_portrait();
    }

    @Test
    public void sU_activatePowerBl(){
        super.mU_activatePowerBl();
    }

    @Test
    public void sU_searchPowerBl(){
        super.mU_searchPowerBl();
    }

    @Test
    public void sU_createNewPowerBl_withFormula(){
        super.mU_createNewPowerBl_withFormula();
    }

    @Test
    public void sU_createNewPowerBl_withNewsRoom(){
        super.mU_createNewPowerBl_withNewsRoom();
    }

    @Test
    public void sU_createNewPowerBl_withMyFiles(){
        super.mU_createNewPowerBl_withMyFiles();
    }

    @Test
    public void sU_createNewPowerBl_withOther(){
        super.mU_createNewPowerBl_withOther();
    }

    @Test
    public void sU_canDeleteAddedClipFromPowerBl(){
        super.mU_canDeleteAddedClipFromPowerBl();
    }

    @Test
    public void sU_setUpClipVolume(){
        super.mU_setUpClipVolume();
    }
}
