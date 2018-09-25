package helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.Wait;

public class Precondition {

    public static void beforeMainUserTests(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();

        LoginPage.login("AnyaMainUser", "os123123");
        $(By.id("profile-details")).waitUntil(appear, 20000);

        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

    public static void beforeSubUser1Tests(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();

        LoginPage.login("AnyaSubUser1", "os123123");
        $(By.id("profile-details")).waitUntil(appear, 20000);

        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

    public static void beforeSubUser2Tests(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();

        LoginPage.login("AnyaSubUser2", "os123123");
        $(By.id("profile-details")).waitUntil(appear, 20000);

        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

    public static void beforeSingleUserTests(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();

        LoginPage.login("AnyaSingle", "AnyaSingle1");
        $(By.id("profile-details")).waitUntil(appear, 20000);

        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

    public static void beforeMainUserTests_Flexible(){
        WebDriverRunner.setWebDriver(new ChromeDriver());
        WebDriverRunner.getWebDriver().manage().window().maximize();

        LoginPage.login("test_scheduling_mainuser_static", "mainusertest1");
        $(By.id("profile-details")).waitUntil(appear, 20000);

        String handle = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(handle);
    }

}
