package pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Anna on 30/03/2018.
 */
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/form/div[1]/input")
    public WebElement loginField;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/form/div[2]/input")
    public WebElement passwordField;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/form/div[4]/a")
    public WebElement loginButton;


    public void login(String login, String password){
        driver.get("https://ppmanager.easyscreen.tv/login");

        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
        driver.findElement(By.xpath("//*[@id=\"right_area\"]/div/div[2]/table/tbody/tr[28]/td[9]/div/table/tbody/tr/td[1]/a")).click();
    }

    public void login2(String login, String password){
        driver.get("https://ppmanager.easyscreen.tv/login");

        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
    }









}
