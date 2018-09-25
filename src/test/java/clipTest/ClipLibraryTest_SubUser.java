package clipTest;

import com.codeborne.selenide.Condition;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Container;
import pages.LoginPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class ClipLibraryTest_SubUser {

    ClipLibraryTest_MainUser mainUserClipLibraryTest = new ClipLibraryTest_MainUser();

    @Before
    public void beforeTest() {
        Precondition.beforeSubUser1Tests();
    }

    @After
    public void afterTest() {
        close();
    }

    @Test
    public void uploadImgToClip() throws IOException {
        mainUserClipLibraryTest.uploadImgToClip();
    }

    @Test
    public void uploadImgFromLibrToClip() {
        mainUserClipLibraryTest.uploadImgFromLibrToClip();
    }

    @Test
    public void deleteClip() {
        mainUserClipLibraryTest.deleteClip();
    }

    @Test
    public void clipSearch() throws InterruptedException {
        mainUserClipLibraryTest.clipSearch();
    }

    @Test
    public void clipFiltering() {
        mainUserClipLibraryTest.clipFiltering();
    }

    //Edit name of existed clip
    @Test
    public void editCLipName() {
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.media).click();
        $(container.clipLibrary).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();

        $(createNewClipPage.templateTestNameField).clear();
        $(createNewClipPage.templateTestNameField).setValue(GenerateData.generateString(4) + " Edited");
        sleep(1000);

        String createdName = $(createNewClipPage.templateTestNameField).attr("value");

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//td//span[@class=\"ng-binding\"]")).shouldHave(Condition.text(createdName));
    }

    // Subuser should have template that mainuser created available in formula tab when mainuser selected 'available for all users'
    @Test
    public void sU_canUseSharedClip() {
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        pages.Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        $(container.mainUserMenu).click();
        $(container.mainUserMenuLogOut).click();
        LoginPage.login("AnyaMainUser", "os123123");

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        sleep(1000);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.templateClipCategory).selectOption(3);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        container.goToSubUser1();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.formulaTab).click();
        $(clipLibraryPage.searchField).setValue(clipName);

        $$("tbody.ng-scope.ng-pristine.ng-valid > tr > td:nth-child(2) > span")
                .findBy(Condition.text(clipName))
                .shouldBe(Condition.visible);

    }

    @Test
    public void sU_canNotUseNotSharedClip(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        $(container.mainUserMenu).click();
        $(container.mainUserMenuLogOut).click();
        LoginPage.login("AnyaMainUser", "os123123");

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        sleep(1000);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        createNewClipPage.unCheckAvailableForUsers();
        $(createNewClipPage.templateClipCategory).selectOption(3);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(createNewClipPage.shareClipSaveButton).click();

        container.goToSubUser1();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.formulaTab).click();
        $(clipLibraryPage.searchField).setValue(clipName);

        $$("tbody.ng-scope.ng-pristine.ng-valid > tr > td:nth-child(2) > span")
                .findBy(Condition.text(clipName))
                .shouldNotBe(Condition.visible);
    }

    @Test
    public void sU_canNotShareClip(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.settingsClipButton).click();

        $(clipLibraryPage.shareClipButton).shouldNotBe(Condition.visible);
    }

}
