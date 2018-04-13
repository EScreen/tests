package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;
import java.lang.invoke.WrongMethodTypeException;

/**
 * Created by Anna on 06/04/2018.
 */
public class SchedulePage {

    WebDriver driver;

    public SchedulePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@class=\"fc-month-button fc-button fc-state-default fc-corner-left fc-state-active\"]")
    public WebElement monthButton;

    @FindBy(xpath = "//button[@class=\"fc-agendaWeek-button fc-button fc-state-default\"]")
    public WebElement weekButton;

    @FindBy(xpath = "//button[@class=\"fc-agendaDay-button fc-button fc-state-default fc-corner-right\"]")
    public WebElement dayButton;

    @FindBy(xpath = "//div[@class=\"fc-left\"]//h2")
    public WebElement dayDate;

    @FindBy(xpath = "//th[@class=\"fc-day-header fc-widget-header fc-fri fc-today\"]//span")
    public WebElement dayName;

    @FindBy(xpath = "//*[@id=\"appcontent\"]/div[4]/section[2]/div/div/div[2]/div/div[1]/div/button")
    public WebElement synchronizeButton;

    @FindBy(xpath = "//div[@ng-click=\"syncalltv()\"]")
    public WebElement synchronizeAllButton;

    @FindBy(xpath = "//select[@ng-change=\"changeDevice()\"]")
    public WebElement selectPlayerDropdawn;


}
