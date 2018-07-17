package clipTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;

public class ClipCategoriesTest_SingleUser {
    ClipCategoriesTest_MainUser clipCategoriesTest_mainUser = new ClipCategoriesTest_MainUser();

    @Before
    public void beforeTest(){
        Precondition.beforeSingleUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createCategory(){
        clipCategoriesTest_mainUser.createCategory();
    }

    @Test
    public void searchCategory(){
        clipCategoriesTest_mainUser.searchCategory();
    }

    @Test
    public void deleteCategory(){
        clipCategoriesTest_mainUser.deleteCategory();
    }

    @Test
    public void editCategoryName(){
        clipCategoriesTest_mainUser.editCategoryName();
    }





}
