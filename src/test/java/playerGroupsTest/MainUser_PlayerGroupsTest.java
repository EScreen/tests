package playerGroupsTest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
    public void editNameAndAddOption(){
        Container container = new Container();
        PlayerGroupsPage playerGroupsPage = new PlayerGroupsPage();

        $(container.players).click();
        $(container.playerGroups).click();

        String nameBefore = playerGroupsPage.getGroupName($(playerGroupsPage.playerGroupName));
        $(playerGroupsPage.playerGroupName).click();
        String nameAfter = GenerateData.generateString(3);
        $(playerGroupsPage.playerGroupNameField).setValue(nameAfter);

        $(playerGroupsPage.addNewOptionButton).click();
        String newOption = GenerateData.generateString(3);
        $(playerGroupsPage.optionField).setValue(newOption);
        $(playerGroupsPage.saveButton).click();
        sleep(3000);

        $$("div.fht-fixed-body > div.fht-thead > table > thead > tr>th>div:first-child").shouldHave(CollectionCondition.texts(newOption));

        $(playerGroupsPage.saveButton).click();
        $(playerGroupsPage.searchField).setValue(nameAfter);
        sleep(1000);
        String expectedText = nameAfter + " - 4 players";
        $(playerGroupsPage.playerGroupName).shouldHave(Condition.exactText(expectedText));
    }
}
