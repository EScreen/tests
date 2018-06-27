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
}
