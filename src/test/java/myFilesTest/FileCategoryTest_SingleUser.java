package myFilesTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;

public class FileCategoryTest_SingleUser {
    FileCategoryTest_MainUser fileCategoryTest_mainUser = new FileCategoryTest_MainUser();
    @Before
    public void beforeTest(){
        Precondition.beforeSingleUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createHappening(){
        fileCategoryTest_mainUser.createNewCategory();
    }

    @Test
    public void editCategoryName(){
        fileCategoryTest_mainUser.editCategoryName();
    }

    @Test
    public void deleteCategory(){
        fileCategoryTest_mainUser.deleteCategory();
    }

    @Test
    public void addAndDeleteNewCategory(){
        fileCategoryTest_mainUser.addAndDeleteNewCategory();
    }



}
