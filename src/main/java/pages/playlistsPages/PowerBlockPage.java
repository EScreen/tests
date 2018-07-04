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

    public SelenideElement powerBlockNameField = $(By.xpath("//*[@ng-model=\"data.name\"]"));
    public SelenideElement powerBlockName = $(By.xpath("//span[@class=\"ng-binding ng-scope\"]"));
    public SelenideElement savePowerBlockButton = $(By.xpath("//button[@ng-click=\"savePB()\"]"));
    public SelenideElement saveEditingPowerBl = $("button[ng-click='editPB()']");
    public SelenideElement successAlert = $(By.xpath("//div[@flash-alert=\"success\"]"));
    public SelenideElement orientationSwitch = $(By.xpath("//li[@tooltip-html-unsafe=\"Landscape / Portrait\"]//div[@class=\"ibutton-handle\"]"));
    public SelenideElement searchField = $("#DataTables_Table_0_filter > label > input");
    public SelenideElement clipSettingsButton = $(".box-content .btn-group");
    public SelenideElement deleteClipButton = $(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table//*[@class=\"dropdown-menu\"]//a[@ng-click=\"removeFromDrop(fragment)\"]"));
    public SelenideElement setVolumeButton = $("a[ng-click='soundLevelModal(fragment)']");
    public SelenideElement saveVolumeButton = $("button[ng-click='ok()']");
    public SelenideElement deletePowerBl = $("#powerblocks-table>tbody>tr>td:nth-child(7)>div>a:nth-child(2)>i");
    public SelenideElement yesDelete = $("div.modal-footer > button:nth-child(2)");

    public SelenideElement statusFirstPowerBl = $(By.cssSelector("table.dataTable.responsive.tour-spotlight > tbody > tr:nth-child(1) > td > center > a > span"));
    public SelenideElement notActivePowerBl = $(By.xpath("//*[@id=\"powerblocks-table\"]//span[@tooltip-html-unsafe=\"Not playing\"]"));
    public SelenideElement selectPlayer = $(By.cssSelector("div.modal-body.ng-scope > form > div:nth-child(2) > ul > li > input"));
    public SelenideElement playBackDuration = $(By.xpath("//*[@name=\"duration\"]"));
    public SelenideElement startOnDate = $(By.cssSelector("#start_on > span"));
        public SelenideElement currentDate = $("body > div:nth-child(19) > div > div.datepicker-days td.day.active");
    public SelenideElement startAtTime = $(By.cssSelector("#start_at > span"));
    public SelenideElement selectPlayerGroup = $(By.cssSelector("div.modal-body.ng-scope > form > div:nth-child(7) > ul > li > input"));
    public SelenideElement saveButton = $(By.cssSelector("div.modal-footer.ng-scope > button.btn.btn-green.ng-binding"));

    public SelenideElement clipLibrNewsRoom = $(By.id("newsroom-tab-library"));
    public SelenideElement newsRoomCategory = $(By.xpath("//a[@ng-click=\"getNewsroomTpls(item.ID)\"]"));
    public SelenideElement clipLibrFormula = $(By.id("formula-tab-library"));
    public SelenideElement clipLibrOther = $(By.id("other-tab-library"));
    public SelenideElement clipLibrMyFiles = $(By.id("media-tab-library"));




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
        //String status = fullName[1];

        return name;
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
