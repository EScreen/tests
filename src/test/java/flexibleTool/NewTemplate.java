package flexibleTool;

import com.codeborne.selenide.Selenide;
import helpers.Precondition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.dashboardPages.MainDashboardPage;
import pages.mediaPages.CreateNewClipPage;
import pages.mediaPages.FlexibleToolPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.sleep;

public class NewTemplate {

    @Before
    public void beforeTests(){
        Precondition.beforeMainUserTests();
    }

    @After
    public void afterTest(){
        close();
    }

    @Test
    public void dragElement(){
        MainDashboardPage mainDashboardPage = new MainDashboardPage();
        CreateNewClipPage createNewClipPage = new CreateNewClipPage();
        FlexibleToolPage flexibleToolPage = new FlexibleToolPage();


        $(mainDashboardPage.createClipButton).click();
        $(createNewClipPage.createCustomTemplate).click();
        $(".el-message__closeBtn.el-icon-close").click();
        sleep(1000);
        $(flexibleToolPage.confirmButton).click();

        //Selenide.executeJavaScript("arguments[0].click();", $(flexibleToolPage.confirmButton));
        sleep(2000);

    }

}
