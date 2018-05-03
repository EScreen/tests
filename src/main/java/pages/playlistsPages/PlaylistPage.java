package pages.playlistsPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenideElementIterator;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Anna on 20/04/2018.
 */
public class PlaylistPage {

    public SelenideElement playlistNameField = $(By.xpath("//*[@ng-model=\"data.name\"]"));
    public ElementsCollection plusLogo = $$(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//span[@class=\"ng-binding\"]"));
    public SelenideElement successAlert = $(By.xpath("//div[@flash-alert=\"success\"]"));
    public SelenideElement savePlButton = $(By.xpath("//button[@ng-click=\"savePlaylist()\"]"));
    public SelenideElement orientationSwitch = $(By.xpath("//li[@tooltip-html-unsafe=\"Landscape / Portrait\"]//div[@class=\"ibutton-handle\"]"));

    public SelenideElement clipLibrNewsRoom = $(By.id("newsroom-tab-library"));
        public SelenideElement newsRoomCategory = $(By.xpath("//a[@ng-click=\"getNewsroomTpls(item.ID)\"]"));
    public SelenideElement clipLibrOther = $(By.id("other-tab-library"));
    public SelenideElement clipLibrMyFiles = $(By.id("media-tab-library"));


}
