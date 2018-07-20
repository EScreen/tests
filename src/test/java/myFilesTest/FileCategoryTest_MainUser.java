package myFilesTest;

import com.codeborne.selenide.Condition;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Container;
import pages.mediaPages.MyFilesPage;

import static com.codeborne.selenide.Selenide.*;

public class FileCategoryTest_MainUser {

    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }
    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createNewCategory(){
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.managementCategoriesButton).click();
        $(myFilesPage.createCategoryButton).click();

        String categoryName = GenerateData.generateString(3);
        $(myFilesPage.categoryNameField).setValue(categoryName);
        $(myFilesPage.saveCategoryButton).click();
        myFilesPage.setPagination100();

        String allCategories = $$(myFilesPage.categoryNames).toString();

        Assert.assertTrue(allCategories.contains(categoryName));
    }

    @Test
    public void editCategoryName(){
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.managementCategoriesButton).click();
        $(myFilesPage.paginationSelector).selectOptionContainingText("100");

        String categoryName = $("tbody>tr>td>span").text();
        $(myFilesPage.categorySettingButton).click();

        $(myFilesPage.newCategoryNameField).setValue(categoryName+"123");
        $(myFilesPage.submitButton).click();

        String allCategories = $$(myFilesPage.categoryNames).toString();
        Assert.assertTrue(allCategories.contains(categoryName+"123"));
    }

    @Test
    public void deleteCategory(){
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.managementCategoriesButton).click();
        $(myFilesPage.paginationSelector).selectOptionContainingText("100");

        String categoryName = $("tbody>tr>td>span").text();
        $(myFilesPage.deleteCategory).click();
        $(myFilesPage.yesDeleteCategory).click();

        String strng = $$(myFilesPage.categoryNames).toString();
        Assert.assertFalse(strng.contains(categoryName));
    }

    @Test
    public void addAndDeleteNewCategory(){
        Container container = new Container();
        MyFilesPage myFilesPage = new MyFilesPage();

        String testName = "Test";

        $(container.media).click();
        $(container.myFiles).click();
        $(myFilesPage.managementCategoriesButton).click();
        $(myFilesPage.createCategoryButton).click();

        $(myFilesPage.categoryNameField).setValue(testName);
        $(myFilesPage.saveCategoryButton).click();
        $(myFilesPage.backButton).click();

        $(myFilesPage.settingsFileButton).click();
        $(myFilesPage.editFile).click();
        String xpath = "//ul[@class=\"padded separate-sections\"]/li[3]/select/option[contains(text(),"+"'"+testName+"'"+")]";

        $(By.xpath(xpath)).click();
        $(myFilesPage.saveButton).click();
        $("tbody>tr>td:nth-child(5)").shouldHave(Condition.exactText(testName));

        $(myFilesPage.managementCategoriesButton).click();
        $(myFilesPage.searchCategoryField).setValue(testName);
        sleep(1000);
        $(myFilesPage.deleteCategory).click();
        $(myFilesPage.yesDeleteCategory).click();

        $(container.myFiles).click();
        $("tbody>tr>td:nth-child(5)").shouldBe(Condition.empty);








    }
}
