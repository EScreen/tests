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
import pages.playlistsPages.PlaylistPage;

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
    public void sU_CreateClipWithOutApprove(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        container.goToSubUser1();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[1]/td[2]/span")).shouldBe(Condition.text(clipName));
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
    public void sU_canAskApprovalAgain(){
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

    @Test
    public void sU_messageAppearsAfterEditApprovedClip(){
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

        container.goToMainUser();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.needApprovalTab).click();
        $(clipLibraryPage.searchField).setValue(clipName);
        sleep(3000);
        $(clipLibraryPage.approveFirstClipCheck).click();

        container.goToSubUser2();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.searchField).setValue(clipName);
        sleep(1000);
        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();

        $("div.modal-body > label")
                .shouldHave(Condition.exactText(("A change must be approved again and the clip will be removed from your playlist. Continue?")));



    }

    @Test
    public void sU_canUseApprovedClip(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();
        PlaylistPage playlistPage = new PlaylistPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.needApprovalTab).click();
        String notApprovedClipName = $("tbody.ng-scope.ng-pristine.ng-valid > tr > td:nth-child(3) > div > span").text();
        $(clipLibraryPage.approveFirstClipCheck).click();

        container.goToSubUser2();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();
        $(managePlaylistsPage.nameOfPlayList).click();
        $(playlistPage.searchField).setValue(notApprovedClipName);
        sleep(2000);

        $(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).click();

        $$("#playlist-block .box-content>table>tbody>tr>td:nth-child(3)>span")
                .findBy(Condition.text(notApprovedClipName))
                .shouldBe(Condition.visible);
    }

// MainUser approves clip after editing it
    @Test
    public void mU_approveClipViaEditing(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        GenerateData genData = new GenerateData();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.needApprovalTab).click();

        $(clipLibraryPage.settingsClipButton).click();
        $("tbody.ng-scope.ng-pristine.ng-valid>tr:nth-child(1)>td:nth-child(9)>div>ul>li.ng-scope>a:nth-child(1)").click();

        String newNameClip = genData.generateString(3);
        $(createNewClipPage.templateTestNameField).clear();
        $(createNewClipPage.templateTestNameField).setValue(newNameClip);
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(createNewClipPage.shareClipSaveButton).click();

        $$("tbody.ng-scope.ng-pristine.ng-valid>tr>td:nth-child(3)>div>span")
                .findBy(Condition.text(newNameClip)).
                shouldNotBe(Condition.visible);
    }

//If subuser has clip approve off "Save and ask approval" button shouldn't display.
    @Test
    public void askApprovalShouldNotDisplay(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();

        container.goToSubUser1();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();

        $("div.wizard-modal-footer > div > span:nth-child(4) > button:nth-child(5)").shouldNotBe(Condition.visible);

    }
//If subuser has clip approve off "Awaiting Approval" tab shouldn't display.
    @Test
    public void awaitingApprovalTabSHouldNotDisplay(){
        Container container = new Container();
        container.goToSubUser1();

        $(container.media).click();
        $(container.clipLibrary).click();

        $(By.xpath("//*[@id=\"approve-tab-library\"]/a")).shouldNotBe(Condition.visible);
    }
//If subuser has clip approve off, During creating new clip "Add to new playlist" and "Add to existing playlist" fields display
    @Test
    public void sU_canAddClipToPL(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        container.goToSubUser1();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        $(By.xpath("//*[@name=\"new_playlist\"]")).shouldBe(Condition.visible);
        $(By.xpath("//li[@class=\"select2-search-field\"]/input")).shouldBe(Condition.visible);

    }

    @Test
    public void mU_canShareApprovedClip(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        GenerateData genData = new GenerateData();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.needApprovalTab).click();

        $(clipLibraryPage.settingsClipButton).click();
        $("tbody.ng-scope.ng-pristine.ng-valid>tr:nth-child(1)>td:nth-child(9)>div>ul>li.ng-scope>a:nth-child(1)").click();

        String newNameClip = genData.generateString(3);
        $(createNewClipPage.templateTestNameField).clear();
        $(createNewClipPage.templateTestNameField).setValue(newNameClip);
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(createNewClipPage.shareClipWithSubUser1).click();
        $(createNewClipPage.shareClipSaveButton).click();

        container.goToSubUser1();
        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.formulaTab).click();
        $(clipLibraryPage.searchField).setValue(newNameClip);

        $$("tbody.ng-scope.ng-pristine.ng-valid > tr > td:nth-child(2) > span")
                .findBy(Condition.text(newNameClip))
                .shouldBe(Condition.visible);


    }



}
