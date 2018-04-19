package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 06/04/2018.
 */
public class PlayerGroupsPage {

    public SelenideElement searchField = $(By.xpath("//*[@id=\"DataTables_Table_0_filter\"]/label/input"));
    public SelenideElement playerGroupName = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[2]/a"));
    public SelenideElement createPlayerGroupButton = $(By.xpath("//li[@class=\"toolbar-link\"]/a"));
    public SelenideElement editPlayerGroupButton = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[4]/div/a[1]"));
    public SelenideElement deletePlayerGroupButton = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody/tr[1]/td[4]/div/a[2]"));
    public SelenideElement YesDeleteButton = $(By.xpath("//div[@class=\"modal-footer\"]/button[2]"));
    public SelenideElement SortByName = $(By.xpath("//*[@id=\"dataTables\"]/table/thead/tr/th[2]/div"));
    public SelenideElement SortByDate = $(By.xpath("//*[@id=\"dataTables\"]/table/thead/tr/th[3]/div"));
    public SelenideElement addNewOptionButton = $(By.xpath("//*[@id=\"dataTables\"]/table/thead/tr/th[3]/div"));
    public SelenideElement playerGroupNameField = $(By.xpath("//*[@id=\"device-tag-name\"]/input"));
    public SelenideElement optionField = $(By.xpath("//*[@id=\"device-tag-options\"]/div/span/input"));
    public SelenideElement removeOptionButton = $(By.xpath("//*[@id=\"device-tag-options\"]/div/button"));
    public SelenideElement saveButton = $(By.xpath("//button[@name=\"save\"]"));
    public SelenideElement backButton = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/section[2]/div/div/div[1]/div/div[2]/div/div[3]/button[2]"));
    public SelenideElement succesSaveAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/flashnotification/div[2]"));
    public SelenideElement succesDeleteAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/section[2]/div/div[1]/flashnotification/div[2]"));


}
