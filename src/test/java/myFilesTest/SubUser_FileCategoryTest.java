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

public class SubUser_FileCategoryTest {

    MainUser_FileCategoryTest mainUserFileCategoryTest = new MainUser_FileCategoryTest();

    @Before
    public void beforeTest(){
        Precondition.beforeSubUser1Tests();
    }
    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createNewCategory() {
        mainUserFileCategoryTest.createNewCategory();
    }

    @Test
    public void editCategoryName() {
        mainUserFileCategoryTest.editCategoryName();
    }

    @Test
    public void deleteCategory() {
        mainUserFileCategoryTest.deleteCategory();
    }

    @Test
    public void addAndDeleteNewCategory() {
        mainUserFileCategoryTest.addAndDeleteNewCategory();
    }
}
