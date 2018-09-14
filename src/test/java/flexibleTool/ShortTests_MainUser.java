package flexibleTool;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.Container;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.FlexibleToolPage;

import static com.codeborne.selenide.Selenide.*;

public class ShortTests_MainUser {

    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();
    }

    @After
    public void afterTests(){
        close();
    }

    @Test
    public void subUserCanDuplicateClip_ApproveOff(){
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        Container container = new Container();

        open(flexibleToolPage.flToolSrc);

        $(flexibleToolPage.confirmButton).click();
        $(flexibleToolPage.infoWindowClose).click();
        String clipName = GenerateData.generateString(3);
        $(flexibleToolPage.templateNameInput).setValue(clipName);
        $(flexibleToolPage.templateDurationInput).setValue("4");

        $(flexibleToolPage.shapesButton).click();
        $(flexibleToolPage.rectangle).dragAndDropTo($(flexibleToolPage.wrapper));
        $(flexibleToolPage.saveButton).click();

        open(flexibleToolPage.clipLibrSrc);

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.shareClipButton).click();

        SelenideElement element = $("table>tbody>tr:nth-child(2)>td>div>label");

        Selenide.executeJavaScript("arguments[0].click;", element);
        sleep(3000);

        //$("table>tbody>tr:nth-child(2)>td>div>label").click();
        $(clipLibraryPage.saveSharing).click();

        container.goToSubUser1();

        $(container.media).click();
        $(container.clipLibrary).click();
        $(clipLibraryPage.formulaTab).click();
        $(clipLibraryPage.settingsClipButton).click();
        $("a[ng-click='cloneClip(fragment.ID)']").click();

        $(clipLibraryPage.ownTab).click();
        $(clipLibraryPage.clipName).shouldHave(Condition.exactText(clipName));
    }
}
