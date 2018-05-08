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

    public SelenideElement statusFirstPowerBl = $(By.cssSelector("table.dataTable.responsive.tour-spotlight > tbody > tr:nth-child(1) > td > center > a > span"));
    public SelenideElement selectPlayer = $(By.cssSelector("div.modal-body.ng-scope > form > div:nth-child(2) > ul > li > input"));
    public SelenideElement playBackDuration = $(By.xpath("//*[@name=\"duration\"]"));
    public SelenideElement startOnDate = $(By.cssSelector("#start_on > input"));
    public SelenideElement startAtTime = $(By.cssSelector("#start_at > input"));
    public SelenideElement selectPlayerGroup = $(By.cssSelector("div.modal-body.ng-scope > form > div:nth-child(7) > ul > li > input"));
    public SelenideElement saveButton = $(By.cssSelector("div.modal-footer.ng-scope > button.btn.btn-green.ng-binding"));



}
