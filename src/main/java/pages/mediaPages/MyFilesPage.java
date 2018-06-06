package pages.mediaPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 20/04/2018.
 */
public class MyFilesPage {

    public SelenideElement ownTab = $("li[tooltip-html-unsafe='Own']>a");
    public SelenideElement formulaTab = $("li[tooltip-html-unsafe='Formula']>a");
    public SelenideElement otherTab = $("a[tooltip-html-unsafe='Other']");
    public SelenideElement searchField = $("[ng-model='params.search']");
    public SelenideElement categoryFilter = $(By.xpath("//select[@ng-model=\"data.category\"]"));
    public SelenideElement typeFileFilter = $("[ng-change='changeFiletype()']");
    public SelenideElement uploadFilesButton = $("[ui-sref='media.uploader']");
    public SelenideElement managementCategoriesButton = $("[ui-sref='media.categories']");
    public SelenideElement saveButton = $("button[type='submit']");

    //Upload files page

    public SelenideElement typeSelector = $("select[ng-model='data.type']");
    public SelenideElement categorySelector = $("select[ng-model='data.category']");
    public SelenideElement sectionSelector = $("select[ng-model='data.section']");
    public SelenideElement addFileButton = $("a[pl-url='upload_url']");
    public SelenideElement uploadedFileName = $("#pldrop-zone>tr>td:nth-child(2)");
    public SelenideElement renameFileButton = $("#pldrop-zone>tr>td:nth-child(5) .fa.fa-pencil");
    public SelenideElement setUpFileButton = $("#pldrop-zone>tr>td:nth-child(5) .fa.fa-wrench");
    public SelenideElement newNameField = $("input[ng-model='params.filename']");
    public SelenideElement saveEditionButton = $("button[ng-click='ok()']");
    public SelenideElement cropButton = $(".fa.fa-crop");



}
