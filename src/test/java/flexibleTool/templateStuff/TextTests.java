package flexibleTool.templateStuff;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.mediaPages.FlexibleToolPage;

import static com.codeborne.selenide.Selenide.*;

public class TextTests {
    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests_Flexible();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void addText(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.templateNameInput).setValue(GenerateData.generateString(3));
        $(flexibleToolPage.templateDurationInput).setValue("4");

        $(flexibleToolPage.textButton).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.textArea).click();
        $(flexibleToolPage.textInput).setValue("ABC");
        $(flexibleToolPage.saveButton).click();

        $(flexibleToolPage.successAlert).shouldBe(Condition.appear);
        open(flexibleToolPage.clipLibrSrc);

        flexibleToolPage.openPreview();
        $("body .cursor").shouldHave(Condition.text("ABC"));
    }

    @Test
    public void deleteText(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.templateNameInput).setValue(GenerateData.generateString(3));
        $(flexibleToolPage.templateDurationInput).setValue("4");

        $(flexibleToolPage.textButton).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.textArea).click();
        $(flexibleToolPage.textInput).setValue("ABC");

        $("div.textBlock.el-tooltip.item").click();
        $(flexibleToolPage.deleteTextButton).click();

        $("div.textBlock.el-tooltip.item").shouldNotBe(Condition.visible);
    }

        
}

