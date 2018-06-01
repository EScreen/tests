package playlistTest;

import clipTest.MainUser_ClipLibraryTest;
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
    public void sU_playListsSorting(){
        super.mU_playListsSorting();
    }

    @Test
    public void sU_playListsSearching(){
        super.mU_playListsSearching();
    }
}
