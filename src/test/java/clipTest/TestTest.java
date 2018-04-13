package clipTest;

import helpers.GenerateData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.CreateNewClipPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 13/04/2018.
 */
public class TestTest {
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

        createNewClipPage.templateforTestNameField.sendKeys(clipName);
        createNewClipPage.nextButton.click();

        Thread.sleep(3000);

        createNewClipPage.templateforTestDurationField.sendKeys("3");
        createNewClipPage.nextButton.click();

        Thread.sleep(3000);

        createNewClipPage.saveClipButton.click();

        Thread.sleep(3000);

        String savedClip = driver.findElement(By.xpath("//*[@id=\"dataTables\"]/table/tbody[1]/tr[1]/td[2]/span")).getText();
        Assert.assertTrue("The Clip did't save", clipName.equals(savedClip));

    }
}
