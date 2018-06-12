package happeningTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.GenerateData;
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

public class SubUser_HappeningTest extends MainUser_HappeningTest{

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        Configuration.browserSize = "1880x768";
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
    public void createHappening() {
        super.createHappening();
    }

    @Override
    @Test
    public void createHappeningWithFile() {
        super.createHappeningWithFile();
    }

    @Override
    @Test
    public void editHappName() {
        super.editHappName();
    }

    @Override
    @Test
    public void editMessage() {
        super.editMessage();
    }

    @Override
    @Test
    public void editAndAddImgToMessage() {
        super.editAndAddImgToMessage();
    }

    @Override
    @Test
    public void deleteMessage() {
        super.deleteMessage();
    }

    @Override
    @Test
    public void deleteHappening() {
        super.deleteHappening();
    }
}
