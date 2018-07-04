package playerGroupsTest;

import helpers.Precondition;
import myFilesTest.MainUser_FileCategoryTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_PlayerGroupTest {
    MainUser_PlayerGroupsTest mainUserPlayerGroupsTest = new MainUser_PlayerGroupsTest();

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createPlGroup() {
        mainUserPlayerGroupsTest.createPlGroup();
    }

    @Test
    public void editOptionName() {
        mainUserPlayerGroupsTest.editOptionName();
    }

    @Test
    public void editAndAddOption() {
        mainUserPlayerGroupsTest.editAndAddOption();
    }

    @Test
    public void editRemoveOption() {
        mainUserPlayerGroupsTest.editRemoveOption();
    }

    @Test
    public void searchPlayer() {
        mainUserPlayerGroupsTest.searchPlayer();
    }

    @Test
    public void setOptionsMultiply() {
        mainUserPlayerGroupsTest.setOptionsMultiply();
    }

    @Test
    public void searchGroup() {
        mainUserPlayerGroupsTest.searchGroup();
    }

    @Test
    public void deleteGroup() {
        mainUserPlayerGroupsTest.deleteGroup();
    }




}
