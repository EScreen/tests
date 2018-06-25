package myFilesTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_FileCategoryTest extends MainUser_FileCategoryTest {
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
    public void createNewCategory() {
        super.createNewCategory();
    }

    @Override
    @Test
    public void editCategoryName() {
        super.editCategoryName();
    }

    @Override
    @Test
    public void deleteCategory() {
        super.deleteCategory();
    }

    @Override
    @Test
    public void addAndDeleteNewCategory() {
        super.addAndDeleteNewCategory();
    }
}
