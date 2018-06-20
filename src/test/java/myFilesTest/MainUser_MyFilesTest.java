package myFilesTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
import helpers.UploadingFiles;
import helpers.Waitings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import pages.Container;
import pages.LoginPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;
import pages.mediaPages.MyFilesPage;
import pages.playlistsPages.ManagePlaylistsPage;
import pages.playlistsPages.PlaylistPage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import static com.codeborne.selenide.Selenide.*;
import static junit.framework.TestCase.assertTrue;

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
        UploadingFiles uploadingFiles = new UploadingFiles();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        $(myFilesPage.categorySelector).selectOptionContainingText("Two");

        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile4.scpt");

        sleep(2000);

        $(myFilesPage.saveButton).click();

        $(myFilesPage.uploadedFileName).shouldHave(Condition.text("Smile4"));
        $("tbody>tr>td:nth-child(5)").shouldHave(Condition.exactText("Two"));
    }

    @Test
    public void uploadImageToFormula() throws AWTException, IOException{
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.sectionSelector).selectOptionContainingText("Formula");

        $(myFilesPage.addFileButton).click();
        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile3.scpt");

        $(myFilesPage.saveButton).click();
        $(myFilesPage.formulaTab).click();
        $(myFilesPage.uploadedFileName).shouldHave(Condition.text("Smile3"));
    }

    @Test
    public void uploadSeveralImages() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();

        $(myFilesPage.addFileButton).click();
        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/Scrpt_upload_Smile2.scpt");
        sleep(10000);
        $(myFilesPage.addFileButton).click();
        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile3.scpt");

        sleep(10000);
        $(myFilesPage.saveButton).click();

        $("tbody>tr:nth-child(1)>td:nth-child(2)").shouldHave(Condition.text("Smile2"));
        $("tbody>tr:nth-child(2)>td:nth-child(2)").shouldHave(Condition.text("Smile3"));
    }

    @Test
    public void renameUploadedImage() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();

        $(myFilesPage.addFileButton).click();
        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile5.scpt");

        sleep(1000);
        $(myFilesPage.renameFileButton).click();
        String newName = genData.generateString(3);
        $(myFilesPage.newNameField).setValue(newName);
        $(myFilesPage.saveEditionButton).click();

        $(myFilesPage.saveButton).click();
        $(myFilesPage.uploadedFileName).shouldHave(Condition.exactText(newName));
    }

    @Test
        public void cropUploadedImage() throws IOException{
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();

        $(myFilesPage.addFileButton).click();
        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile5.scpt");

        Dimension sizeBefore = $("#filelist-filename-uploadelement img").getSize();

        $(myFilesPage.setUpFileButton).click();
        $(myFilesPage.cropButton).click();
        $(myFilesPage.saveEditionButton);

        Dimension sizeAfter = $("#pldrop-zone img").getSize();

        Assert.assertTrue(sizeBefore != sizeAfter);
    }

    @Test
    public void editNameSectionCategory() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        $(myFilesPage.categorySelector).selectOptionContainingText("Two");
        $(myFilesPage.sectionSelector).selectOptionContainingText("Own");
        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile4.scpt");
        $(myFilesPage.saveButton).click();

        $(myFilesPage.settingsFileButton).click();
        $(myFilesPage.editFile).click();

        String newName = genData.generateString(4);
        $(myFilesPage.editNameField).setValue(newName);
        $(By.xpath("//*[@class=\"control-group\"]/div/select/option[contains(text(),'Formula')]")).click();
        $(By.xpath("//ul[@class=\"padded separate-sections\"]/li[3]/select/option[contains(text(),'Three')]")).click();
        $(myFilesPage.saveButton).click();

        $(myFilesPage.formulaTab).click();
        $(myFilesPage.uploadedFileName).shouldHave(Condition.exactText(newName));
        $("tbody>tr>td:nth-child(5)").shouldHave(Condition.exactText("Three"));

    }

    @Test
    public void pickAnotherFile() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_nature.scpt");
        $(myFilesPage.saveButton).click();

        Dimension sizeBefore = $("tbody>tr>td>center>a>img").getSize();
        String nameBefore = $(myFilesPage.uploadedFileName).text();

        $(myFilesPage.settingsFileButton).click();
        $(myFilesPage.editFile).click();

        $(myFilesPage.pickAnotherFileButton).click();
        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile5.scpt");
        sleep(10000);
        $(myFilesPage.saveButton).click();

        Dimension sizeAfter = $("tbody>tr>td>center>a>img").getSize();
        String nameAfter = $(myFilesPage.uploadedFileName).text();

        Assert.assertTrue(sizeBefore != sizeAfter);
        Assert.assertTrue(nameBefore.equals(nameAfter));
    }

    @Test
    public void uploadPDF() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.typeSelector).selectOptionContainingText("PDF convert to image");
        $(myFilesPage.addFileButton).click();

        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_pdfFile_1Page.scpt");
        sleep(4000);
        $(myFilesPage.saveButton).click();

        $("tbody>tr:first-child>td:nth-child(8)>span").waitUntil(Condition.text("Ready"),120000);
        $("tbody>tr:first-child>td:nth-child(4)>span").shouldHave(Condition.text("Image"));
    }

    @Test
    public void uploadPDF_4Pages() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.typeSelector).selectOptionContainingText("PDF convert to image");
        $(myFilesPage.addFileButton).click();

        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_pdfFile_4Pages.scpt");
        sleep(4000);
        $(myFilesPage.saveButton).click();

        $("tbody>tr:first-child>td:nth-child(8)>span").waitUntil(Condition.text("Ready"),180000);

        $("tbody>tr:nth-child(-n+4)>td:nth-child(2)").shouldHave(Condition.text("pdfFile"));
        $("tbody>tr:nth-child(-n+4)>td:nth-child(4)").shouldHave(Condition.text("Image"));

    }

    @Test
    public void renameUploadPDF() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.typeSelector).selectOptionContainingText("PDF convert to image");
        $(myFilesPage.addFileButton).click();

        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_pdfFile_1Page.scpt");

        $(myFilesPage.renameFileButton).click();
        String newName = genData.generateString(3);
        $(myFilesPage.newNameField).setValue(newName);
        $(myFilesPage.saveEditionButton).click();

        $("table>tbody>tr>td:nth-child(2)").shouldHave(Condition.exactText(newName));
    }

    @Test
    public void uploadVideo() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.typeSelector).selectOptionContainingText("Video");
        $(myFilesPage.addFileButton).click();

        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Video_1280x720_landscape.scpt");
        $(myFilesPage.saveButton).click();

        $("tbody>tr>td:nth-child(2)").shouldHave(Condition.text("Video"));
    }


    @Test
    public void showLandscapeVideoAsPortrait() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.typeSelector).selectOptionContainingText("Video");
        $(myFilesPage.showPortraitCheckBox).click();
        $(myFilesPage.addFileButton).click();

        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Video_1280x720_landscape.scpt");
        $(myFilesPage.saveButton).click();
        $("tbody>tr:first-child>td:nth-child(8)>span").waitUntil(Condition.text("Ready"),180000);
        sleep(2000);
        sleep(2000);

        int height = $("table>tbody>tr:first-child img").getSize().height;

        Assert.assertTrue(height == 178);
    }

    @Test
    public void deleteFile() {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        String fileName = $(myFilesPage.uploadedFileName).text();

        $(myFilesPage.settingsFileButton).click();
        $(myFilesPage.deleteFile).click();
        sleep(1000);
        $(myFilesPage.yesDelete).click();

        $(myFilesPage.successAlert).should(Condition.appear);
        $$("table>tbody>tr>td:nth-child(2)").findBy(Condition.exactText(fileName)).shouldNot(Condition.appears);
    }

    @Test
    public void mU_canNotUseSubUsersFiles() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();
        UploadingFiles uploadingFiles = new UploadingFiles();

        container.goToSubUser1();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        uploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile4.scpt");
        sleep(2000);
        $(myFilesPage.saveButton).click();
        String savedFileName = $(myFilesPage.uploadedFileName).text();

        container.goToMainUser();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.searchField).sendKeys(savedFileName);

        $$("table>tbody>tr>td:nth-child(2)").findBy(Condition.exactText(savedFileName)).shouldNot(Condition.appears);
    }

    @Test
    public void categoryFiltering(){
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.categoryFilter).selectOptionContainingText("Three");

        ElementsCollection elements = $$("table>tbody>tr>td:nth-child(5)");
        for(SelenideElement element: elements){
            element.shouldHave(Condition.exactText("Three"));
        }
    }

    @Test
    public void typeFileFiltering(){
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.typeFileFilter).selectOptionContainingText("Show only images");

        ElementsCollection elements = $$("table>tbody>tr>td:nth-child(4)");
        for(SelenideElement element: elements){
            element.shouldHave(Condition.exactText("Image"));
        }
    }





}
