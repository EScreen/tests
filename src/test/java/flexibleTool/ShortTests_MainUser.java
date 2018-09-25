package flexibleTool;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.GenerateData;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.Container;
import pages.mediaPages.ClipLibraryPage;
import pages.mediaPages.FlexibleToolPage;

import static com.codeborne.selenide.Selenide.*;

public class ShortTests_MainUser {

    @Before
    public void beforeTest(){
        Precondition.beforeMainUserTests_Flexible();
    }

    @After
    public void afterTests(){
        close();
    }






}
