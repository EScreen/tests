package playlistTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class SubUser_ManagePlayListTest extends MainUser_ManagePlayListTest {

    @Before
    @Override
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
    @Override
    public void afterTest() {
        super.afterTest();
    }

    @Override
    @Test
    public void playListsSorting() {
        super.playListsSorting();
    }

    @Override
    @Test
    public void playListsSearching() {
        super.playListsSearching();
    }



}
