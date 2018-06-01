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
    @Override
    public void beforeTest(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaSubUser1", "os123123");
        Configuration.timeout = 20000;
    }

    @After
    @Override
    public void afterTest() {
        super.afterTest();
    }

    @Test
    public void sU_createCategory(){
        super.mU_createCategory();
    }

    @Test
    public void sU_searchCategory(){
        super.mU_searchCategory();
    }

    @Test
    public void sU_deleteCategory(){
        super.mU_deleteCategory();
    }

    @Test
    public void sU_editCategoryName(){
        super.mU_editCategoryName();
    }
}
