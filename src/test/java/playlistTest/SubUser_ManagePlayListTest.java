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

public class SubUser_ManagePlayListTest extends MainUser_ManagePlayListTest{

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }

    @After
    public void afterTest() {
        super.afterTest();
    }

    @Test
    public void sU_playListsSorting(){
        super.playListsSorting();
    }

    @Test
    public void sU_playListsSearching(){
        super.playListsSearching();
    }
}
