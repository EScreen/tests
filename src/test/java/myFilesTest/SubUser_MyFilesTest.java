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
import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_MyFilesTest extends MainUser_MyFilesTest {

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
    public void uploadImageToOwn() throws AWTException, IOException {
        super.uploadImageToOwn();
    }


}

