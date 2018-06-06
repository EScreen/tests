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


    }
    @After
    public void afterTest(){
        close();
    }

    @Test
    public void sU_createHappening(){
        super.mU_createHappening();
    }

    @Test
    public void sU_createHappeningWithFile(){
        super.mU_createHappeningWithFile();
    }

    @Test
    public void sU_editHappName(){
        super.mU_editHappName();
    }

    @Test
    public void su_editMessage(){
        super.mu_editMessage();
    }

    @Test
    public void sU_editAndAddImgToMessage(){
        super.mU_editAndAddImgToMessage();
    }

    @Test
    public void sU_deleteMessage(){
        super.mU_deleteMessage();
    }

    @Test
    public void sU_deleteHappening(){
        super.mU_deleteHappening();
    }







}
