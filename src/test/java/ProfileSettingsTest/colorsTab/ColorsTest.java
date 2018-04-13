package ProfileSettingsTest.colorsTab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.Container;
import pages.LoginPage;
import pages.MainUserBasePage;
import pages.ProfileSettingsPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 06/04/2018.
 */
public class ColorsTest {
    WebDriver driver;

    @Before
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ppmanager.easyscreen.tv/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("adminkiev", "twfbinstpi");
    }

    @After
    public void afterTest(){
        driver.quit();
    }


    @Test
    public void addColorTest() throws InterruptedException {

        MainUserBasePage mainUserBasePage = new MainUserBasePage(driver);
        Container container = new Container(driver);

        container.mainUserMenu.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(container.mainUserMenuProfile).click().perform();

        ProfileSettingsPage profileSettingsPage = new ProfileSettingsPage(driver);

        actions.moveToElement(profileSettingsPage.colorsTab).click().perform();

        actions.moveToElement(profileSettingsPage.addColorButton).click().perform();

        Thread.sleep(4000);

        actions.moveToElement(profileSettingsPage.colorPicker).click().perform();
                //.moveByOffset(30, 30).click().perform();

        actions.moveToElement(profileSettingsPage.colorInputField).sendKeys("7e67c7");

        Thread.sleep(4000);

        //actions.moveToElement(profileSettingsPage.colorInputField).click().moveByOffset()
        //.sendKeys("7e67c7");

        actions.moveToElement(profileSettingsPage.saveColorButton).click()
                .moveToElement(profileSettingsPage.saveColoursButton).click().perform();

        Assert.assertTrue(profileSettingsPage.successSaveAlert.isDisplayed());

        Thread.sleep(3000);
    }

}

