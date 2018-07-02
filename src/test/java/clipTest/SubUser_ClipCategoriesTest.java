package clipTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import playerGroupsTest.MainUser_PlayerGroupsTest;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_ClipCategoriesTest {

    MainUser_ClipCategoriesTest mainUserClipCategoriesTest = new MainUser_ClipCategoriesTest();

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }

    @After
    public void afterTest() {
        close();
    }

    @Test
    public void createCategory() {
        mainUserClipCategoriesTest.createCategory();
    }

    @Test
    public void searchCategory() {
        mainUserClipCategoriesTest.searchCategory();
    }


    @Test
    public void deleteCategory() {
        mainUserClipCategoriesTest.deleteCategory();
    }

    @Test
    public void editCategoryName() {
        mainUserClipCategoriesTest.editCategoryName();
    }
}
