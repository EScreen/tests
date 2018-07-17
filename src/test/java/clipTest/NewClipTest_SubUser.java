package clipTest;

import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;

public class NewClipTest_SubUser {
    NewClipTest_MainUser mainUserNewClipTest = new NewClipTest_MainUser();

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
