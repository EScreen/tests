package clipTest;

import helpers.GenerateData;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 06/04/2018.
 */
public class NewClipTest {
    WebDriver driver;

    @Before
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ppmanager.easyscreen.tv/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login2("AnyaMainUser", "os123123");
    }

    @After
    public void afterTest(){
        driver.quit();
    }

    @org.junit.Test
    public void mainUser_CreateNewClip() throws InterruptedException {
        MainUserDashboardPage mainUserDashboardPage = new MainUserDashboardPage(driver);
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);
        GenerateData genData = new GenerateData();

        mainUserDashboardPage.createClipButton.click();

        createNewClipPage.searchField.sendKeys("FAMAS Plattegrond");

        Thread.sleep(4000);

        WebElement testTemplate = driver.findElement(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div/div/div[1]/div[1]/ul/li/div/a"));
        testTemplate.click();

        String clipName = genData.generateString(6);

        createNewClipPage.templateTestNameField.sendKeys(clipName);
        createNewClipPage.nextButton.click();

        Thread.sleep(3000);

        createNewClipPage.templateTestDurationField.sendKeys("3");
        createNewClipPage.nextButton.click();

        Thread.sleep(3000);

        createNewClipPage.saveClipButton.click();

        Thread.sleep(3000);

        String savedClip = driver.findElement(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[1]/td[2]/span")).getText();
        Assert.assertTrue("The Clip did't save", clipName.equals(savedClip));

    }

    @org.junit.Test
    public void mainUser_CreateAndAddClipToExistedPlayList() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        MainUserDashboardPage mainUserDashboardPage = new MainUserDashboardPage(driver);
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);
        GenerateData genData = new GenerateData();
        Container container = new Container(driver);
        ManagePlaylistsPage managePlaylistsPage = new ManagePlaylistsPage(driver);

        mainUserDashboardPage.createClipButton.click();

        createNewClipPage.searchField.sendKeys("FAMAS Plattegrond");

        WebDriverWait waitFor = new WebDriverWait (driver, 20);
        waitFor.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"template-list\"]/div/div[1]/div/div/div/div[1]/div[1]/ul/li/div/a"))).click();

        String clipName = genData.generateString(6);
        createNewClipPage.templateTestNameField.sendKeys(clipName);


        createNewClipPage.templateExistedPlaylistField.sendKeys("First");
        createNewClipPage.firstExistedPlaylist.click();

        String playListName = driver.findElement(By.xpath("//li[@class=\"ui-select-match-item select2-search-choice ng-scope\"]/span/span")).getText();

        createNewClipPage.nextButton.click();

        createNewClipPage.templateTestDurationField.sendKeys("3");

        Actions actions = new Actions(driver);
        actions.moveToElement(createNewClipPage.nextButton).click().perform();
        Thread.sleep(2000);
        actions.moveToElement(createNewClipPage.saveClipButton).click().perform();

        actions.moveToElement(container.playlists).click();
        actions.moveToElement(container.managePlayLIsts).click();

        managePlaylistsPage.searchField.sendKeys(playListName);

        managePlaylistsPage.nameOfPlayList.click();

        WebElement createdClip = driver.findElement(By.xpath("//*[@id=\"playlist-block\"]/div[2]/table/tbody/tr[1]/td[3]/span"));
        Thread.sleep(3000);
        Assert.assertTrue(createdClip.getText().contains(clipName));


    }

    @org.junit.Test
    public void sortByCategories () throws InterruptedException {
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);
        MainUserDashboardPage mainUserDashboardPage = new MainUserDashboardPage(driver);

        mainUserDashboardPage.createClipButton.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(createNewClipPage.categoriesSelect).click().perform();

        String nameOfCategory1 = createNewClipPage.categoryGetText(createNewClipPage.categoryTest);

        actions.moveToElement(createNewClipPage.categoryTest).click().perform();

        Thread.sleep(3000);

        String nameOfCategory2 = createNewClipPage.nameOfCategory.getText();

        Assert.assertTrue("Filtering doesn't work", nameOfCategory1.equals(nameOfCategory2));

    }

    @org.junit.Test
    public void sortByOrientation(){
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);
        MainUserDashboardPage mainUserDashboardPage = new MainUserDashboardPage(driver);

        mainUserDashboardPage.createClipButton.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(createNewClipPage.orientationSelect).click()
                .moveToElement(createNewClipPage.portraitOrientation).click().perform();

        Assert.assertEquals((createNewClipPage.portraitTemplate).getCssValue("height"), "320px");
    }

    @org.junit.Test
    public void templateSearch() throws InterruptedException {
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);
        MainUserDashboardPage mainUserDashboardPage = new MainUserDashboardPage(driver);

        mainUserDashboardPage.createClipButton.click();

        String searchInput = "FAMAS Reserveringen";

        createNewClipPage.searchField.sendKeys(searchInput);

        Thread.sleep(3000);

        String searchedClip = createNewClipPage.nameOfClip.getText();

        Thread.sleep(3000);

        Assert.assertEquals(searchInput,searchedClip);

    }






}
