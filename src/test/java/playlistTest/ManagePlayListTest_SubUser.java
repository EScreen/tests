package playlistTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;

public class ManagePlayListTest_SubUser {
    ManagePlayListTest_MainUser mainUserManagePlayListTest = new ManagePlayListTest_MainUser();

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
