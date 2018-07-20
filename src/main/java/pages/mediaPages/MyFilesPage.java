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

    public SelenideElement
            ownTab = $("li[tooltip-html-unsafe='Own']>a"),
            successAlert = $("div[flash-alert='success']>span>strong"),
            formulaTab = $("li[tooltip-html-unsafe='Formula']>a"),
            otherTab = $("a[tooltip-html-unsafe='Other']"),
            searchField = $("[ng-model='params.search']"),
            categoryFilter = $(By.xpath("//select[@ng-model=\"data.category\"]")),
            typeFileFilter = $("[ng-change='changeFiletype()']"),
            uploadFilesButton = $("[ui-sref='media.uploader']"),
            managementCategoriesButton = $("[ui-sref='media.categories']"),
            saveButton = $("button[type='submit']"),
            settingsFileButton = $("i.icon-cog"),
                editFile = $("i.icon-edit"),
                deleteFile = $("i.icon-trash"),
            yesDelete = $("button[ng-click='ok()']:nth-child(2)"),


    //Upload files page

    typeSelector = $("select[ng-model='data.type']"),
    categorySelector = $("select[ng-model='data.category']"),
    sectionSelector = $("select[ng-model='data.section']"),
    addFileButton = $("a[pl-url='upload_url']"),
    uploadedFileName = $("tbody>tr>td:nth-child(2)"),
    renameFileButton = $("#pldrop-zone>tr>td:nth-child(5) .fa.fa-pencil"),
    setUpFileButton = $("#pldrop-zone>tr>td:nth-child(5) .fa.fa-wrench"),
    newNameField = $("input[ng-model='params.filename']"),
    saveEditionButton = $("button[ng-click='ok()']"),
    cropButton = $(".fa.fa-crop"),
    showPortraitCheckBox = $("div.padded>div:nth-child(4)>div>div"),


    //Edit page


    editNameField = $("ul.padded.separate-sections li>input"),
    pickAnotherFileButton = $("#container-filename-uploadelement>a"),


    //Category page

    createCategoryButton = $("i.icon-plus"),
    backButton = $("a.dropdown.ng-binding:nth-child(1)"),
    searchCategoryField = $("[ng-model='params.search_str']"),
    categoryNameField = $("li.input>input"),
    saveCategoryButton = $("a[ng-click='createCategory()']"),
    categorySettingButton = $("i.fa.icon-edit"),
    deleteCategory = $("i.icon-trash"),
    yesDeleteCategory = $("a[ng-click=\"deleteCategory()\"]"),
    newCategoryNameField = $("form[role='form']>div>input"),
    submitButton = $("button[type=\"submit\"]"),
    paginationSelector = $("#DataTables_Table_0_paginate > div > select");
    public ElementsCollection categoryNames = $$("tbody>tr>td>span");


    public void setPagination100(){
        $("select[ng-change='ppagaRowsChange()']").selectOptionByValue("100");
    }

}
