package flexibleTool;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.sun.deploy.ref.Helpers;
import com.sun.tools.corba.se.idl.toJavaPortable.Helper;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;
import pages.mediaPages.FlexibleToolPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class TmplSettingsTest_MainUser {

    @Before
    public void beforeTests(){
        Precondition.beforeMainUserTests_Flexible();
    }

    @After
    public void afterTest(){
        close();
    }


    @Test
    public void validationTest1(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.saveButton).click();

        sleep(1000);

        $("div.el-message.el-message--error>p").
                shouldHave(Condition.exactText("Please fill in the name field before saving."));
    }

    @Test
    public void validationTest2(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.templateNameInput).setValue(GenerateData.generateString(3));
        $(flexibleToolPage.saveButton).click();

        sleep(1000);

        $("div.el-message.el-message--error>p").
                shouldHave(Condition.exactText("Please fill in duration."));
    }

    @Test
    public void validationTest3(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.templateDurationInput).setValue("3");
        $(flexibleToolPage.saveButton).click();

        sleep(1000);

        $("div.el-message.el-message--error>p").
                shouldHave(Condition.exactText("Please fill in the name field before saving."));
    }

    @Test
    public void undo(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.shapesButton).click();

        $(flexibleToolPage.rectangle).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.square).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.ellipse).dragAndDropTo($(flexibleToolPage.wrapper));

        $(flexibleToolPage.undoButton).click();

        $$(flexibleToolPage.canvasItems).shouldHave(CollectionCondition.size(3));
    }

    @Test
    public void deleteTmpl(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.shapesButton).click();

        $(flexibleToolPage.rectangle).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.square).dragAndDropTo($(flexibleToolPage.wrapper));

        $(flexibleToolPage.deleteTemplateButton).click();
        $("div.el-message-box__btns>button:nth-child(2)").click();

        $$(flexibleToolPage.canvasItems).shouldHave(CollectionCondition.size(1));
    }

    @Test
    public void changingOrientation(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();
        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.shapesButton).click();

        $(flexibleToolPage.rectangle).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.square).dragAndDropTo($(flexibleToolPage.wrapper));

        $(flexibleToolPage.changeOrientationButton).click();

        $("div.orientation>div.image:nth-child(1)").click();
        $(flexibleToolPage.confirmButton).click();
    }

}