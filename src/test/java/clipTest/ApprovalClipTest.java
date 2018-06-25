package clipTest;

import com.codeborne.selenide.*;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Container;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;
import pages.playlistsPages.ManagePlaylistsPage;
import pages.playlistsPages.PlaylistPage;
import pages.profilePages.UsersPage;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Anna on 15/05/2018.
 */
public class ApprovalClipTest {

    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void sU_createClipForApprove(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
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
    public void sU_createClipWithOutApprove(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        container.goToSubUser1();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[1]/td[2]/span")).shouldBe(Condition.text(clipName));
    }

    @Test
    public void sU_canNotUseAwaitedApprovalClip(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        container.goToSubUser2();
        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveAndAskApprovalBtn).click();

        $(container.playlists).click();
        $(container.managePlayLIsts).click();
        $(managePlaylistsPage.nameOfPlayList).click();
        $$("#dataTables tbody.ng-scope.ng-pristine.ng-valid>tr>td:nth-child(3)>span")
                .findBy(Condition.text(clipName))
                .shouldNotBe(Condition.visible);
    }

    @Test
    public void sU_canNotUseNotApprovedClip(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
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
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
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
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
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
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
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
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveAndAskApprovalBtn).click();

        container.goToMainUser();

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
    public void mU_canApproveClipViaEditing(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.needApprovalTab).click();

        $(clipLibraryPage.settingsClipButton).click();
        $("tbody.ng-scope.ng-pristine.ng-valid>tr:nth-child(1)>td:nth-child(9)>div>ul>li.ng-scope>a:nth-child(1)").click();

        String newNameClip = GenerateData.generateString(3);
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

        container.goToSubUser1();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();

        $("div.wizard-modal-footer > div > span:nth-child(4) > button:nth-child(5)").shouldNotBe(Condition.visible);

    }

//If subuser has clip approve off "Awaiting Approval" tab shouldn't display.
    @Test
    public void awaitingApprovalTabShouldNotDisplay(){
        Container container = new Container();
        container.goToSubUser1();

        $(container.media).click();
        $(container.clipLibrary).click();

        $(By.xpath("//*[@id=\"approve-tab-library\"]/a")).shouldNotBe(Condition.visible);
    }

//If subuser has clip approve off, During creating new clip "Add to new playlist" and "Add to existing playlist" fields display
    @Test
    public void sU_WithAppOff_canAddClipToPL(){
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

//If subuser has clip approve on, During creating new clip "Add to new playlist" and "Add to existing playlist" fields display
    @Test
    public void sU_WithAppOn_canAddClipToPL(){
        Container container = new Container();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        $(By.xpath("//*[@name=\"new_playlist\"]")).shouldNotBe(Condition.visible);
        $(By.xpath("//li[@class=\"select2-search-field\"]/input")).shouldNotBe(Condition.visible);

    }


    @Test
    public void mU_canShareApprovedClip(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.needApprovalTab).click();

        $(clipLibraryPage.settingsClipButton).click();
        $("tbody.ng-scope.ng-pristine.ng-valid>tr:nth-child(1)>td:nth-child(9)>div>ul>li.ng-scope>a:nth-child(1)").click();

        sleep(2000);

        String newNameClip = GenerateData.generateString(3);
        $(createNewClipPage.templateTestNameField).clear();
        $(createNewClipPage.templateTestNameField).setValue(newNameClip);
        sleep(2000);

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

//- If Mainuser turns clip approval off for subuser, awaiting for approval clips become avaliable for subuser.
// These clips disappears from "Awaiting approval" list. Subuser has possibility to use this clip.
    @Test
    public void sU_CanUseNotApprovedClipAfterClipAppTurnOff(){
        Container container = new Container();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        UsersPage usersPage = new UsersPage();
        PlaylistPage playlistPage = new PlaylistPage();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue(createNewClipPage.testTemplateName);
        $(createNewClipPage.newClipButton).click();

        String clipName = GenerateData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("1");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveAndAskApprovalBtn).click();

        container.goToMainUser();

        $(container.mainUserMenu).click();
        $(container.mainUserMenuUsers).click();
        $(usersPage.subUser2).click();

        sleep(3000);

        SelenideElement element = $("div.padded>div:nth-child(22)>div>div>input");
        Selenide.executeJavaScript("arguments[0].click();", element);

        sleep(3000);

        $("button[type='submit']").click();

        container.goToSubUser2();

        $(mainDashboardPage.createPlaylistButton).click();
        $(playlistPage.searchField).setValue(clipName);

        $(By.xpath("//i[@class=\"fa fa-plus-circle icon-2x\"]")).click();

        $$("#playlist-block .box-content>table>tbody>tr>td:nth-child(3)>span")
                .findBy(Condition.text(clipName))
                .shouldBe(Condition.visible);

        container.goToMainUser();

        $(container.mainUserMenu).click();
        $(container.mainUserMenuUsers).click();
        $(usersPage.subUser2).click();


        SelenideElement element2 = $("div.padded>div:nth-child(22)>div>div>input");
        Selenide.executeJavaScript("arguments[0].click();", element2);

        sleep(5000);

        $("button[type='submit']").click();
        $("#appcontent > div.main-content > flashnotification > div:nth-child(2)").shouldBe(Condition.appear);


    }


}
