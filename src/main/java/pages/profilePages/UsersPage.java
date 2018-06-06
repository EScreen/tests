package pages.profilePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Container;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;

public class UsersPage {

    public SelenideElement searchField = $("input[type='text']");
    public SelenideElement subUser1 = $("tbody>tr:nth-child(1)>td:nth-child(3)>a");
    public SelenideElement subUser2 = $("tbody>tr:nth-child(2)>td:nth-child(3)>a");
    public SelenideElement subU1SettingsButton = $("tbody>tr:nth-child(2)>td:nth-child(3)>a");
    public SelenideElement SubU2SettingsButton = $("tbody>tr:nth-child(2)>td:nth-child(3)>a");



}

