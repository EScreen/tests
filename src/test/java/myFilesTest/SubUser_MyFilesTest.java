package myFilesTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import playlistTest.MainUser_PowerBlockTest;

import java.awt.*;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_MyFilesTest extends MainUser_MyFilesTest {

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
    public void sU_uploadImage() throws AWTException {
        super.mU_uploadImage();
    }
}

