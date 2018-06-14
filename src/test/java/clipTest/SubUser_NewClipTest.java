package clipTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.awt.*;
import java.io.IOException;

public class SubUser_NewClipTest extends MainUser_NewClipTest {

    @Before
    @Override
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
    @Override
    public void afterTest() {
        super.afterTest();
    }

    @Override
    @Test
    public void createNewClip() {
        super.createNewClip();
    }

    @Override
    @Test
    public void createClipWithImg() throws AWTException, IOException {
        super.createClipWithImg();
    }

    @Override
    @Test
    public void createAndAddClipToExistedPlayList() {
        super.createAndAddClipToExistedPlayList();
    }

    @Override
    @Test
    public void createAndAddClipToNewPlayList() {
        super.createAndAddClipToNewPlayList();
    }

    @Override
    @Test
    public void sortByCategories() {
        super.sortByCategories();
    }

    @Override
    @Test
    public void sortTemplatesByOrientation() {
        super.sortTemplatesByOrientation();
    }

    @Override
    @Test
    public void createClipAndAddImgToLibr() throws AWTException, IOException {
        super.createClipAndAddImgToLibr();
    }
}
