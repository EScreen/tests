package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class Precondition {

    public static void beforeMainUserTests(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();

        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaMainUser", "os123123");

        Configuration.timeout = 20000;

        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

    public static void beforeSubUser1Tests(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();

        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaSubUser1", "os123123");

        Configuration.timeout = 20000;

        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

    public static void beforeSubUser2Tests(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();

        LoginPage loginPage = new LoginPage();
        loginPage.login("AnyaSubUser2", "os123123");

        Configuration.timeout = 20000;

        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

}
