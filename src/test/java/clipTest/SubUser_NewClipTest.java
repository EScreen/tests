package clipTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.awt.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;

public class SubUser_NewClipTest {
    MainUser_NewClipTest mainUserNewClipTest = new MainUser_NewClipTest();

    @Before
    public void beforeTest() {
        Precondition.beforeSubUser1Tests();
    }

    @After
    public void afterTest() {
        close();
    }

    @Test
    public void createNewClip() {
        mainUserNewClipTest.createNewClip();
    }

    @Test
    public void createClipWithImg() throws AWTException, IOException {
        mainUserNewClipTest.createClipWithImg();
    }

    @Test
    public void createAndAddClipToExistedPlayList() {
        mainUserNewClipTest.createAndAddClipToExistedPlayList();
    }

    @Test
    public void createAndAddClipToNewPlayList() {
        mainUserNewClipTest.createAndAddClipToNewPlayList();
    }

    @Test
    public void sortByCategories() {
        mainUserNewClipTest.sortByCategories();
    }

    @Test
    public void sortTemplatesByOrientation() {
        mainUserNewClipTest.sortTemplatesByOrientation();
    }

    @Test
    public void createClipAndAddImgToLibr() throws AWTException, IOException {
        mainUserNewClipTest.createClipAndAddImgToLibr();
    }
}
