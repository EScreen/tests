package clipTest;

import helpers.GenerateData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 16/04/2018.
 */
public class ClipLibraryTest {
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

    //Test of editing name of clip
    @Test
    public void editNameOfClip() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Container container = new Container(driver);
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage(driver);
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);
        GenerateData generateData = new GenerateData();

        container.media.click();
        container.clipLibrary.click();

        clipLibraryPage.settingsClipButton.click();
        clipLibraryPage.editClipButton.click();

        createNewClipPage.templateTestNameField.clear();
        createNewClipPage.templateTestNameField.sendKeys(generateData.generateString(4) + " Edited");


        createNewClipPage.checkAvailableForUsers();

        String createdName = createNewClipPage.templateTestNameField.getAttribute("value");


        createNewClipPage.templateSummaryTab.click();

        WebDriverWait waitFor = new WebDriverWait (driver, 20);
        waitFor.until(ExpectedConditions.elementToBeClickable(createNewClipPage.saveClipButton));
        createNewClipPage.saveClipButton.click();

        String editedName = driver.findElement(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[1]/td[2]/span")).getText();

        Assert.assertEquals(createdName,editedName);


    }


    //Test of appearance "Share clip" table after unchecking "Available for all users" checkbox.
    @Test
    public void appearanceShareClipTable() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Container container = new Container(driver);
        ClipLibraryPage clipLibraryPage = new ClipLibraryPage(driver);
        CreateNewClipPage createNewClipPage = new CreateNewClipPage(driver);


        container.media.click();
        container.clipLibrary.click();

        clipLibraryPage.settingsClipButton.click();
        clipLibraryPage.editClipButton.click();

        createNewClipPage.unCheckAvailableForUsers();

        WebDriverWait waitFor = new WebDriverWait (driver, 20);

        waitFor.until(ExpectedConditions.elementToBeClickable(createNewClipPage.nextButton));
        createNewClipPage.nextButton.click();

        waitFor.until(ExpectedConditions.elementToBeClickable(createNewClipPage.nextButton));
        createNewClipPage.nextButton.click();

        waitFor.until(ExpectedConditions.elementToBeClickable(createNewClipPage.nextButton));
        createNewClipPage.saveClipButton.click();


        String expectedMessage = driver.findElement(By.xpath("//div[@class=\"box-header\"]/span")).getText();
        String message = "Check the box of the user(s) which should have this template available";

        Assert.assertEquals(expectedMessage,message);

    }
}
