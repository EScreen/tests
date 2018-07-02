package playlistTest;

import clipTest.MainUser_ClipLibraryTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_ManagePlayListTest {
    MainUser_ManagePlayListTest mainUserManagePlayListTest = new MainUser_ManagePlayListTest();

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }

    @After
    public void afterTest() {
        close();
    }

    @Test
    public void sU_playListsSorting(){
        mainUserManagePlayListTest.playListsSorting();
    }

    @Test
    public void sU_playListsSearching(){
        mainUserManagePlayListTest.playListsSearching();
    }
}
