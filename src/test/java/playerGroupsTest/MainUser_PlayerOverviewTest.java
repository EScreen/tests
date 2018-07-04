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

public class MainUser_PlayerOverviewTest {

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
        $$(playerOverviewPage.playerLogos).shouldHave(CollectionCondition.size(1));
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
        $$(playerOverviewPage.playerLogos).shouldHave(CollectionCondition.size(3));
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

        $("#\\34 22>div:nth-child(1)>div input").setValue("http://sitename.squarespace.com/pageslug?format=rss");

        String css1 = $("#\\34 22 > div:nth-child(2) .colorpickerWrapper>div").getCssValue("background-color");
        $("#\\34 22 > div:nth-child(2) .colorpickerWrapper").click();
        Selenide.actions().dragAndDropBy($(".colorpicker>.colorpicker_color>div>div"), 10, -50).build().perform();
        String css2 = $("#\\34 22 > div:nth-child(2) .colorpickerWrapper>div").getCssValue("background-color");
        Assert.assertNotEquals(css1, css2);

        $("#\\34 22>div:nth-child(4)>div input").setValue("2");
        $("#\\34 22>div:nth-child(5)>div input").setValue("3");
        $("#\\34 22>div:nth-child(6)>div input").setValue("4");

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
        $(playerOverviewPage.tickertapeSelector).selectOptionByValue("2");

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
        $(playerOverviewPage.tickertapeSelector).selectOptionByValue("6");

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
        $(playerOverviewPage.tickertapeSelector).selectOptionByValue("12");

        $("a[href=\"#library_imageURL\"]").click();
        $("select[name=\"imageURL_section\"]").selectOptionContainingText("Other");
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
        $(playerOverviewPage.tickertapeSelector).selectOptionByValue("14");

        $("#\\31 0686 > div:nth-child(1) > div > select").selectOptionByValue("4");
        $(playerOverviewPage.saveTickertape).click();
        $(playerOverviewPage.successMessage).should(Condition.appear);


    }
}
