package pages.mediaPages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by Anna on 16/04/2018.
 */
public class ClipLibraryPage {

    public SelenideElement ownTab = $(By.xpath("//*[@id=\"owned-tab-library\"]/a"));
    public SelenideElement formulaTab = $(By.xpath("//*[@id=\"formula-tab-library\"]/a"));
    public SelenideElement otherTab = $(By.xpath("//*[@id=\"other-tab-library\"]/a"));
    public SelenideElement needApprovalTab = $(By.xpath("//*[@id=\"approve-tab-library\"]/a"));
    public SelenideElement awaitingApprovalTab = $(By.xpath("//*[@id=\"approve-tab-library\"]/a"));

    public SelenideElement searchField = $(By.xpath("//input[@placeholder=\"Search\"]"));
    public SelenideElement categoryDropDawn = $(By.xpath("//select[@ng-change=\"changeCategory()\"]"));
    public SelenideElement managementCategoriesbutton = $(By.xpath("//li[@ng-if=\"manage_cats\"]/a"));
    public SelenideElement settingsClipButton = $(By.xpath("//button[@class=\"btn btn-mini btn-default dropdown-toggle\"]"));
    public SelenideElement editClipButton = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr/td[9]/div/ul/li[2]/a[1]"));
    public SelenideElement denyClipButton = $(By.xpath("//a[@ng-click=\"denyFragment(fragment.ID)\"]"));
    public SelenideElement shareClipButton = $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr/td[9]/div/ul/li[3]/a"));
    public SelenideElement deleteClipButton = $("a[ng-click='deleteFragment(fragment.ID)']");
    public SelenideElement yesDeleteButton = $(By.xpath("//button[@ng-click=\"ok()\"][2]"));
    public SelenideElement successAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/section[2]/div/flashnotification/div[2]/span/strong"));
    public SelenideElement successDeleteAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/section[2]/div/flashnotification/div[2]/span/text()"));
    public SelenideElement deleteClipIfItInPlaylist = $(By.xpath("//button[@class=\"btn btn-green ng-binding\"]"));

    public SelenideElement approveFirstClipCheck = $(".checkbox-table");
    public SelenideElement needAppr_firstClip = $("#dataTables > table > tbody.ng-scope.ng-pristine.ng-valid > tr:nth-child(1) > td:nth-child(3) > div>span");



    public void deleteClipIfItUsedInPlaylist(){
        try{
            sleep(1000);
            $(deleteClipIfItInPlaylist).click();
        }catch (ElementNotFound e){
        }
    }





}
