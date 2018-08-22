package flexibleTool;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;
import pages.mediaPages.FlexibleToolPage;

import static com.codeborne.selenide.Selenide.*;

public class NewTemplate {

    @Before
    public void beforeTests(){
        Precondition.beforeMainUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void newClipWithText(){
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        $(flexibleToolPage.templateNameInput).setValue(GenerateData.generateString(3));
        $(flexibleToolPage.templateDurationInput).setValue("4");

        $(flexibleToolPage.textButton).dragAndDropTo($("div.ruler_wrapper"));

        $(flexibleToolPage.textArea).click();
        $(flexibleToolPage.textInput).setValue("ABC");

        $(flexibleToolPage.saveButton).click();

        $(flexibleToolPage.successAlert).shouldBe(Condition.appear);

        open(flexibleToolPage.clipLibrSrc);

        $(clipLibraryPage.previewClip).click();

        String src = $("#widgetOverlayDiv>iframe[src]").getAttribute("src");
        open(src);


        $("body p").shouldHave(Condition.text("ABC"));






    }

}
