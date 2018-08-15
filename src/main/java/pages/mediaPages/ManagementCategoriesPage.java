package pages.mediaPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Anna on 19/04/2018.
 */
public class ManagementCategoriesPage {

    public SelenideElement
            createButton = $(By.xpath("//*[@class=\"box-toolbar\"]//a[@ng-click=\"showCreate = !showCreate\"]")),
            searchField = $(By.xpath("//input[@ng-model=\"search_str\"]")),
            nameCategoryField = $(By.xpath("//input[@ng-model=\"data.newcat_name\"]")),
            saveNewCategoryButton = $(By.xpath("//a[@ng-click=\"createCategory()\"]")),
            successAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/flashnotification/div[2]/span/strong")),
            nameOfCategory = $(By.xpath("//span[@e-form=\"catNameBtn\"]")),
            editCategoryNameField = $(By.xpath("//input[@ng-model=\"$data\"]")),
            deleteCategory = $(By.xpath("//div[@tooltip-html-unsafe=\"Delete\"]")),
            editCategoryButton = $(By.xpath("//div[@tooltip-html-unsafe=\"Edit\"]")),

            yesDeleteCategoryButton = $(By.xpath("//a[@ng-click=\"deleteCategory()\"]"));

    public ElementsCollection categoriesNames = $$("#dataTables>table>tbody>tr>td>span");

}
