package happeningTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class HappeningTest_SubUser {

    HappeningTest_MainUser mainUserHappeningTest = new HappeningTest_MainUser();

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }
    @After
    public void afterTest(){
        close();
    }


    @Test
    public void createHappening() {
        mainUserHappeningTest.createHappening();
    }

    @Test
    public void createHappeningWithFile() {
        mainUserHappeningTest.createHappeningWithFile();
    }

    @Test
    public void editHappName() {
        mainUserHappeningTest.editHappName();
    }

    @Test
    public void editMessage() {
        mainUserHappeningTest.editMessage();
    }

    @Test
    public void editAndAddImgToMessage() {
        mainUserHappeningTest.editAndAddImgToMessage();
    }

    @Test
    public void deleteMessage() {
        mainUserHappeningTest.deleteMessage();
    }

    @Test
    public void deleteHappening() {
        mainUserHappeningTest.deleteHappening();
    }
}
