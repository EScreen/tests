package myFilesTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.GenerateData;
import helpers.Precondition;
import helpers.UploadingFiles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.LoginPage;
import pages.mediaPages.MyFilesPage;
import playlistTest.MainUser_PowerBlockTest;

import java.awt.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class SubUser_MyFilesTest extends MainUser_MyFilesTest {

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }
    @After
    public void afterTest(){
        close();
    }

    @Override
    @Test
    public void uploadImageToOwn() throws AWTException, IOException {
        super.uploadImageToOwn();
    }

    @Override
    @Test
    public void uploadSeveralImages() throws IOException {
        super.uploadSeveralImages();
    }

    @Override
    @Test
    public void renameUploadedImage() throws IOException {
        super.renameUploadedImage();
    }

    @Override
    @Test
    public void cropUploadedImage() throws IOException {
        super.cropUploadedImage();
    }

    @Test
    public void editNameAndCategory() throws IOException {
        pages.Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        $(myFilesPage.categorySelector).selectOptionContainingText("Two");
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile4.scpt");
        $(myFilesPage.saveButton).click();

        $(myFilesPage.settingsFileButton).click();
        $(myFilesPage.editFile).click();

        String newName = GenerateData.generateString(4);
        $(myFilesPage.editNameField).setValue(newName);
        $(By.xpath("//ul[@class=\"padded separate-sections\"]/li[3]/select/option[contains(text(),'Three')]")).click();
        $(myFilesPage.saveButton).click();

        $(myFilesPage.uploadedFileName).shouldHave(Condition.exactText(newName));
        $("tbody>tr>td:nth-child(5)").shouldHave(Condition.exactText("Three"));
    }

    @Override
    @Test
    public void pickAnotherFile() throws IOException {
        super.pickAnotherFile();
    }

    @Override
    @Test
    public void uploadPDF() throws IOException {
        super.uploadPDF();
    }

    @Override
    @Test
    public void uploadPDF_4Pages() throws IOException {
        super.uploadPDF_4Pages();
    }

    @Override
    @Test
    public void renameUploadPDF() throws IOException {
        super.renameUploadPDF();
    }

    @Override
    @Test
    public void uploadVideo() throws IOException {
        super.uploadVideo();
    }

    @Override
    @Test
    public void showLandscapeVideoAsPortrait() throws IOException {
        super.showLandscapeVideoAsPortrait();
    }

    @Override
    @Test
    public void deleteFile() {
        super.deleteFile();
    }

    @Override
    @Test
    public void categoryFiltering() {
        super.categoryFiltering();
    }

    @Override
    @Test
    public void typeFileFiltering() {
        super.typeFileFiltering();
    }
}

