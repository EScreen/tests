package pages.mediaPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HappeningPage {

    public SelenideElement createButton = $("#add-feed-tour>a");
    public SelenideElement searchField = $("#DataTables_Table_0_filter  input");
    public SelenideElement nameField = $(".padded.separate-sections>li>input");
    public SelenideElement saveHappButton = $("button.btn.btn-blue.ng-binding");
    public SelenideElement firstHappening = $("#dataTables>table>tbody>tr:first-child>td>a");
    public SelenideElement lastHappening = $("#dataTables>table>tbody>tr:last-child>td>a");
    public SelenideElement editFirstHapp = $("#dataTables>table>tbody>tr:nth-child(1)>td:nth-child(3)>div>a:nth-child(1)>div");
    public SelenideElement deleteFirstHapp = $("#dataTables>table>tbody>tr:nth-child(1)>td:nth-child(3)>div>a:nth-child(2)>div");



    public SelenideElement successAlert = $(By.xpath("//div[@flash-alert=\"success\"]"));

    public SelenideElement attachFileButton = $(By.xpath("//a[@ng-click=\"showAttachFile=!showAttachFile\"]"));
    public SelenideElement titleField = $(".box-footer.flat.padded>form>div:nth-child(1)>input");
    public SelenideElement messageField = $(".box-footer.flat.padded>form>div:nth-child(2)>textarea");
    public SelenideElement sendMessageButton = $(".btn.btn-blue.ng-binding");
    public SelenideElement editMessageButton = $(".fa.fa-pencil");
    public SelenideElement editTitleField = $("div.info > span.name > span > input");
    public SelenideElement editTextField = $("div.info>.ng-scope>textarea");
    public SelenideElement editAttachFile = $("//a[@ng-click=\"item.attachFile=!item.attachFile\"]");
    public SelenideElement editDeleteFile = $("//a[@ng-show=\"showDeleteFeedMsgFile\"]");
    public SelenideElement saveEditing = $("div.info > div > button:nth-child(3)");



    public SelenideElement messageTitle = $(".chat-box>li:first-child .name>span>strong>span");
    public SelenideElement messageText = $(".chat-box>li:first-child .info>div>span");
    public SelenideElement messageImg = $(".chat-box>li>div:nth-child(2)>img");



}
