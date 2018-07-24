package pages.playersPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by Anna on 06/04/2018.
 */
public class PlayerGroupsPage {

    public SelenideElement
            searchField = $(By.xpath("//*[@id=\"DataTables_Table_0_filter\"]/label/input")),
    playerGroupName = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[2]/a")),
    createPlayerGroupButton = $(By.xpath("//li[@class=\"toolbar-link\"]/a")),
    expandButton = $(".fa.fa-expand"),
    deletePlayerGroupButton = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[4]/div/a[2]")),
    yesDeleteButton = $(By.xpath("//div[@class=\"modal-footer\"]/button[2]")),
    addNewOptionButton = $(".btn.btn-small.btn-blue.ng-binding"),
    playerGroupNameField = $(By.xpath("//*[@id=\"device-tag-name\"]/input")),
    optionField = $("div[class='padded']>#device-tag-options:nth-last-child(2) input"),
    removeOptionButton = $(By.xpath("//*[@id=\"device-tag-options\"]/div/button")),
    saveButton = $(By.xpath("//button[@name=\"save\"]")),
    succesSaveAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/flashnotification/div[2]")),
    succesDeleteAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/section[2]/div/div[1]/flashnotification/div[2]")),
    searchPlayerField = $(".search-box>input"),
    multiplyCheckbox = $("div.checkbox-table"),


    //circles
    firstCircle = $("div.fht-fixed-body > div.fht-tbody tbody>tr:first-child>td:nth-child(2) .fa.fa-circle-o"),
    secondCircle = $("div.fht-fixed-body > div.fht-tbody tbody>tr:nth-child(2)>td:nth-child(2) .fa.fa-circle-o"),
    thirdCircle = $("div.fht-fixed-body > div.fht-tbody tbody>tr:nth-child(3)>td:nth-child(3) .fa.fa-circle-o"),
    fifthCircle = $("div.fht-fixed-body > div.fht-tbody tbody>tr:nth-child(4)>td:nth-child(3) .fa.fa-circle-o"),



    //Set screen on/off time page

    setScreenTimeTab = $("a[href='#settings']"),
    screenSettingOption = $(".list-group>li>div>div"),
    settingSelector = $("#settings > ul > li:nth-child(1) > div > div.panel-body > div:nth-child(4) > div > select"),
    screenOnInput = $("#picktime-screenon > input"),
    screenOffInput = $("#picktime-screenonpair > input");

    public ElementsCollection screenSettingOptions = $$(".list-group>li");





    public void setCircles(){
        sleep(5000);
        $(firstCircle).click();
        $(secondCircle).click();
        $(thirdCircle).click();
        $(fifthCircle).click();
    }

    public String getGroupName(SelenideElement element){
        String elementFullName = element.text();
        String[] fullName = elementFullName.split(" ");
        String name = fullName[0];
        //String status = fullName[1];

        return name;
    }





}
