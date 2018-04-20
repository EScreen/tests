package clipTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.GenerateData;
import helpers.UploadingFiles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import pages.Container;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;
import pages.mediaPages.ManagementCategoriesPage;

import java.awt.*;
import java.io.IOException;

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
        Configuration.timeout = 20000;
    }

    @After
    public void afterTest(){
        close();
    }


    //Edit name of existed clip
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

    @Test
    public void uploadFileToClip() throws IOException, AWTException {
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        UploadingFiles uploadingFiles = new UploadingFiles();


        $(container.media).click();
        $(container.clipLibrary).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();
        $(createNewClipPage.nextButton).click();

        $(By.xpath("//input[@type=\"file\"]")).click();
        sleep(2000);

        uploadingFiles.uploadFile("/Users/olgakuznetsova/projects/EScreen/src/main/resources/iphone.jpg");


        sleep(6000);

        $(createNewClipPage.templateSummaryTab).click();
        $(createNewClipPage.saveClipButton).click();

        sleep(6000);
    }

    @Test
    public void deleteClip(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.deleteClipButton).click();
        $(clipLibraryPage.yesDeleteButton).click();

        clipLibraryPage.submitDeletingClip();

        $(clipLibraryPage.successAlert).should(Condition.appears);
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

    @Test
    public void createCategory(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagementCategoriesPage managementCategoriesPage = new ManagementCategoriesPage();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.managementCategoriesbutton).click();
        $(managementCategoriesPage.createButton).click();

        $(managementCategoriesPage.nameCategoryField).setValue(genData.generateString(4));
        $(managementCategoriesPage.saveNewCategoryButton).click();

        $(managementCategoriesPage.successAlert).shouldBe(Condition.appears);
    }

    @Test
    public void searchCategory(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagementCategoriesPage managementCategoriesPage = new ManagementCategoriesPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.managementCategoriesbutton).click();

        String searchedCategory = $$(By.xpath("//span[@editable-text=\"item.name\"]")).get(4).text();

        $(managementCategoriesPage.searchField).setValue(searchedCategory);

        $(managementCategoriesPage.nameOfCategory).shouldHave(Condition.text(searchedCategory));
    }

    @Test
    public void deleteCategory(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagementCategoriesPage managementCategoriesPage = new ManagementCategoriesPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.managementCategoriesbutton).click();

        String deletedCategoryName = $(managementCategoriesPage.nameOfCategory).text();
        $(managementCategoriesPage.deleteCategory).click();
        $(managementCategoriesPage.yesDeleteCategoryButton).click();

        $(managementCategoriesPage.nameOfCategory).shouldNotHave(Condition.text(deletedCategoryName));
    }

    @Test
    public void editCategoryName(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagementCategoriesPage managementCategoriesPage = new ManagementCategoriesPage();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.managementCategoriesbutton).click();

        $(managementCategoriesPage.editCategoryButton).click();
        $(managementCategoriesPage.editCategoryNameField).setValue(genData.generateString(3)).submit();

        $(managementCategoriesPage.successAlert).should(Condition.appears);
    }



}
