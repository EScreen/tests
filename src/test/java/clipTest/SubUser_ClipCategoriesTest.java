package clipTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class SubUser_ClipCategoriesTest extends MainUser_ClipCategoriesTest {

    @Before
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaSubUser1", "os123123");
        Configuration.timeout = 20000;
        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

    @After
    @Override
    public void afterTest() {
        super.afterTest();
    }

    @Override
    @Test
    public void createCategory() {
        super.createCategory();
    }

    @Override
    @Test
    public void searchCategory() {
        super.searchCategory();
    }

    @Override
    @Test
    public void deleteCategory() {
        super.deleteCategory();
    }

    @Override
    @Test
    public void editCategoryName() {
        super.editCategoryName();
    }
}
