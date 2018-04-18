package clipTest;

import com.codeborne.selenide.WebDriverRunner;
import helpers.GenerateData;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Anna on 18/04/2018.
 */
public class Test {
    WebDriver driver;

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        open("https://ppmanager.easyscreen.tv/login");
        LoginPage loginPage = new LoginPage(driver);
        $(By.name("login")).setValue("AnyaMainUser");
        $(By.name("password")).setValue("os123123");
        $(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[4]/a")).click();
    }


    @org.junit.Test
    public void testForSelenide(){
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

        System.out.println(playListName);


    }
}
