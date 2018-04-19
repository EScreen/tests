package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 16/04/2018.
 */
public class ClipLibraryPage {

    public SelenideElement ownTab = $(By.xpath("//*[@id=\"owned-tab-library\"]/a"));
    public SelenideElement formulaTab = $(By.xpath("//*[@id=\"formula-tab-library\"]/a"));
    public SelenideElement otherTab = $(By.xpath("//*[@id=\"other-tab-library\"]/a"));
    public SelenideElement needApprovalTab = $(By.xpath("//*[@id=\"approve-tab-library\"]/a"));
    public SelenideElement searchField = $(By.xpath("//input[@placeholder=\"Search\"]"));
    public SelenideElement categoryDropDawn = $(By.xpath("//select[@ng-change=\"changeCategory()\"]"));
    public SelenideElement managementCategoriesbutton = $(By.xpath("//li[@ng-if=\"manage_cats\"]/a"));
    public SelenideElement settingsClipButton = $(By.xpath("//button[@class=\"btn btn-mini btn-default dropdown-toggle\"]"));
    public SelenideElement editClipButton = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr/td[9]/div/ul/li[2]/a[1]"));
    public SelenideElement shareClipButton = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr/td[9]/div/ul/li[3]/a"));
    public SelenideElement deleteClipButton = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr/td[9]/div/ul/li[5]/a"));




}
