package pages.playlistsPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.SelenideElementIterator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by Anna on 20/04/2018.
 */
public class PlaylistPage {

    public SelenideElement playlistNameField = $(By.xpath("//*[@ng-model=\"data.name\"]"));
    public SelenideElement searchField = $(By.xpath("//input[@placeholder=\"Search\"]"));
    public SelenideElement successAlert = $(By.xpath("//div[@flash-alert=\"success\"]"));
    public SelenideElement savePlButton = $(By.xpath("//button[@ng-click=\"savePlaylist()\"]"));
    public SelenideElement saveEditingPlButton = $(By.xpath("//button[@ng-click=\"editPlaylist()\"]"));
    public SelenideElement orientationSwitch = $(By.xpath("//li[@tooltip-html-unsafe=\"Landscape / Portrait\"]//div[@class=\"ibutton-handle\"]"));
    public SelenideElement clipSettingsButton = $(".box-content .btn-group");
        public SelenideElement setScheduleButton = $("a[ng-click='toggleScheduleModal(fragment)']");
        public SelenideElement setVolumeButton = $("a[ng-click='soundLevelModal(fragment)']");
        public SelenideElement saveVolumeButton = $("button[ng-click='ok()']");
        public SelenideElement deleteClipButton = $(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//*[@class=\"dropdown-menu\"]//a[@ng-click=\"removeFromDrop(fragment)\"]"));

    public SelenideElement clipLibrNewsRoom = $(By.id("newsroom-tab-library"));
        public SelenideElement newsRoomCategory = $(By.xpath("//a[@ng-click=\"getNewsroomTpls(item.ID)\"]"));
    public SelenideElement clipLibrFormula = $(By.id("formula-tab-library"));
    public SelenideElement clipLibrOther = $(By.id("other-tab-library"));
    public SelenideElement clipLibrMyFiles = $(By.id("media-tab-library"));
    
    public SelenideElement colorPoint = $("body>div[style~='left:']>div:nth-child(1)>div>div");
    


    public void setVolume(int percentage){
        SelenideElement elem = $(".slider-handle.min-slider-handle.round");
        int x = 0;
        
        switch (percentage){
            case 10:
                x = 53;
                break;

            case 20:
                x=106;
                break;

            case 30:
                x=159;
                break;

            case 40:
                x=212;
                break;

            case 50:
                x=265;
                break;

            case 60:
                x=318;
                break;

            case 70:
                x=371;
                break;

            case 80:
                x=424;
                break;

            case 90:
                x=477;
                break;

            case 100:
                x=530;
                break;
        }
        sleep(2000);
        Selenide.actions().dragAndDropBy(elem, x,0).build().perform();
    }

}
