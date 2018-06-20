package pages.mediaPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Anna on 20/04/2018.
 */
public class MyFilesPage {

    public SelenideElement ownTab = $("li[tooltip-html-unsafe='Own']>a");
    public SelenideElement successAlert = $("div[flash-alert='success']>span>strong");
    public SelenideElement formulaTab = $("li[tooltip-html-unsafe='Formula']>a");
    public SelenideElement otherTab = $("a[tooltip-html-unsafe='Other']");
    public SelenideElement searchField = $("[ng-model='params.search']");
    public SelenideElement categoryFilter = $(By.xpath("//select[@ng-model=\"data.category\"]"));
    public SelenideElement typeFileFilter = $("[ng-change='changeFiletype()']");
    public SelenideElement uploadFilesButton = $("[ui-sref='media.uploader']");
    public SelenideElement managementCategoriesButton = $("[ui-sref='media.categories']");
    public SelenideElement saveButton = $("button[type='submit']");
    public SelenideElement settingsFileButton = $("i.icon-cog");
        public SelenideElement editFile = $("i.icon-edit");
        public SelenideElement deleteFile = $("i.icon-trash");
    public SelenideElement yesDelete = $("button[ng-click='ok()']:nth-child(2)");


    //Upload files page

    public SelenideElement typeSelector = $("select[ng-model='data.type']");
    public SelenideElement categorySelector = $("select[ng-model='data.category']");
    public SelenideElement sectionSelector = $("select[ng-model='data.section']");
    public SelenideElement addFileButton = $("a[pl-url='upload_url']");
    public SelenideElement uploadedFileName = $("tbody>tr>td:nth-child(2)");
    public SelenideElement renameFileButton = $("#pldrop-zone>tr>td:nth-child(5) .fa.fa-pencil");
    public SelenideElement setUpFileButton = $("#pldrop-zone>tr>td:nth-child(5) .fa.fa-wrench");
    public SelenideElement newNameField = $("input[ng-model='params.filename']");
    public SelenideElement saveEditionButton = $("button[ng-click='ok()']");
    public SelenideElement cropButton = $(".fa.fa-crop");
    public SelenideElement portraitVideoCheckBox = $("div.padded>div:nth-child(3)>div>div");
    public SelenideElement showPortraitCheckBox = $("div.padded>div:nth-child(4)>div>div");


    //Edit page


    public SelenideElement editNameField = $("ul.padded.separate-sections li>input");
    public SelenideElement pickAnotherFileButton = $("#container-filename-uploadelement>a");


    //Category page

    public SelenideElement createCategoryButton = $("i.icon-plus");
    public SelenideElement backButton = $("a.dropdown.ng-binding:nth-child(1)");
    public SelenideElement searchCategoryField = $("[ng-model='params.search_str']");
    public SelenideElement categoryNameField = $("li.input>input");
    public SelenideElement saveCategoryButton = $("a[ng-click='createCategory()']");
    public ElementsCollection categoryNames = $$("tbody>tr>td>span");
    public SelenideElement categorySettingButton = $("i.fa.icon-edit");
    public SelenideElement deleteCategory = $("i.icon-trash");
    public SelenideElement yesDeleteCategory = $("a[ng-click=\"deleteCategory()\"]");
    public SelenideElement newCategoryNameField = $("form[role='form']>div>input");
    public SelenideElement submitButton = $("button[type=\"submit\"]");
    public SelenideElement paginationSelector = $("#DataTables_Table_0_paginate > div > select");

}
