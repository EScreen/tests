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

    public SelenideElement searchField = $(By.xpath("//*[@id=\"DataTables_Table_0_filter\"]/label/input"));
    public SelenideElement playerGroupName = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[2]/a"));
    public SelenideElement createPlayerGroupButton = $(By.xpath("//li[@class=\"toolbar-link\"]/a"));
    public SelenideElement expandButton = $(".fa.fa-expand");
    public SelenideElement deletePlayerGroupButton = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[4]/div/a[2]"));
    public SelenideElement yesDeleteButton = $(By.xpath("//div[@class=\"modal-footer\"]/button[2]"));
    public SelenideElement addNewOptionButton = $(".btn.btn-small.btn-blue.ng-binding");
    public SelenideElement playerGroupNameField = $(By.xpath("//*[@id=\"device-tag-name\"]/input"));
    public SelenideElement optionField = $("div[class='padded']>#device-tag-options:nth-last-child(2) input");
    public SelenideElement removeOptionButton = $(By.xpath("//*[@id=\"device-tag-options\"]/div/button"));
    public SelenideElement saveButton = $(By.xpath("//button[@name=\"save\"]"));
    public SelenideElement succesSaveAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/flashnotification/div[2]"));
    public SelenideElement succesDeleteAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/section[2]/div/div[1]/flashnotification/div[2]"));
    public SelenideElement searchPlayerField = $(".search-box>input");
    public SelenideElement multiplyCheckbox = $("div.checkbox-table");


    //circles
    public SelenideElement firstCircle = $("div.fht-fixed-body > div.fht-tbody tbody>tr:first-child>td:nth-child(2) .fa.fa-circle-o");
    public SelenideElement secondCircle = $("div.fht-fixed-body > div.fht-tbody tbody>tr:nth-child(2)>td:nth-child(2) .fa.fa-circle-o");
    public SelenideElement thirdCircle = $("div.fht-fixed-body > div.fht-tbody tbody>tr:nth-child(3)>td:nth-child(3) .fa.fa-circle-o");
    public SelenideElement fifthCircle = $("div.fht-fixed-body > div.fht-tbody tbody>tr:nth-child(4)>td:nth-child(3) .fa.fa-circle-o");



    //Set screen on/off time page

    public SelenideElement setScreenTimeTab = $("a[href='#settings']");
    public SelenideElement screenSettingOption = $(".list-group>li>div>div");
    public ElementsCollection screenSettingOptions = $$(".list-group>li");
    public SelenideElement settingSelector = $("#settings > ul > li:nth-child(1) > div > div.panel-body > div:nth-child(4) > div > select");
    public SelenideElement screenOnInput = $("#picktime-screenon > input");
    public SelenideElement screenOffInput = $("#picktime-screenonpair > input");





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
