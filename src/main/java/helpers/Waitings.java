package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 05/04/2018.
 */
public class Waitings {

    WebDriver driver = new ChromeDriver();

    public void setImplicityWait(long time, TimeUnit unit){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public WebElement waitFor(ExpectedCondition<WebElement> conditions){
        return new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

    }

}
