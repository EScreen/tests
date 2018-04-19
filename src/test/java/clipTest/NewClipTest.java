package clipTest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.GenerateData;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Anna on 18/04/2018.
 */
public class NewClipTest {

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        open("https://ppmanager.easyscreen.tv/login");
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaMainUser", "os123123");
        Configuration.timeout = 10000;
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void mainUser_CreateNewClip() {

        MainUserDashboardPage mainUserDashboardPage = new MainUserDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        GenerateData genData = new GenerateData();

        $(mainUserDashboardPage.createClipButton).click();
        $(createNewClipPage.searchField).setValue("FAMAS Plattegrond");
        $(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div/div/div[1]/div[1]/ul/li/div/a")).click();

        String clipName = genData.generateString(6);

        $(createNewClipPage.templateTestNameField).setValue(clipName);
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.templateTestDurationField).setValue("3");
        $(createNewClipPage.nextButton).click();
        $(createNewClipPage.saveClipButton).click();

        $(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[1]/td[2]/span")).shouldBe(Condition.text(clipName));

    }


    @Test
    public void mainUser_CreateAndAddClipToExistedPlayList() throws InterruptedException {
        DashboardPageSel dashboardPageSel = new DashboardPageSel();
        GenerateData genData = new GenerateData();


        $(dashboardPageSel.createClipButton1).click();
        $(dashboardPageSel.searchField1).setValue("FAMAS Plattegrond");
        $(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div/div/div[1]/div[1]/ul/li/div/a")).click();

        String clipName = genData.generateString(6);
        $(dashboardPageSel.templateTestNameField).setValue(clipName);
        $(dashboardPageSel.templateExistedPlaylistField).setValue("First");
        $(dashboardPageSel.firstExistedPlaylist).click();

        String playListName = $(By.xpath("//li[@class=\"ui-select-match-item select2-search-choice ng-scope\"]/span/span")).text();

        $(dashboardPageSel.nextButton).click();
        $(dashboardPageSel.templateTestDurationField).setValue("3");
        $(dashboardPageSel.nextButton).click();
        $(dashboardPageSel.saveClipButton).click();

        $(dashboardPageSel.playlists).click();
        $(dashboardPageSel.managePlaylists).click();

        $(dashboardPageSel.searchField).setValue(playListName);
        sleep(2000);
        $(dashboardPageSel.nameOfPlayList).click();

        $(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table/tbody")).shouldHave(Condition.text(clipName));
    }

    @Test
    public void sortByCategories() throws InterruptedException {
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        MainUserDashboardPage mainUserDashboardPage = new MainUserDashboardPage();

        $(mainUserDashboardPage.createClipButton).click();
        $(createNewClipPage.categoriesSelect).click();

        String nameOfCategory = $(createNewClipPage.category).text();
        $(createNewClipPage.category).click();
        sleep(2000);

        $(createNewClipPage.nameOfActualCategory).shouldHave(Condition.exactText(nameOfCategory));
    }

    @Test
    public void sortByOrientation(){
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        MainUserDashboardPage mainUserDashboardPage = new MainUserDashboardPage();

        $(mainUserDashboardPage.createClipButton).click();
        $(createNewClipPage.orientationSelect).click();
        $(createNewClipPage.portraitOrientation).click();

        $(createNewClipPage.portraitTemplate).shouldHave(Condition.attribute("height", "320"));
    }

    @Test
    public void templateSearch() throws InterruptedException {
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        MainUserDashboardPage mainUserDashboardPage = new MainUserDashboardPage();

        $(mainUserDashboardPage.createClipButton).click();

        String searchInput = "Praktijkcollege Het Plein";

        $(createNewClipPage.searchField).setValue(searchInput);
        Thread.sleep(3000);

        $$(By.xpath("//div[@class=\"template-item ng-scope\"]")).shouldBe(CollectionCondition.size(4));
    }




}
