package playerGroupsTest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Container;
import pages.playersPages.PlayerGroupsPage;

import static com.codeborne.selenide.Selenide.*;

public class MainUser_PlayerGroupsTest {
    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createPlGroup(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();
        $(playerGroupsPage.createPlayerGroupButton).click();

        String groupName = GenerateData.generateString(4);
        $(playerGroupsPage.playerGroupNameField).setValue(groupName);

        $(playerGroupsPage.optionField).setValue("Landscape");
        $(playerGroupsPage.addNewOptionButton).click();
        $(playerGroupsPage.optionField).setValue("Portrait");
        $(playerGroupsPage.saveButton).click();
        $(playerGroupsPage.succesSaveAlert).should(Condition.appear);

        playerGroupsPage.setCircles();
        $(playerGroupsPage.saveButton).click();
        $(playerGroupsPage.succesSaveAlert).should(Condition.appear);
        sleep(3000);

        $(playerGroupsPage.searchField).setValue(groupName);
        sleep(1000);
        String expectedText = groupName + " - 4 players";
        $(playerGroupsPage.playerGroupName).shouldHave(Condition.exactText(expectedText));
    }

    @Test
    public void editOptionName(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();

        $(playerGroupsPage.playerGroupName).click();
        sleep(3000);
        String newName = GenerateData.generateString(3);
        $(playerGroupsPage.playerGroupNameField).setValue(newName);

        $(playerGroupsPage.saveButton).click();
        sleep(4000);

        $(playerGroupsPage.searchField).setValue(newName);
        sleep(1000);
        $(playerGroupsPage.playerGroupName).shouldHave(Condition.text(newName));
    }

    @Test
    public void editAndAddOption(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();

        String playerName = playerGroupsPage.getGroupName($(playerGroupsPage.playerGroupName));
        $(playerGroupsPage.playerGroupName).click();

        $(playerGroupsPage.addNewOptionButton).click();
        String newOption = GenerateData.generateString(3);
        $(playerGroupsPage.optionField).setValue(newOption);
        $(playerGroupsPage.saveButton).click();
        sleep(3000);
        $(playerGroupsPage.saveButton).click();
        sleep(4000);

        $(playerGroupsPage.searchField).setValue(playerName);
        $(playerGroupsPage.playerGroupName).click();

        $(playerGroupsPage.expandButton).click();
        String options = $$("div.fht-fixed-body > div.fht-thead > table > thead > tr>th>div:first-child").texts().toString();
        Assert.assertTrue(options.contains(newOption));
    }

    @Test
    public void editRemoveOption(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();
        ElementsCollection optionFields =$$("div[class='padded']>#device-tag-options");
        ElementsCollection optionColumns = $$("div.fht-fixed-body > div.fht-thead > table > thead > tr>th>div:first-child");

        $(container.players).click();
        $(container.playerGroups).click();

        $(playerGroupsPage.playerGroupName).click();
        sleep(3000);

        int options1 = optionFields.size();
        int options2 = optionColumns.size();

        $(playerGroupsPage.removeOptionButton).click();
        optionFields.shouldHave(CollectionCondition.size(options1 - 1));

        $(playerGroupsPage.saveButton).click();
        sleep(3000);

        optionColumns.shouldHave(CollectionCondition.size(options2 - 1));
    }

    @Test
    public void searchPlayer(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();
        $(playerGroupsPage.playerGroupName).click();
        sleep(3000);

        $(playerGroupsPage.searchPlayerField).setValue("Device #4");
        sleep(2000);

        $("div.fht-fixed-body > div.fht-tbody > table > tbody > tr > td.ng-binding").shouldHave(Condition.exactText("Device #4"));
    }

    @Test
    public void setOptionsMultiply(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();
        $(playerGroupsPage.playerGroupName).click();
        $(playerGroupsPage.multiplyCheckbox).click();

        $("div.devicesOverlay.ng-scope").should(Condition.appear);
    }

    @Test
    public void searchGroup(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();

        String searchedPlayer = playerGroupsPage.getGroupName($("#dataTables>table>tbody>tr:nth-child(4)>td:nth-child(2)>a"));

        $(playerGroupsPage.searchField).setValue(searchedPlayer);
        sleep(2000);
        $(playerGroupsPage.playerGroupName).shouldHave(Condition.text(searchedPlayer));
    }

    @Test
    public void deleteGroup(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();

        String deletedGroup = playerGroupsPage.getGroupName(playerGroupsPage.playerGroupName);
        $(playerGroupsPage.deletePlayerGroupButton).click();
        $(playerGroupsPage.yesDeleteButton).click();

        $(playerGroupsPage.succesDeleteAlert).should(Condition.appear);
        sleep(2000);

        $(playerGroupsPage.searchField).setValue(deletedGroup);
        sleep(1000);
        $(playerGroupsPage.playerGroupName).shouldNotBe(Condition.visible);
    }

    @Test
    public void checkOptionsQuantityForSetting(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();
        $(playerGroupsPage.createPlayerGroupButton).click();

        String groupName = GenerateData.generateString(4);
        $(playerGroupsPage.playerGroupNameField).setValue(groupName);

        $(playerGroupsPage.optionField).setValue("Landscape");
        $(playerGroupsPage.addNewOptionButton).click();
        $(playerGroupsPage.optionField).setValue("Portrait");
        $(playerGroupsPage.saveButton).click();
        $(playerGroupsPage.succesSaveAlert).should(Condition.appear);

        $(playerGroupsPage.setScreenTimeTab).click();
        $$(playerGroupsPage.screenSettingOptions).shouldHave(CollectionCondition.size(2));
    }

    @Test
    public void setGeneralSettings(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();
        $(playerGroupsPage.playerGroupName).click();

        $(playerGroupsPage.setScreenTimeTab).click();
        $(playerGroupsPage.screenSettingOption).click();
        $(playerGroupsPage.settingSelector).selectOptionContainingText("General Schedule");

        $(playerGroupsPage.screenOnInput).sendKeys("1200");
        $(playerGroupsPage.screenOffInput).sendKeys("1800");
        $(playerGroupsPage.saveButton).click();
        $(playerGroupsPage.succesSaveAlert).should(Condition.appear);
        sleep(3000);

        $(playerGroupsPage.playerGroupName).click();
        $(playerGroupsPage.setScreenTimeTab).click();
        $(playerGroupsPage.screenSettingOption).click();

        $(By.id("picktime-screenon")).shouldHave(Condition.value("12:00:00"));
        $(By.id("picktime-screenonpair")).shouldHave(Condition.value("18:00:00"));
    }

    @Test
    public void setWeekDaySettings(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();
        $(playerGroupsPage.playerGroupName).click();

        $(playerGroupsPage.setScreenTimeTab).click();
        $(playerGroupsPage.screenSettingOption).click();
        $(playerGroupsPage.settingSelector).selectOptionContainingText("Weekday Schedule");

        $("select[name='screentimes[all_day_period_0]']").selectOptionContainingText("All Day On");
        $("select[name='screentimes[all_day_period_1]']").selectOptionContainingText("All Day Off");
        $("div[ng-repeat=\"day in groupTimings.schedule\"]:nth-child(3)>div>div>input").sendKeys("0730");
        $("div[ng-repeat=\"day in groupTimings.schedule\"]:nth-child(3)>div>div:nth-child(3)>input").sendKeys("1540");
        $("div[ng-repeat=\"day in groupTimings.schedule\"]:nth-child(7)>div>div>input").sendKeys("0900");
        $("div[ng-repeat=\"day in groupTimings.schedule\"]:nth-child(7)>div>div:nth-child(3)>input").sendKeys("1400");

        $(playerGroupsPage.saveButton).click();
        $(playerGroupsPage.succesSaveAlert).should(Condition.appear);
        sleep(3000);

        $(playerGroupsPage.playerGroupName).click();
        $(playerGroupsPage.setScreenTimeTab).click();
        $(playerGroupsPage.screenSettingOption).click();

        $("select[name='screentimes[all_day_period_0]']>option[selected]").shouldHave(Condition.exactText("All Day On"));
        $("select[name='screentimes[all_day_period_1]']>option[selected]").shouldHave(Condition.exactText("All Day Off"));
        $("div[ng-repeat=\"day in groupTimings.schedule\"]:nth-child(3)>div>div").shouldHave(Condition.value("07:30"));
        $("div[ng-repeat=\"day in groupTimings.schedule\"]:nth-child(3)>div>div:nth-child(3)").shouldHave(Condition.value("15:40"));
        $("div[ng-repeat=\"day in groupTimings.schedule\"]:nth-child(7)>div>div").shouldHave(Condition.value("09:00"));
        $("div[ng-repeat=\"day in groupTimings.schedule\"]:nth-child(7)>div>div:nth-child(3)").shouldHave(Condition.value("14:00"));

    }

    @Test
    public void setAlwaysOnSettings(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();
        $(playerGroupsPage.playerGroupName).click();

        $(playerGroupsPage.setScreenTimeTab).click();
        $(playerGroupsPage.screenSettingOption).click();
        $(playerGroupsPage.settingSelector).selectOptionContainingText("Always on");

        $(playerGroupsPage.saveButton).click();
        $(playerGroupsPage.succesSaveAlert).should(Condition.appear);
        sleep(3000);

        $(playerGroupsPage.playerGroupName).click();
        $(playerGroupsPage.setScreenTimeTab).click();
        $(playerGroupsPage.screenSettingOption).click();
        $("#settings > ul > li:nth-child(1) > div > div.panel-body > div:nth-child(4) > div > select>option[selected]").shouldHave(Condition.exactText("Always on"));
    }

    @Test
    public void setDifferentSettings(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();
        $(playerGroupsPage.createPlayerGroupButton).click();

        String groupName = GenerateData.generateString(4);
        $(playerGroupsPage.playerGroupNameField).setValue(groupName);

        $(playerGroupsPage.optionField).setValue("Landscape");
        $(playerGroupsPage.addNewOptionButton).click();
        $(playerGroupsPage.optionField).setValue("Portrait");
        $(playerGroupsPage.saveButton).click();
        $(playerGroupsPage.succesSaveAlert).should(Condition.appear);

        $(playerGroupsPage.setScreenTimeTab).click();
        $(playerGroupsPage.screenSettingOption).click();
        $(playerGroupsPage.settingSelector).selectOptionContainingText("Always on");

        $(".list-group>li:nth-child(2)>div").click();
        $("#settings > ul > li:nth-child(2) > div > div.panel-body > div:nth-child(4) > div > select").selectOptionContainingText("General Schedule");
        $(".list-group>li:nth-child(2) #picktime-screenon>input").sendKeys("0700");
        $(".list-group>li:nth-child(2) #picktime-screenonpair>input").sendKeys("1345");

        $(playerGroupsPage.saveButton).click();
        $(playerGroupsPage.succesSaveAlert).should(Condition.appear);
        sleep(3000);
        $(playerGroupsPage.searchField).setValue(groupName);
        sleep(1000);
        $(playerGroupsPage.playerGroupName).click();

        $(playerGroupsPage.setScreenTimeTab).click();
        $(playerGroupsPage.screenSettingOption).click();

        $("#settings > ul > li:nth-child(1) > div > div.panel-body > div:nth-child(4) > div > select>option[selected]").shouldHave(Condition.exactText("Always on"));
        $(".list-group>li:nth-child(2)>div").click();
        $(".list-group>li:nth-child(2) #picktime-screenon").shouldHave(Condition.value("07:00:00"));
        $(".list-group>li:nth-child(2) #picktime-screenonpair").shouldHave(Condition.value("13:45:00"));

    }


}
