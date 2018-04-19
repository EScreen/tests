package clipTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;
import helpers.GenerateData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import javax.sound.sampled.Clip;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Anna on 16/04/2018.
 */
public class ClipLibraryTest {
    WebDriver driver;

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        open("https://ppmanager.easyscreen.tv/login");
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaMainUser", "os123123");
        Configuration.timeout = 10000;
    }

    @After
    public void afterTest(){
        close();
    }


    //NewClipTest of editing name of clip
    @Test
    public void mainUser_EditNameOfClip() throws InterruptedException {
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData generateData = new GenerateData();

        $(container.media).click();
        $(container.clipLibrary).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();

        $(createNewClipPage.templateTestNameField).clear();
        $(createNewClipPage.templateTestNameField).setValue(generateData.generateString(4) + " Edited");

        createNewClipPage.checkAvailableForUsers();

        String createdName = $(createNewClipPage.templateTestNameField).attr("value");

        $(createNewClipPage.templateSummaryTab).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//td//span[@class=\"ng-binding\"]")).shouldHave(Condition.text(createdName));
    }



    //NewClipTest of appearance "Share clip" table after unchecking "Available for all users" checkbox.
    @Test
    public void mainUser_AppearanceOfShareClipTable() {
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();


        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();

        createNewClipPage.unCheckAvailableForUsers();

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//div[@class=\"box-header\"]/span")).shouldHave(Condition.text("Check the box of the user(s)"));
    }

    @Test
    public void clipSearch() throws InterruptedException {
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        $(container.media).click();
        $(container.clipLibrary).click();

        String searchedNameOfClip = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[5]/td[2]/span")).text();

        $(clipLibraryPage.searchField).setValue(searchedNameOfClip);
        Thread.sleep(3000);

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr/td[2]/span")).shouldHave(Condition.text(searchedNameOfClip));
    }
}
