package clipTest;

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
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;

import java.awt.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class SubUser_ClipLibraryTest extends MainUser_ClipLibraryTest {

    @Before
    public void beforeTest() {
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaSubUser1", "os123123");
        Configuration.timeout = 20000;
        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

    @After
    public void afterTest() {
        super.afterTest();
    }

    @Override
    @Test
    public void uploadImgToClip() throws AWTException {
        super.uploadImgToClip();
    }

    @Override
    @Test
    public void uploadImgFromLibrToClip() {
        super.uploadImgFromLibrToClip();
    }

    @Override
    @Test
    public void deleteClip() {
        super.deleteClip();
    }

    @Override
    @Test
    public void clipSearch() throws InterruptedException {
        super.clipSearch();
    }

    @Override
    @Test
    public void clipFiltering() {
        super.clipFiltering();
    }

    //Edit name of existed clip
    @Override
    @Test
    public void editCLipName() {
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
        GenerateData genData = new GenerateData();
        pages.Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        LoginPage loginPage = new LoginPage();

        $(container.mainUserMenu).click();
        $(container.mainUserMenuLogOut).click();
        loginPage.login("AnyaMainUser", "os123123");

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
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
        GenerateData genData = new GenerateData();
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        LoginPage loginPage = new LoginPage();

        $(container.mainUserMenu).click();
        $(container.mainUserMenuLogOut).click();
        loginPage.login("AnyaMainUser", "os123123");

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
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
