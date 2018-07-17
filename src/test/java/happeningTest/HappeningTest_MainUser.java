package happeningTest;

import com.codeborne.selenide.*;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import com.sun.deploy.ref.Helpers;
import com.sun.jdi.connect.spi.TransportService;
import com.sun.tools.corba.se.idl.toJavaPortable.Helper;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Container;
import pages.LoginPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;
import pages.mediaPages.HappeningPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.chord;

public class HappeningTest_MainUser {

    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests();


    }
    @After
    public void afterTest(){
        close();
    }

    @Test
    public void createHappening(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.createButton).click();

        String happName = GenerateData.generateString(3);
        $(happeningPage.nameField).setValue(happName);
        $(happeningPage.saveHappButton).click();
        $(happeningPage.successAlert).should(Condition.appear);

        String title = GenerateData.generateString(4);
        $(happeningPage.titleField).setValue(title);
        String message = GenerateData.generateString(10);
        $(happeningPage.messageField).setValue(message);
        $(happeningPage.sendMessageButton).click();

        $(happeningPage.messageTitle).shouldHave(Condition.exactText(title));
        $(happeningPage.messageText).shouldHave(Condition.exactText(message));
    }

    @Test
    public void createHappeningWithFile(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.createButton).click();

        String happName = GenerateData.generateString(3);
        $(happeningPage.nameField).setValue(happName);
        $(happeningPage.saveHappButton).click();
        $(happeningPage.successAlert).should(Condition.appear);

        $(happeningPage.attachFileButton).click();
        File file = new File("/Users/qa-tester/IdeaProjects/tests/src/main/resources/Smile1.png");
        $(By.xpath("//input[@type=\"file\"]")).uploadFile(file);

        String title = GenerateData.generateString(4);
        $(happeningPage.titleField).setValue(title);
        String message = GenerateData.generateString(10);
        $(happeningPage.messageField).setValue(message);
        $(happeningPage.sendMessageButton).click();

        $(happeningPage.messageTitle).shouldHave(Condition.exactText(title));
        $(happeningPage.messageText).shouldHave(Condition.exactText(message));
        $(happeningPage.messageImg).shouldBe(Condition.visible);
    }

    @Test
    public void editHappName(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.editFirstHapp).click();

        String newName = GenerateData.generateString(3);
        $(happeningPage.nameField).setValue(newName);
        $(happeningPage.saveHappButton).click();
        $(happeningPage.searchField).setValue(newName);

        $(happeningPage.firstHappening).shouldHave(Condition.exactText(newName));
    }

    @Test
    public void editMessage(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.firstHappening).click();
        sleep(1000);

        $(happeningPage.editMessageButton).click();
        $(happeningPage.editTitleField).clear();

        String newTitle = GenerateData.generateString(3);
        $(happeningPage.editTitleField).setValue(newTitle);

        $(happeningPage.editTextField).clear();
        String newText = GenerateData.generateString(10);
        $(happeningPage.editTextField).setValue(newText);
        $(happeningPage.saveEditing).click();

        $(happeningPage.messageTitle).shouldHave(Condition.exactText(newTitle));
        $(happeningPage.messageText).shouldHave(Condition.exactText(newText));
    }

    @Test
    public void editAndAddImgToMessage(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.createButton).click();

        $(happeningPage.nameField).setValue(GenerateData.generateString(3));
        $(happeningPage.saveHappButton).click();
        $(happeningPage.successAlert).should(Condition.appear);

        $(happeningPage.titleField).setValue(GenerateData.generateString(4));
        $(happeningPage.messageField).setValue(GenerateData.generateString(10));
        $(happeningPage.sendMessageButton).click();

        $(happeningPage.editMessageButton).click();
        $(happeningPage.editAttachFile).click();
        File file = new File("/Users/qa-tester/IdeaProjects/tests/src/main/resources/Smile4.jpeg");
        $(By.xpath("//input[@type=\"file\"]")).uploadFile(file);
        sleep(2000);
        $(happeningPage.saveEditing).click();
        $(happeningPage.messageImg).shouldBe(Condition.visible);

    }

    @Test
    public void deleteMessage() {
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.firstHappening).click();
        sleep(1000);
        $(happeningPage.deleteMessageButton).click();

        $(happeningPage.successAlert).should(Condition.appear);
    }

    @Test
    public void deleteHappening(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.deleteFirstHapp).click();
        sleep(1000);
        $(happeningPage.yesDeleteButton).click();

        $(happeningPage.successAlert).should(Condition.appear);
    }


    /*@Test
    public void sU_addHappToRSSTemp() throws Exception {
        WebDriverRunner.getWebDriver().manage().window().fullscreen();
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        Container container = new Container();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue("RSS Feed (3 items) - video to the left");
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.nextButton).click();
        $("div.wizard-card.steps.ng-scope>div>div:nth-child(2)>form>div>div>div>div>span>label>span>i.fa.fa-square").click();

        sleep(2000);
        $(By.xpath("//select[@name='rssurl']/option[contains(. ,'Test Happening')]")).click();
        sleep(2000);


        String link = $("iframe#widgetOverlay").attr("src");
        open(link);

        $("div#widgetData .title").shouldHave(Condition.exactText("Test Title")
                .because("Happening title should be visible"));
        $("div#widgetData #description").shouldBe(Condition.exactText("Test Mesage")
                .because("Happening description should be visible"));
    }*/








}


