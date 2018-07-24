package pages.playlistsPages;

import com.codeborne.selenide.SelenideElement;
import org.jbehave.core.reporters.TemplateableViewGenerator;
import org.openqa.selenium.By;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by qwerty on 5/3/18.
 */
public class PowerBlockPage {

    public SelenideElement
            powerBlockNameField = $(By.xpath("//*[@ng-model=\"data.name\"]")),
    powerBlockName = $(By.xpath("//span[@class=\"ng-binding ng-scope\"]")),
    savePowerBlockButton = $(By.xpath("//button[@ng-click=\"savePB()\"]")),
    saveEditingPowerBl = $("button[ng-click='editPB()']"),
    successAlert = $(By.xpath("//div[@flash-alert=\"success\"]")),
    orientationSwitch = $(By.xpath("//li[@tooltip-html-unsafe=\"Landscape / Portrait\"]//div[@class=\"ibutton-handle\"]")),
    searchField = $("#DataTables_Table_0_filter > label > input"),
    clipSettingsButton = $(".box-content .btn-group"),
    deleteClipButton = $(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//*[@class=\"dropdown-menu\"]//a[@ng-click=\"removeFromDrop(fragment)\"]")),
    setVolumeButton = $("a[ng-click='soundLevelModal(fragment)']"),
    saveVolumeButton = $("button[ng-click='ok()']"),
    deletePowerBl = $("#powerblocks-table>tbody>tr>td:nth-child(7)>div>a:nth-child(2)>i"),
    yesDelete = $("div.modal-footer > button:nth-child(2)"),

    statusFirstPowerBl = $(By.cssSelector("table.dataTable.responsive.tour-spotlight > tbody > tr:nth-child(1) > td > center > a > span")),
    notActivePowerBl = $(By.xpath("//*[@id=\"powerblocks-table\"]//span[@tooltip-html-unsafe=\"Not playing\"]")),
    selectPlayer = $(By.cssSelector("div.modal-body.ng-scope > form > div:nth-child(2) > ul > li > input")),
    playBackDuration = $(By.xpath("//*[@name=\"duration\"]")),
    startOnDate = $(By.cssSelector("#start_on > span")),
        currentDate = $("body > div:nth-child(19) > div > div.datepicker-days td.day.active"),
    startAtTime = $(By.cssSelector("#start_at > span")),
    selectPlayerGroup = $(By.cssSelector("div.modal-body.ng-scope > form > div:nth-child(7) > ul > li > input")),
    saveButton = $(By.cssSelector("div.modal-footer.ng-scope > button.btn.btn-green.ng-binding")),

    clipLibrNewsRoom = $(By.id("newsroom-tab-library")),
    newsRoomCategory = $(By.xpath("//a[@ng-click=\"getNewsroomTpls(item.ID)\"]")),
    clipLibrFormula = $(By.id("formula-tab-library")),
    clipLibrOther = $(By.id("other-tab-library")),
    clipLibrMyFiles = $(By.id("media-tab-library"));




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

        return fullName[0];
    }

    public void setDateAndTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        $("#start_on > input").sendKeys(date1);

        $("#start_at > span").click();
        $(By.xpath("//a[@data-action=\"decrementHours\"]")).click();
    }





}
