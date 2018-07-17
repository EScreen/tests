package clipTest;

import com.codeborne.selenide.Condition;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.Container;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;

public class ClipLibraryTest_SingleUser {
    ClipLibraryTest_MainUser clipLibraryTest_mainUser = new ClipLibraryTest_MainUser();

    @Before
    public void beforeTest(){
        Precondition.beforeSingleUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void editCLipName(){
        Container container = new Container();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();

        $(container.media).click();
        $(container.clipLibrary).click();

        $(clipLibraryPage.settingsClipButton).click();
        $(clipLibraryPage.editClipButton).click();

        $(createNewClipPage.templateTestNameField).clear();
        $(createNewClipPage.templateTestNameField).setValue(GenerateData.generateString(4) + " Edited");

        sleep(1000);
        String createdName = $(createNewClipPage.templateTestNameField).attr("value");

        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//td//span[@class=\"ng-binding\"]")).shouldHave(Condition.text(createdName));
    }

    @Test
    public void uploadImgToClip() throws IOException {
        clipLibraryTest_mainUser.uploadImgToClip();
    }

    @Test
    public void uploadImgFromLibrToClip(){
        clipLibraryTest_mainUser.uploadImgFromLibrToClip();
    }

    @Test
    public void deleteClip(){
        clipLibraryTest_mainUser.deleteClip();
    }

    @Test
    public void clipSearch() throws InterruptedException {
        clipLibraryTest_mainUser.clipSearch();
    }

    @Test
    public void clipFiltering(){
        clipLibraryTest_mainUser.clipFiltering();
    }


}
