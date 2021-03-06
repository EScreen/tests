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

    public SelenideElement
            ownTab = $(By.xpath("//*[@id=\"owned-tab-library\"]/a")),
            formulaTab = $(By.xpath("//*[@id=\"formula-tab-library\"]/a")),
            otherTab = $(By.xpath("//*[@id=\"other-tab-library\"]/a")),
            needApprovalTab = $(By.xpath("//*[@id=\"approve-tab-library\"]/a")),
            awaitingApprovalTab = $(By.xpath("//*[@id=\"approve-tab-library\"]/a")),

            searchField = $(By.xpath("//input[@placeholder=\"Search\"]")),
            categoryDropDawn = $(By.xpath("//select[@ng-change=\"changeCategory()\"]")),
            managementCategoriesbutton = $(By.xpath("//li[@ng-if=\"manage_cats\"]/a")),
            clipName = $("table>tbody>tr:first-child>td:nth-child(2)>span"),
            settingsClipButton = $(By.xpath("//button[@class=\"btn btn-mini btn-default dropdown-toggle\"]")),
            editClipButton = $(".icon-edit"),
            denyClipButton = $(By.xpath("//a[@ng-click=\"denyFragment(fragment.ID)\"]")),
            shareClipButton = $("a[ui-sref='fragments.share({id : fragment.ID})']"),
                saveSharing = $("button[type='submit']"),
            deleteClipButton = $("a[ng-click='deleteFragment(fragment.ID)']"),
            yesDeleteButton = $(By.xpath("//button[@ng-click=\"ok()\"][2]")),
            successAlert = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/section[2]/div/flashnotification/div[2]/span/strong")),
            deleteClipIfItInPlaylist = $(By.xpath("//button[@class=\"btn btn-green ng-binding\"]")),
            previewClip = $("#dataTables>table>tbody>tr>td>div"),

            approveFirstClipCheck = $(".checkbox-table"),
            needAppr_firstClip = $("#dataTables > table > tbody.ng-scope.ng-pristine.ng-valid > tr:nth-child(1) > td:nth-child(3) > div>span");



    public void deleteClipIfItUsedInPlaylist(){
        try{
            sleep(1000);
            $(deleteClipIfItInPlaylist).click();
        }catch (ElementNotFound e){ }
    }





}
