package clipTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.awt.*;

public class SubUser_NewClipTest extends MainUser_NewClipTest {

    @Before
    @Override
    public void beforeTest() {
        WebDriverRunner.setWebDriver(new ChromeDriver());
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaSubUser1", "os123123");
        Configuration.timeout = 20000;
    }

    @After
    @Override
    public void afterTest() {
        super.afterTest();
    }

    @Test
    public void sU_createNewClip(){
        super.mU_createNewClip();
    }

    @Test
    public void sU_createAndAddClipToExistedPlayList(){
        super.mU_createAndAddClipToExistedPlayList();
    }

    @Test
    public void sU_createAndAddClipToNewPlayList(){
        super.mU_createAndAddClipToNewPlayList();
    }

    @Test
    public void sU_createClipWithImg() throws AWTException {
        super.mU_createClipWithImg();
    }

    @Test
    public void sU_sortByCategories(){
        super.mU_sortByCategories();
    }

    @Test
    public void sU_sortTemplatesByOrientation(){
        super.mU_sortTemplatesByOrientation();
    }

}
