package helpers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 05/04/2018.
 */
public class UI {

    public void scrollDown (String selector) {
        SelenideElement element = $(By.cssSelector(selector));
        Selenide.executeJavaScript("arguments[0].scrollIntoView();",element);
        //((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("\"arguments[0].scrollIntoView();",element);
    }
}
