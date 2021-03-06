package playerGroupsTest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import helpers.GenerateData;
import helpers.Precondition;
import helpers.UploadingFiles;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import pages.Container;
import pages.playersPages.PlayerOverviewPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class PlayerOverviewTest_MainUser {

    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void filterByOfflineStatus(){
        Container container = new Container();
        PlayerOverviewPage playerOverviewPage = new PlayerOverviewPage();

        $(container.players).click();
        $(container.playerOverview).click();
        $(playerOverviewPage.statusSelector).selectOptionByValue("offline");

        sleep(1000);
        //$$(playerOverviewPage.playerLogos).shouldHave(CollectionCondition.size(3));
        $(playerOverviewPage.playerLogo).shouldHave(Condition.attribute("tooltip-html-unsafe", "Offline"));
    }

    @Test
    public void filterByOnlineStatus(){
        Container container = new Container();
        PlayerOverviewPage playerOverviewPage = new PlayerOverviewPage();

        $(container.players).click();
        $(container.playerOverview).click();
        $(playerOverviewPage.statusSelector).selectOptionByValue("online");

        sleep(1000);
        //$$(playerOverviewPage.playerLogos).shouldHave(CollectionCondition.size(1));
        $(playerOverviewPage.playerLogo).shouldHave(Condition.attribute("tooltip-html-unsafe", "Online"));
    }

    @Test
    public void playerSearching(){
        Container container = new Container();
        PlayerOverviewPage playerOverviewPage = new PlayerOverviewPage();

        $(container.players).click();
        $(container.playerOverview).click();
        $(playerOverviewPage.searchInput).setValue("Device #2");

        $("tbody>tr>td:nth-child(3)>a").shouldHave(Condition.exactText("Device #2"));
    }

    @Test
    public void setClassicTickertape(){
        Container container = new Container();
        PlayerOverviewPage playerOverviewPage = new PlayerOverviewPage();

        $(container.players).click();
        $(container.playerOverview).click();
        $(playerOverviewPage.tickertapeButton).click();
        $(playerOverviewPage.tickertapeSelector).selectOptionByValue("1");

        $("#\\31 0943 > div:nth-child(1) > div > div > input").setValue("http://sitename.squarespace.com/pageslug?format=rss");

        String css1 = $("#\\31 0943 > div:nth-child(2) .colorpickerWrapper>div").getCssValue("background-color");
        $("#\\31 0943 > div:nth-child(2) .colorpickerWrapper").click();
        Selenide.actions().dragAndDropBy($(".colorpicker > div.colorpicker_color > div > div"), GenerateData.generateNumbers(1), -5).build().perform();
        sleep(2000);
        String css2 = $("#\\31 0943 > div:nth-child(2) .colorpickerWrapper>div").getCssValue("background-color");
        Assert.assertNotEquals(css1, css2);

        $("#\\31 0943>div:nth-child(4)>div input").setValue("2");

        $(playerOverviewPage.saveTickertape).click();
        $(playerOverviewPage.successMessage).should(Condition.appear);
    }

    @Test
    public void setPortraitTickertape(){
        Container container = new Container();
        PlayerOverviewPage playerOverviewPage = new PlayerOverviewPage();

        $(container.players).click();
        $(container.playerOverview).click();
        $(playerOverviewPage.tickertapeButton).click();
        $(playerOverviewPage.tickertapeSelector).selectOptionContainingText("RSS tickertape - portrait");

        $("#\\31 0013>div:nth-child(1)>div input").setValue("http://sitename.squarespace.com/pageslug?format=rss");

        $("#\\31 0013>div:nth-child(4)>div input").setValue("2");
        $("#\\31 0013>div:nth-child(5)>div input").setValue("3");
        $("#\\31 0013>div:nth-child(6)>div input").setValue("4");

        $(playerOverviewPage.saveTickertape).click();
        $(playerOverviewPage.successMessage).should(Condition.appear);
    }

    @Test
    public void uploadPhotoInTickertape() throws IOException {
        Container container = new Container();
        PlayerOverviewPage playerOverviewPage = new PlayerOverviewPage();

        $(container.players).click();
        $(container.playerOverview).click();
        $(playerOverviewPage.tickertapeButton).click();
        $(playerOverviewPage.tickertapeSelector).selectOptionContainingText("Classic tickertape + image");

        $(".upload_col label").click();
        UploadingFiles.uploadFile("/Users/qa-tester/IdeaProjects/tests/src/main/resources/Scrpt_upload_Smile2.scpt");

        int size = $("div.canvas-container>img").getSize().height;
        Assert.assertEquals(size, 489);


        $(playerOverviewPage.saveTickertape).click();
        $(playerOverviewPage.successMessage).should(Condition.appear);
    }

    @Test
    public void uploadPhotoFromLibr() {
        Container container = new Container();
        PlayerOverviewPage playerOverviewPage = new PlayerOverviewPage();

        $(container.players).click();
        $(container.playerOverview).click();
        $(playerOverviewPage.tickertapeButton).click();
        $(playerOverviewPage.tickertapeSelector).selectOptionContainingText("Harley Davidson Screen region with video to the left");

        $("a[href=\"#library_logo\"]").click();
        $("select[name=\"logo_section\"]").selectOptionContainingText("Other");
        sleep(1000);
        $$("tbody img").get(3).click();
        $("button[ng-click='ok()']").click();

        int size = $("div.canvas-container>img").getSize().height;
        Assert.assertEquals(size, 1080);

        $(playerOverviewPage.saveTickertape).click();
        $(playerOverviewPage.successMessage).should(Condition.appear);
    }

    @Test
    public void setHappInTickertape(){
        Container container = new Container();
        PlayerOverviewPage playerOverviewPage = new PlayerOverviewPage();

        $(container.players).click();
        $(container.playerOverview).click();
        $(playerOverviewPage.tickertapeButton).click();
        $(playerOverviewPage.tickertapeSelector).selectOptionContainingText("Wachtruimte TV Quickedit custom color - video to the right");

        $("#\\31 1205 > div:nth-child(9) > div > select").selectOptionByValue("1");
        $(playerOverviewPage.saveTickertape).click();
        $(playerOverviewPage.successMessage).should(Condition.appear);


    }
}
