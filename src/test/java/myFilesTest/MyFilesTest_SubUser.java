package myFilesTest;

import com.codeborne.selenide.Condition;
import helpers.GenerateData;
import helpers.Precondition;
import helpers.UploadingFiles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Container;
import pages.mediaPages.MyFilesPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class MyFilesTest_SubUser {
    MyFilesTest_MainUser mainUserMyFilesTest = new MyFilesTest_MainUser();

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }
    @After
    public void afterTest(){
        close();
    }

    @Test
    public void uploadImageToOwn() throws IOException {
        mainUserMyFilesTest.uploadImageToOwn();
    }

    @Test
    public void uploadSeveralImages() throws IOException {
        mainUserMyFilesTest.uploadSeveralImages();
    }

    @Test
    public void renameUploadedImage() throws IOException {
        mainUserMyFilesTest.renameUploadedImage();
    }

    @Test
    public void cropUploadedImage() throws IOException {
        mainUserMyFilesTest.cropUploadedImage();
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

    @Test
    public void pickAnotherFile() throws IOException {
        mainUserMyFilesTest.pickAnotherFile();
    }

    @Test
    public void uploadPDF() throws IOException {
        mainUserMyFilesTest.uploadPDF();
    }

    @Test
    public void uploadPDF_4Pages() throws IOException {
        mainUserMyFilesTest.uploadPDF_4Pages();
    }

    @Test
    public void renameUploadPDF() throws IOException {
        mainUserMyFilesTest.renameUploadPDF();
    }

    @Test
    public void uploadVideo() throws IOException {
        mainUserMyFilesTest.uploadVideo();
    }

    @Test
    public void showLandscapeVideoAsPortrait() throws IOException {
        mainUserMyFilesTest.showLandscapeVideoAsPortrait();
    }

    @Test
    public void deleteFile() {
        mainUserMyFilesTest.deleteFile();
    }

    @Test
    public void categoryFiltering() {
        mainUserMyFilesTest.categoryFiltering();
    }

    @Test
    public void typeFileFiltering() {
        mainUserMyFilesTest.typeFileFiltering();
    }
}

