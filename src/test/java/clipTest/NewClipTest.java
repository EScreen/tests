package clipTest;

import helpers.GenerateData;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.Container;
import pages.CreateNewClipPage;
import pages.LoginPage;

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

    @Test
    public void createNewClip() throws InterruptedException {
        Container container = new Container(driver);
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);
        GenerateData genData = new GenerateData();

        container.media.click();
        container.createNewClip.click();

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

    @Test
    public void sortByCategories () throws InterruptedException {
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);
        Container container = new Container(driver);

        container.media.click();
        container.createNewClip.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(createNewClipPage.categoriesSelect).click().perform();

        String nameOfCategory1 = createNewClipPage.categoryGetText(createNewClipPage.categoryTest);

        actions.moveToElement(createNewClipPage.categoryTest).click().perform();

        Thread.sleep(3000);

        String nameOfCategory2 = createNewClipPage.nameOfCategory.getText();

        Assert.assertTrue("Filtering doesn't work", nameOfCategory1.equals(nameOfCategory2));

    }

    @Test
    public void sortByOrientation(){
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);
        Container container = new Container(driver);

        container.media.click();
        container.createNewClip.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(createNewClipPage.orientationSelect).click()
                .moveToElement(createNewClipPage.portraitOrientation).click().perform();

        Assert.assertEquals((createNewClipPage.portraitTemplate).getCssValue("height"), "320px");
    }

    @Test
    public void templateSearch() throws InterruptedException {
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);
        Container container = new Container(driver);

        container.media.click();
        container.createNewClip.click();

        String searchInput = "FAMAS Reserveringen";

        createNewClipPage.searchField.sendKeys(searchInput);

        Thread.sleep(3000);

        String searchedClip = createNewClipPage.nameOfClip.getText();

        Thread.sleep(3000);

        Assert.assertEquals(searchInput,searchedClip);

    }






}
