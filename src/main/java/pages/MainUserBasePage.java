package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Anna on 05/04/2018.
 */
public class MainUserBasePage {

    WebDriver driver;

    public MainUserBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"dushbutton--1\"]/a/div/i")
    public WebElement createClipButton;

    @FindBy(xpath = "//a[@title=\"Create new playlist\"]")
    public WebElement createPlaylistButton;

    @FindBy(xpath = "//a[@title=\"Support tickets\"]")
    public WebElement supportTicketsButton;

    @FindBy(xpath = "//a[@title=\"Manage playlists\"]")
    public WebElement managePlaylistsButton;

    @FindBy(xpath = "//a[@title=\"Manage PowerBlocks\"]")
    public WebElement managePowerBlocksButton;

    @FindBy(xpath = "//a[@title=\"Players\"]")
    public WebElement playersButton;
}
