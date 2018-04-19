package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.codeborne.selenide.Selenide.$;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 05/04/2018.
 */
public class MainUserDashboardPage {

    public SelenideElement createClipButton = $(By.xpath("//*[@id=\"dushbutton--1\"]/a/div/i"));
    public SelenideElement createPlaylistButton = $(By.xpath("//a[@title=\"Create new playlist\"]"));
    public SelenideElement supportTicketsButton = $(By.xpath("//a[@title=\"Support tickets\"]"));
    public SelenideElement managePlaylistsButton = $(By.xpath("//a[@title=\"Manage playlists\"]"));
    public SelenideElement managePowerBlocksButton = $(By.xpath("//a[@title=\"Manage PowerBlocks\"]"));
    public SelenideElement playersButton = $(By.xpath("//a[@title=\"Players\"]"));

}
