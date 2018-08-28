package pages.mediaPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FlexibleToolPage {

    public String flToolSrc = "https://ppmanager.easyscreen.tv/main/flextool?server=%2Fflextool&lang=en";
    public String clipLibrSrc = "https://ppmanager.easyscreen.tv/medialibrary";

    public SelenideElement
     wrapper = $("div.ruler_wrapper"),
    confirmButton = $("div.modalFilter > div > div > div.buttons > button > span"),
    infoWindowClose = $(".el-message__closeBtn.el-icon-close"),
    textButton = $(".firstColumn>div:first-child>div>div>i"),
        textArea = $("div.textBlock.el-tooltip.item"),
        textInput = $("div.textBlock.el-tooltip.item>p"),
        deleteButton = $("div.top_bar > div > div > div:nth-child(12) > i"),
    imageButton = $(".firstColumn>div:nth-child(2)>div>div>i"),
        setImage = $("div.setImage>i"),
        uploadButton = $("div.changeContent>span"),
        searchInput = $("input[placeholder='search']"),
        cropButton = $("div.panel>div>i"),
        acceptCropping = $("div.crop_panel > div.left > button:nth-child(3) > span > i"),
        saveCropping = $("div.right >button.el-button.uppercase.el-button--primary"),
    shapesButton = $(".firstColumn>div:nth-child(3)>div>i"),
    templateNameInput = $("div.nameBlock input"),
    templateDurationInput = $("input[placeholder='Duration']"),
    saveButton = $("div.buttons>button:nth-child(4)>i"),
    successAlert = $("body > div.el-message.el-message--success.el-message-fade-leave-active.el-message-fade-leave-to > p");


    public void openPreview(){
        ClipLibraryPage clp = new ClipLibraryPage();

        $(clp.previewClip).click();

        String src = $("#widgetOverlayDiv>iframe[src]").getAttribute("src");
        open(src);
    }




}
