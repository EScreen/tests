package pages;

import com.codeborne.selenide.SelenideElement;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Anna on 30/03/2018.
 */
public class LoginPage {

    public static SelenideElement
            loginField = $(By.name("login")),
    passwordField = $(By.name("password")),
    loginButton = $(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[4]/a"));


    public static void login(String login, String password){
        open("https://ppmanager.easyscreen.tv/login");
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
    }

    public static void loginLive(String login, String password){
        open("https://manager.easyscreen.tv/login");
        loginField.setValue(login);
        passwordField.setValue(password);
        loginButton.click();
    }
}
