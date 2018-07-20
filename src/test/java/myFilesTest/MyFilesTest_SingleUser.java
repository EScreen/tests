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

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;

public class MyFilesTest_SingleUser {
    MyFilesTest_MainUser myFilesTest_mainUser = new MyFilesTest_MainUser();

    @Before
    public void beforeTest(){
        Precondition.beforeSingleUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void uploadImageToOwn() throws IOException {
        myFilesTest_mainUser.uploadImageToOwn();
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
        sleep(3000);
        $(myFilesPage.addFileButton).click();
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile3.scpt");


        $(myFilesPage.saveButton).click();

        $("tbody>tr:nth-child(1)>td:nth-child(2)").shouldHave(Condition.text("Smile2"));
        $("tbody>tr:nth-child(2)>td:nth-child(2)").shouldHave(Condition.text("Smile3"));
    }

    @Test
    public void renameUploadedImage()throws IOException {
        myFilesTest_mainUser.renameUploadedImage();
    }

    @Test
    public void cropUploadedImage() throws IOException {
    myFilesTest_mainUser.cropUploadedImage();
    }

    @Test
    public void editNameAndCategory() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        $(myFilesPage.categorySelector).selectOptionContainingText("Two");
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile4.scpt");
        $(myFilesPage.saveButton).click();
        sleep(2000);

        $(myFilesPage.settingsFileButton).click();
        $(myFilesPage.editFile).click();

        String newName = GenerateData.generateString(4);
        $(myFilesPage.editNameField).setValue(newName);
        $(By.xpath("//ul[@class=\"padded separate-sections\"]/li[3]/select/option[contains(text(),'Three')]")).click();

        $(myFilesPage.saveButton).click();
        $(myFilesPage.uploadedFileName).shouldHave(Condition.exactText(newName));
        $("tbody>tr>td:nth-child(5)").shouldHave(Condition.exactText("Three"));;
    }

    @Test
    public void pickAnotherFile() throws IOException {
        myFilesTest_mainUser.pickAnotherFile();
    }

    @Test
    public void uploadPDF() throws IOException {
        myFilesTest_mainUser.uploadPDF();
    }

    @Test
    public void uploadPDF_4Pages() throws IOException {
        myFilesTest_mainUser.uploadPDF_4Pages();
    }

    @Test
    public void renameUploadPDF() throws IOException {
        myFilesTest_mainUser.renameUploadPDF();
    }

    @Test
    public void uploadVideo() throws IOException {
        myFilesTest_mainUser.uploadVideo();
    }

    @Test
    public void showLandscapeVideoAsPortrait() throws IOException {
        myFilesTest_mainUser.showLandscapeVideoAsPortrait();
    }

    @Test
    public void deleteFile(){
        myFilesTest_mainUser.deleteFile();
    }




}
