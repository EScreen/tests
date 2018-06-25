package clipTest;

import com.codeborne.selenide.Condition;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Container;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.ManagementCategoriesPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.close;

/**
 * Created by Anna on 08/05/2018.
 */
public class MainUser_ClipCategoriesTest {

    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createCategory(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagementCategoriesPage managementCategoriesPage = new ManagementCategoriesPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.managementCategoriesbutton).click();
        $(managementCategoriesPage.createButton).click();

        $(managementCategoriesPage.nameCategoryField).setValue(GenerateData.generateString(4));
        $(managementCategoriesPage.saveNewCategoryButton).click();

        $(managementCategoriesPage.successAlert).shouldBe(Condition.appears);
    }

    @Test
    public void searchCategory(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagementCategoriesPage managementCategoriesPage = new ManagementCategoriesPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.managementCategoriesbutton).click();

        String searchedCategory = $$(By.xpath("//span[@editable-text=\"item.name\"]")).get(2).text();

        $(managementCategoriesPage.searchField).setValue(searchedCategory);

        $(managementCategoriesPage.nameOfCategory).shouldHave(Condition.text(searchedCategory));
    }

    @Test
    public void deleteCategory(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagementCategoriesPage managementCategoriesPage = new ManagementCategoriesPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.managementCategoriesbutton).click();

        String deletedCategoryName = $(managementCategoriesPage.nameOfCategory).text();
        $(managementCategoriesPage.deleteCategory).click();
        $(managementCategoriesPage.yesDeleteCategoryButton).click();

        $(managementCategoriesPage.nameOfCategory).shouldNotHave(Condition.text(deletedCategoryName));
    }

    @Test
    public void editCategoryName(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagementCategoriesPage managementCategoriesPage = new ManagementCategoriesPage();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.managementCategoriesbutton).click();

        $(managementCategoriesPage.editCategoryButton).click();
        $(managementCategoriesPage.editCategoryNameField).setValue(GenerateData.generateString(3)).submit();

        $(managementCategoriesPage.successAlert).should(Condition.appears);
    }


}
