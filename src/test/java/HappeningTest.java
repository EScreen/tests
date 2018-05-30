import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.webdriver.WebDriverFactory;
import com.sun.deploy.ref.Helpers;
import com.sun.jdi.connect.spi.TransportService;
import com.sun.tools.corba.se.idl.toJavaPortable.Helper;
import helpers.GenerateData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Container;
import pages.LoginPage;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.CreateNewClipPage;
import pages.mediaPages.HappeningPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;

public class HappeningTest {

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        Configuration.browserSize = "1880x768";
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaMainUser", "os123123");
        Configuration.timeout = 20000;


    }
    @After
    public void afterTest(){
        close();
    }

    @Test
    public void mU_createHappening(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.createButton).click();

        String happName = genData.generateString(3);
        $(happeningPage.nameField).setValue(happName);
        $(happeningPage.saveHappButton).click();
        $(happeningPage.successAlert).should(Condition.appear);

        String title = genData.generateString(4);
        $(happeningPage.titleField).setValue(title);
        String message = genData.generateString(10);
        $(happeningPage.messageField).setValue(message);
        $(happeningPage.sendMessageButton).click();

        $(happeningPage.messageTitle).shouldHave(Condition.exactText(title));
        $(happeningPage.messageText).shouldHave(Condition.exactText(message));
    }

    @Test
    public void mU_createHappeningWithFile(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.createButton).click();

        String happName = genData.generateString(3);
        $(happeningPage.nameField).setValue(happName);
        $(happeningPage.saveHappButton).click();
        $(happeningPage.successAlert).should(Condition.appear);

        $(happeningPage.attachFileButton).click();
        File file = new File("/Users/qa-tester/IdeaProjects/tests/src/main/resources/Smile1.png");
        $(By.xpath("//input[@type=\"file\"]")).uploadFile(file);

        String title = genData.generateString(4);
        $(happeningPage.titleField).setValue(title);
        String message = genData.generateString(10);
        $(happeningPage.messageField).setValue(message);
        $(happeningPage.sendMessageButton).click();

        $(happeningPage.messageTitle).shouldHave(Condition.exactText(title));
        $(happeningPage.messageText).shouldHave(Condition.exactText(message));
        $(happeningPage.messageImg).shouldBe(Condition.visible);
    }

    @Test
    public void mU_editHappName(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.editFirstHapp).click();

        String newName = genData.generateString(3);
        $(happeningPage.nameField).setValue(newName);
        $(happeningPage.saveHappButton).click();
        $(happeningPage.searchField).setValue(newName);

        $(happeningPage.firstHappening).shouldHave(Condition.exactText(newName));
    }

    @Test
    public void mu_editMessage(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.firstHappening).click();
        sleep(1000);

        $(happeningPage.editMessageButton).click();
        $(happeningPage.editTitleField).clear();

        String newTitle = genData.generateString(3);
        $(happeningPage.editTitleField).setValue(newTitle);

        $(happeningPage.editTextField).clear();
        String newText = genData.generateString(10);
        $(happeningPage.editTextField).setValue(newText);
        $(happeningPage.saveEditing).click();

        $(happeningPage.messageTitle).shouldHave(Condition.exactText(newTitle));
        $(happeningPage.messageText).shouldHave(Condition.exactText(newText));
    }

    @Test
    public void mU_editAndAddImgToMessage(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();
        GenerateData genData = new GenerateData();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.createButton).click();

        $(happeningPage.nameField).setValue(genData.generateString(3));
        $(happeningPage.saveHappButton).click();
        $(happeningPage.successAlert).should(Condition.appear);

        $(happeningPage.titleField).setValue(genData.generateString(4));
        $(happeningPage.messageField).setValue(genData.generateString(10));
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
    public void mU_deleteMessage() {
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
    public void mU_deleteHappening(){
        HappeningPage happeningPage = new HappeningPage();
        Container container = new Container();

        $(container.media).click();
        $(container.happening).click();
        $(happeningPage.deleteFirstHapp).click();
        $(happeningPage.yesDeleteButton).click();

        $(happeningPage.successAlert).should(Condition.appear);
    }

    /*@Test
    public void mU_addHapptoRSSTemp(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage();
        Container container = new Container();

        container.goToSubUser2();

        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue("RSS Feed (3 items) - video to the left");
        $(createNewClipPage.newClipButton).click();

        String clipName = genData.generateString(6);
        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.nextButton).click();
        $("div.wizard-card.steps.ng-scope>div>div:nth-child(2)>form>div>div>div>div>span>label>span>i.fa.fa-square").click();
        $(By.xpath("//select[@name=\"rssurl\"]")).selectOption(1);

        //sleep(3000);

        //$("#widgetData>div>div>div.title").shouldHave(Condition.exactText("Test Title")
                //.because("Happening title should displays after adding"));

        $(createNewClipPage.nextButton).click();
        $(By.xpath("//*[@id=\"simplemodal-data\"]/div[4]/div/span[2]/button[4]")).click();
        $(clipLibraryPage.searchField).setValue(clipName);
        $("tr:first-child > td:nth-child(1) > div > div > a > img").click();

        sleep(5000);

        $("#widgetData .text-container>div:nth-child(1)").shouldHave(Condition.exactText("Test Title"));


    }*/








}


