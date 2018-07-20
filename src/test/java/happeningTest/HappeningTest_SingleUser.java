package happeningTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;

public class HappeningTest_SingleUser {
    HappeningTest_MainUser happeningTest_mainUser = new HappeningTest_MainUser();

    @Before
    public void beforeTest(){
        Precondition.beforeSingleUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createHappening(){
        happeningTest_mainUser.createHappening();
    }

    @Test
    public void createHappeningWithFile(){
        happeningTest_mainUser.createHappeningWithFile();
    }

    @Test
    public void editHappName(){
        happeningTest_mainUser.editHappName();
    }

    @Test
    public void editMessage(){
        happeningTest_mainUser.editMessage();
    }

    @Test
    public void editAndAddImgToMessage(){
        happeningTest_mainUser.editAndAddImgToMessage();
    }

    @Test
    public void deleteMessage(){
        happeningTest_mainUser.deleteMessage();
    }

    @Test
    public void deleteHappening(){
        happeningTest_mainUser.deleteHappening();
    }




}
