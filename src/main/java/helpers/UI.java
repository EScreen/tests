package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Anna on 05/04/2018.
 */
public class UI {

    WebDriver driver = new ChromeDriver();

    public void scrollDown (String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("\"arguments[0].scrollIntoView();",element);
    }
}
