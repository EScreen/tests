package myFilesTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;

public class FileCategoryTest_SubUser {

    FileCategoryTest_MainUser mainUserFileCategoryTest = new FileCategoryTest_MainUser();

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
