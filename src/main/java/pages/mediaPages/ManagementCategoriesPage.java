package pages.mediaPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 19/04/2018.
 */
public class ManagementCategoriesPage {

    public SelenideElement createButton = $(By.xpath("//*[@class=\"box-toolbar\"]//a[@ng-click=\"showCreate = !showCreate\"]"));
    public SelenideElement searchField = $(By.xpath("//input[@ng-model=\"search_str\"]"));
    public SelenideElement nameCategoryField = $(By.xpath("//input[@ng-model=\"data.newcat_name\"]"));
    public SelenideElement saveNewCategoryButton = $(By.xpath("//a[@ng-click=\"createCategory()\"]"));
    public SelenideElement successAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/flashnotification/div[2]/span/strong"));
    public SelenideElement nameOfCategory = $(By.xpath("//span[@e-form=\"catNameBtn\"]"));
    public SelenideElement editCategoryNameField = $(By.xpath("//input[@ng-model=\"$data\"]"));
    public SelenideElement CheckButton = $(By.xpath("//button[@type=\"submit\"]"));
    public SelenideElement deleteCategory = $(By.xpath("//div[@tooltip-html-unsafe=\"Delete\"]"));
    public SelenideElement editCategoryButton = $(By.xpath("//div[@tooltip-html-unsafe=\"Edit\"]"));

    public SelenideElement yesDeleteCategoryButton = $(By.xpath("//a[@ng-click=\"deleteCategory()\"]"));
    //public SelenideElement  = $(By.xpath(""));
}
