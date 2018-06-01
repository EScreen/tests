package clipTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.GenerateData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.LoginPage;
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
        WebDriverRunner.setWebDriver(new ChromeDriver());
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaMainUser", "os123123");
        Configuration.timeout = 20000;
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void mU_createCategory(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagementCategoriesPage managementCategoriesPage = new ManagementCategoriesPage();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.managementCategoriesbutton).click();
        $(managementCategoriesPage.createButton).click();

        $(managementCategoriesPage.nameCategoryField).setValue(genData.generateString(4));
        $(managementCategoriesPage.saveNewCategoryButton).click();

        $(managementCategoriesPage.successAlert).shouldBe(Condition.appears);
    }

    @Test
    public void mU_searchCategory(){
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
    public void mU_deleteCategory(){
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
    public void mU_editCategoryName(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        ManagementCategoriesPage managementCategoriesPage = new ManagementCategoriesPage();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.managementCategoriesbutton).click();

        $(managementCategoriesPage.editCategoryButton).click();
        $(managementCategoriesPage.editCategoryNameField).setValue(genData.generateString(3)).submit();

        $(managementCategoriesPage.successAlert).should(Condition.appears);
    }


}
