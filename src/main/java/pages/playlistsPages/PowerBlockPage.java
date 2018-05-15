package pages.playlistsPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.sql.Time;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by qwerty on 5/3/18.
 */
public class PowerBlockPage {

    public SelenideElement powerBlockNameField = $(By.xpath("//*[@ng-model=\"data.name\"]"));
    public SelenideElement powerBlocksNames = $(By.xpath("//span[@class=\"ng-binding ng-scope\"]"));
    public SelenideElement savePowerBlockButton = $(By.xpath("//button[@ng-click=\"savePB()\"]"));
    public SelenideElement successAlert = $(By.xpath("//div[@flash-alert=\"success\"]"));
    public SelenideElement orientationSwitch = $(By.xpath("//li[@tooltip-html-unsafe=\"Landscape / Portrait\"]//div[@class=\"ibutton-handle\"]"));
    public SelenideElement clipLibrOther = $(By.id("other-tab-library"));
    public SelenideElement searchField = $("#DataTables_Table_0_filter > label > input");

    public SelenideElement statusFirstPowerBl = $(By.cssSelector("table.dataTable.responsive.tour-spotlight > tbody > tr:nth-child(1) > td > center > a > span"));
    public SelenideElement notActivePowerBl = $(By.xpath("//*[@id=\"powerblocks-table\"]/tbody/tr/td/center/a"));
    public SelenideElement selectPlayer = $(By.cssSelector("div.modal-body.ng-scope > form > div:nth-child(2) > ul > li > input"));
    public SelenideElement playBackDuration = $(By.xpath("//*[@name=\"duration\"]"));
    public SelenideElement startOnDate = $(By.cssSelector("#start_on > span"));
        public SelenideElement currentDate = $("body > div:nth-child(19) > div > div.datepicker-days td.day.active");
    public SelenideElement startAtTime = $(By.cssSelector("#start_at > span"));
    public SelenideElement selectPlayerGroup = $(By.cssSelector("div.modal-body.ng-scope > form > div:nth-child(7) > ul > li > input"));
    public SelenideElement saveButton = $(By.cssSelector("div.modal-footer.ng-scope > button.btn.btn-green.ng-binding"));




    public void selectPlayer(){
        $(selectPlayer).click();
        $(By.xpath("//div[@class=\"ui-select-dropdown select2-drop select2-with-searchbox select2-drop-active\"]//ul[@role=\"listbox\"]//*[@class=\"ng-binding ng-scope\"]")).click();
    }

    public void setCurrentTime(){
        $(startAtTime).click();
        $(By.xpath("//a[@data-action=\"decrementHours\"]")).click();
    }

    public String getPowerBlockName(SelenideElement element){
        String elementFullName = element.text();
        String[] fullName = elementFullName.split(" ");
        String name = fullName[0];
        String status = fullName[1];

        return name;
    }



}
