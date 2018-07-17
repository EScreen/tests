package playerGroupsTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;

public class PlayerOverviewTest_SubUser {
    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }

    @After
    public void afterTest(){
        close();
    }

    PlayerOverviewTest_MainUser mainUserPlayerOverviewTest = new PlayerOverviewTest_MainUser();


    @Test
    public void filterByOfflineStatus(){
        mainUserPlayerOverviewTest.filterByOfflineStatus();
    }

    @Test
    public void filterByOnlineStatus(){
        mainUserPlayerOverviewTest.filterByOnlineStatus();
    }

    @Test
    public void playerSearching(){
        mainUserPlayerOverviewTest.playerSearching();
    }

    @Test
    public void setClassicTickertape(){
        mainUserPlayerOverviewTest.setClassicTickertape();
    }

    @Test
    public void setPortraitTickertape(){
        mainUserPlayerOverviewTest.setPortraitTickertape();
    }

    @Test
    public void uploadPhotoInTickertape() throws IOException {
        mainUserPlayerOverviewTest.uploadPhotoInTickertape();
    }

    @Test
    public void uploadPhotoFromLibr(){
        mainUserPlayerOverviewTest.uploadPhotoFromLibr();
    }

    @Test
    public void setHappInTickertape(){
        mainUserPlayerOverviewTest.setHappInTickertape();
    }
}
