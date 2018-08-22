package pages.mediaPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FlexibleToolPage {

    public String flToolSrc = "https://ppmanager.easyscreen.tv/main/flextool?server=%2Fflextool&lang=en";
    public String clipLibrSrc = "https://ppmanager.easyscreen.tv/medialibrary";

    public SelenideElement
    confirmButton = $("div.modalFilter > div > div > div.buttons > button > span"),
    infoWindowClose = $(".el-message__closeBtn.el-icon-close"),
    textButton = $(".firstColumn>div:first-child>div>div>i"),
        textArea = $("div.textBlock.el-tooltip.item"),
        textInput = $("div.textBlock.el-tooltip.item>p"),
    imageButton = $(".firstColumn>div:nth-child(2)>div>div>i"),
    shapesButton = $(".firstColumn>div:nth-child(3)>div>i"),
    templateNameInput = $("div.nameBlock input"),
    templateDurationInput = $("input[placeholder='Duration']"),
    saveButton = $("div.buttons>button:nth-child(4)>i"),
    successAlert = $("body > div.el-message.el-message--success.el-message-fade-leave-active.el-message-fade-leave-to > p");




}
