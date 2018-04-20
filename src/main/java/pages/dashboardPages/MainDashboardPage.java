package pages.dashboardPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Anna on 18/04/2018.
 */
public class MainDashboardPage {

    public SelenideElement createClipButton = $(By.xpath("//*[@id=\"dushbutton--1\"]/a/div/i"));
    public SelenideElement createPlaylistButton = $(By.xpath("//*[@id=\"dushbutton-0\"]/a/div/span"));
    public SelenideElement supportTicketsButton = $(By.xpath("//*[@id=\"dushbutton-1\"]/a/div/span"));
    public SelenideElement managePlaylists = $(By.xpath("//*[@id=\"dushbutton-2\"]/a/div/span"));
    public SelenideElement managePowerBlocksButton = $(By.xpath("//*[@id=\"dushbutton-4\"]/a/div/span"));
    public SelenideElement playersButton = $(By.xpath("//*[@id=\"dushbutton-5\"]/a/div/span"));
}
