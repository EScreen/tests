package happeningTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.LoginPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.CreateNewClipPage;

import static com.codeborne.selenide.Selenide.*;

public class SubUser_HappeningTest {

    MainUser_HappeningTest mainUserHappeningTest = new MainUser_HappeningTest();

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
