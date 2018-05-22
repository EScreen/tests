import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.sun.deploy.ref.Helpers;
import com.sun.tools.corba.se.idl.toJavaPortable.Helper;
import helpers.GenerateData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.LoginPage;
import pages.mediaPages.HappeningPage;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;

public class HappeningTest {

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
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
}


