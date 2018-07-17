package clipTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.close;

public class ClipCategoriesTest_SubUser {

    ClipCategoriesTest_MainUser mainUserClipCategoriesTest = new ClipCategoriesTest_MainUser();

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
