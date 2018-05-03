package pages.playlistsPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by qwerty on 5/3/18.
 */
public class PowerBlockPage {

    public SelenideElement powerBlockNameField = $(By.xpath("//*[@ng-model=\"data.name\"]"));
    public SelenideElement savePowerBlockButton = $(By.xpath("//button[@ng-click=\"savePB()\"]"));
    public SelenideElement successAlert = $(By.xpath("//div[@flash-alert=\"success\"]"));
    public SelenideElement orientationSwitch = $(By.xpath("//li[@tooltip-html-unsafe=\"Landscape / Portrait\"]//div[@class=\"ibutton-handle\"]"));
    public SelenideElement clipLibrOther = $(By.id("other-tab-library"));

}
