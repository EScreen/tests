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
import pages.playlistsPages.ManagePlaylistsPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Anna on 15/05/2018.
 */
public class ApprovalClipTest {

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaMainUser", "os123123");
        Configuration.timeout = 20000;
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void sU_CreateClipForApprove(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveAndAskApprovalBtn).click();
        $(clipLibraryPage.awaitingApprovalTab).click();
        sleep(2000);

        $$(By.xpath("tbody.ng-scope.ng-pristine.ng-valid > tr > td:nth-child(3) > div > span"))
                .findBy(Condition.text(clipName));
    }

    @Test
    public void sU_CanNotUseAwaitedApprovalClip(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        container.goToSubUser2();
        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.awaitingApprovalTab).click();
        String notApprovedClipName = $("tbody.ng-scope.ng-pristine.ng-valid > tr > td:nth-child(3) > div > span").text();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();
        $(managePlaylistsPage.nameOfPlayList).click();
        $$("#dataTables tbody.ng-scope.ng-pristine.ng-valid>tr>td:nth-child(3)>span")
                .findBy(Condition.text(notApprovedClipName))
                .shouldNot(Condition.visible);
    }

    @Test
    public void sU_canNotUseNotApprovedClip(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();
        $(By.xpath("//*[@id=\"simplemodal-data\"]/div[4]/div/span[2]/button[4]")).click();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();
        $(managePlaylistsPage.nameOfPlayList).click();

        $(".fa.fa-plus-circle.icon-2x").click();
        $(".modal-body>label").shouldHave(Condition.exactText("You cannot add this clip to your playlist, because it hasn't been approved yet"));
    }

    @Test
    public void sU_canNotUseDeniedClip(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveAndAskApprovalBtn).click();

        container.goToMainUser();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.needApprovalTab).click();
        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.denyClipButton).click();

        container.goToSubUser2();
        $(container.playlists).click();
        $(container.managePlayLIsts).click();
        $(managePlaylistsPage.nameOfPlayList).click();
        sleep(3000);
        $$("#dataTables tbody.ng-scope.ng-pristine.ng-valid>tr>td:nth-child(3)>span")
                .findBy(Condition.text(clipName))
                .shouldNot(Condition.visible);
    }

    @Test
    public void sU_canAstApprovalAgain(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveAndAskApprovalBtn).click();

        container.goToMainUser();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.needApprovalTab).click();
        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.denyClipButton).click();

        container.goToSubUser2();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.awaitingApprovalTab).click();
        $(clipLibraryPage.settingsClipButton).click();
        $("tbody.ng-scope.ng-pristine.ng-valid > tr > td:nth-child(10) > div > ul > li:nth-child(2) > a").click();
        $("tbody.ng-scope.ng-pristine.ng-valid > tr:nth-child(1) > td:nth-child(9)>span").shouldHave(Condition.exactText("pending"));



    }


}
