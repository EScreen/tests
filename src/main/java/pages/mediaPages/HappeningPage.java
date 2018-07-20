package pages.mediaPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HappeningPage {

    public SelenideElement
            createButton = $("#add-feed-tour>a"),
            searchField = $("#DataTables_Table_0_filter  input"),
            nameField = $(".padded.separate-sections>li>input"),
            saveHappButton = $("button.btn.btn-blue.ng-binding"),
            firstHappening = $("#dataTables>table>tbody>tr:first-child>td>a"),
            lastHappening = $("#dataTables>table>tbody>tr:last-child>td>a"),
            editFirstHapp = $("#dataTables>table>tbody>tr:nth-child(1)>td:nth-child(3)>div>a:nth-child(1)>div"),
            deleteFirstHapp = $("#dataTables>table>tbody>tr:nth-child(1)>td:nth-child(3)>div>a:nth-child(2)>div"),
            yesDeleteButton = $(".modal-footer>button:nth-child(2)"),

            successAlert = $(By.xpath("//div[@flash-alert=\"success\"]")),

            attachFileButton = $(By.xpath("//a[@ng-click=\"showAttachFile=!showAttachFile\"]")),
            titleField = $(".box-footer.flat.padded>form>div:nth-child(1)>input"),
            messageField = $(".box-footer.flat.padded>form>div:nth-child(2)>textarea"),
            sendMessageButton = $(".btn.btn-blue.ng-binding"),
            editMessageButton = $(".fa.fa-pencil"),
            deleteMessageButton = $(".fa.fa-trash"),
            editTitleField = $("div.info > span.name > span > input"),
            editTextField = $("div.info>.ng-scope>textarea"),
            editAttachFile = $(By.xpath("//a[@ng-click=\"item.attachFile=!item.attachFile\"]")),
            editDeleteFile = $(By.xpath("//a[@ng-show=\"showDeleteFeedMsgFile\"]")),
            saveEditing = $("div.info > div > button:nth-child(3)"),

            messageTitle = $(".chat-box>li:first-child .name>span>strong>span"),
            messageText = $(".chat-box>li:first-child .info>div>span"),
            messageImg = $(".chat-box>li>div:nth-child(2)>img");



}
