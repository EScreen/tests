package clipTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class SubUser_ClipCategoriesTest extends MainUser_ClipCategoriesTest {

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }

    @After
    @Override
    public void afterTest() {
        super.afterTest();
    }

    @Override
    @Test
    public void createCategory() {
        super.createCategory();
    }

    @Override
    @Test
    public void searchCategory() {
        super.searchCategory();
    }

    @Override
    @Test
    public void deleteCategory() {
        super.deleteCategory();
    }

    @Override
    @Test
    public void editCategoryName() {
        super.editCategoryName();
    }
}
