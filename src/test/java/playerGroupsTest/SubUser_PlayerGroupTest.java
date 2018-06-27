package playerGroupsTest;

import helpers.Precondition;
import myFilesTest.MainUser_FileCategoryTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_PlayerGroupTest extends MainUser_PlayerGroupsTest {

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Override
    @Test
    public void createPlGroup() {
        super.createPlGroup();
    }

    @Override
    @Test
    public void editOptionName() {
        super.editOptionName();
    }

    @Override
    @Test
    public void editAndAddOption() {
        super.editAndAddOption();
    }

    @Override
    @Test
    public void editRemoveOption() {
        super.editRemoveOption();
    }

    @Override
    @Test
    public void searchPlayer() {
        super.searchPlayer();
    }

    @Override
    @Test
    public void setOptionsMultiply() {
        super.setOptionsMultiply();
    }

    @Override
    @Test
    public void searchGroup() {
        super.searchGroup();
    }

    @Override
    @Test
    public void deleteGroup() {
        super.deleteGroup();
    }

}
