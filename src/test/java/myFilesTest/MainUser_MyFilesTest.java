package myFilesTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
import helpers.UploadingFiles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Container;
import pages.LoginPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;
import pages.mediaPages.MyFilesPage;
import pages.playlistsPages.ManagePlaylistsPage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;

public class MainUser_MyFilesTest {

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaMainUser", "os123123");
        Configuration.timeout = 20000;
        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }
    @After
    public void afterTest(){
        close();
    }


    @Test
    public void uploadImageToOwn() throws AWTException, IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        $(myFilesPage.categorySelector).selectOptionContainingText("Two");

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile4.scpt");

        sleep(2000);

        $(myFilesPage.saveButton).click();

        $(myFilesPage.uploadedFileName).shouldHave(Condition.text("Smile4"));
        $("tbody>tr>td:nth-child(5)").shouldHave(Condition.exactText("Two"));
    }

    @Test
    public void uploadImageToFormula() throws AWTException, IOException{
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.sectionSelector).selectOptionContainingText("Formula");

        $(myFilesPage.addFileButton).click();
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile3.scpt");

        $(myFilesPage.saveButton).click();
        $(myFilesPage.formulaTab).click();
        $(myFilesPage.uploadedFileName).shouldHave(Condition.text("Smile3"));
    }

    @Test
    public void uploadSeveralImages() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();

        $(myFilesPage.addFileButton).click();

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/Scrpt_upload_Smile2.scpt");
        sleep(10000);
        $(myFilesPage.addFileButton).click();
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile3.scpt");


        $(myFilesPage.saveButton).click();

        $("tbody>tr:nth-child(1)>td:nth-child(2)").shouldHave(Condition.text("Smile4"));
        $("tbody>tr:nth-child(2)>td:nth-child(2)").shouldHave(Condition.text("Smile1"));
    }



}
