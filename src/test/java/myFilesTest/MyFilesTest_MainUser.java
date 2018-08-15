package myFilesTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
import helpers.Precondition;
import helpers.UploadingFiles;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.LoginPage;
import pages.mediaPages.MyFilesPage;

import java.awt.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class MyFilesTest_MainUser {

    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }
    @After
    public void afterTest(){
        close();
    }


    @Test
    public void uploadImageToOwn() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        $(myFilesPage.categorySelector).selectOptionContainingText("Three");

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile4.scpt");

        $(myFilesPage.saveButton).click();

        $(myFilesPage.uploadedFileName).shouldHave(Condition.text("Smile4"));
        $("tbody>tr>td:nth-child(5)").shouldHave(Condition.exactText("Three"));
    }

    @Test
    public void uploadImageToFormula() throws IOException{
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
        sleep(3000);
        $(myFilesPage.addFileButton).click();
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile3.scpt");


        $(myFilesPage.saveButton).click();

        $("tbody>tr:nth-child(1)>td:nth-child(2)").shouldHave(Condition.text("Smile3"));
        $("tbody>tr:nth-child(2)>td:nth-child(2)").shouldHave(Condition.text("Smile2"));
    }

    @Test
    public void renameUploadedImage() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();

        $(myFilesPage.addFileButton).click();
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile5.scpt");

        $(myFilesPage.renameFileButton).click();
        String newName = GenerateData.generateString(3);
        $(myFilesPage.newNameField).setValue(newName);
        $(myFilesPage.saveEditionButton).click();

        $(myFilesPage.saveButton).click();
        $(myFilesPage.uploadedFileName).shouldHave(Condition.exactText(newName));
    }

    @Test
    public void cropUploadedImage() throws IOException{
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();

        $(myFilesPage.addFileButton).click();
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile5.scpt");
        Dimension sizeBefore = $("#filelist-filename-uploadelement img").getSize();


        $(myFilesPage.setUpFileButton).click();
        $(myFilesPage.cropButton).click();
        $(myFilesPage.saveEditionButton);

        Dimension sizeAfter = $("#pldrop-zone img").getSize();

        Assert.assertNotSame(sizeBefore, sizeAfter);

    }

    @Test
    public void editNameSectionCategory() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        $(myFilesPage.categorySelector).selectOptionContainingText("Two");
        $(myFilesPage.sectionSelector).selectOptionContainingText("Own");
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile4.scpt");
        $(myFilesPage.saveButton).click();

        $(myFilesPage.settingsFileButton).click();
        $(myFilesPage.editFile).click();

        String newName = GenerateData.generateString(4);
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

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_nature.scpt");
        $(myFilesPage.saveButton).click();

        Dimension sizeBefore = $("tbody>tr>td>center>a>img").getSize();
        String nameBefore = $(myFilesPage.uploadedFileName).text();

        $(myFilesPage.settingsFileButton).click();
        $(myFilesPage.editFile).click();

        $(myFilesPage.pickAnotherFileButton).click();
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile5.scpt");
        sleep(5000);
        $(myFilesPage.saveButton).click();

        Dimension sizeAfter = $("tbody>tr>td>center>a>img").getSize();
        String nameAfter = $(myFilesPage.uploadedFileName).text();

        Assert.assertNotSame(sizeBefore, sizeAfter);
        Assert.assertEquals(nameBefore, nameAfter);
    }

    @Test
    public void uploadPDF() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.typeSelector).selectOptionContainingText("PDF convert to image");
        $(myFilesPage.addFileButton).click();

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_pdfFile_1Page.scpt");
        $(myFilesPage.saveButton).click();

        $("tbody>tr:first-child>td:nth-child(8)>span").waitUntil(Condition.text("Ready"),120000);
        $("tbody>tr:first-child>td:nth-child(4)>span").shouldHave(Condition.text("Image"));

    }

    @Test
    public void uploadPDF_4Pages() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.typeSelector).selectOptionContainingText("PDF convert to image");
        $(myFilesPage.addFileButton).click();

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_pdfFile_4Pages.scpt");
        $(myFilesPage.saveButton).click();

        $("tbody>tr:first-child>td:nth-child(8)>span").waitUntil(Condition.text("Ready"),180000);
        $("tbody>tr:nth-child(-n+4)>td:nth-child(2)").shouldHave(Condition.text("pdfFile"));
        $("tbody>tr:nth-child(-n+4)>td:nth-child(4)").shouldHave(Condition.text("Image"));
    }

    @Test
    public void renameUploadPDF() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.typeSelector).selectOptionContainingText("PDF convert to image");
        $(myFilesPage.addFileButton).click();

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_pdfFile_1Page.scpt");

        $(myFilesPage.renameFileButton).click();
        String newName = GenerateData.generateString(3);
        $(myFilesPage.newNameField).setValue(newName);
        $(myFilesPage.saveEditionButton).click();

        $("table>tbody>tr>td:nth-child(2)").shouldHave(Condition.exactText(newName));
    }

    @Test
    public void uploadVideo() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.typeSelector).selectOptionContainingText("Video");
        $(myFilesPage.addFileButton).click();

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Video_1280x720_landscape.scpt");
        $(myFilesPage.saveButton).click();

        $("tbody>tr>td:nth-child(2)").shouldHave(Condition.text("Video"));
    }

    @Test
    public void showLandscapeVideoAsPortrait() throws IOException {
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();

        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.typeSelector).selectOptionContainingText("Video");
        $(myFilesPage.showPortraitCheckBox).click();
        $(myFilesPage.addFileButton).click();

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Video_1280x720_landscape.scpt");
        $(myFilesPage.saveButton).click();
        $("tbody>tr:first-child>td:nth-child(8)>span").waitUntil(Condition.text("Ready"),180000);
        sleep(2000);
        sleep(2000);

        int height = $("table>tbody>tr:first-child img").getSize().height;

        Assert.assertEquals(height, 178);
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

        container.goToSubUser1();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.uploadFilesButton).click();
        $(myFilesPage.addFileButton).click();

        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/scrpt_Upload_Smile4.scpt");
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
        $(myFilesPage.categoryFilter).selectOptionContainingText("Two");

        sleep(1000);
        ElementsCollection elements = $$("table>tbody>tr>td:nth-child(5)");
        for(SelenideElement element: elements){
            element.shouldHave(Condition.exactText("Two"));
        }
    }

    @Test
    public void typeFileFiltering(){
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.typeFileFilter).selectOptionContainingText("Show only images");

        ElementsCollection elements = $$("table>tbody>tr>td:nth-child(4)>span");
        for(SelenideElement element: elements){
            element.shouldHave(Condition.exactText("Image"));
            }
    }













}
