package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;
import java.lang.invoke.WrongMethodTypeException;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 06/04/2018.
 */
public class SchedulePage {

    public SelenideElement monthButton = $(By.xpath("//button[@class=\"fc-month-button fc-button fc-state-default fc-corner-left fc-state-active\"]"));
    public SelenideElement weekButton = $(By.xpath("//button[@class=\"fc-agendaWeek-button fc-button fc-state-default\"]"));
    public SelenideElement dayButton = $(By.xpath("//button[@class=\"fc-agendaDay-button fc-button fc-state-default fc-corner-right\"]"));
    public SelenideElement dayDate = $(By.xpath("//div[@class=\"fc-left\"]//h2"));
    public SelenideElement dayName = $(By.xpath("//th[@class=\"fc-day-header fc-widget-header fc-fri fc-today\"]//span"));
    public SelenideElement synchronizeButton = $(By.xpath("//*[@id=\"appcontent\"]/div[4]/section[2]/div/div/div[2]/div/div[1]/div/button"));
    public SelenideElement synchronizeAllButton = $(By.xpath("//div[@ng-click=\"syncalltv()\"]"));
    public SelenideElement selectPlayerDropdawn = $(By.xpath("//select[@ng-change=\"changeDevice()\"]"));


}
